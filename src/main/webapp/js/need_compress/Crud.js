/**
 * var crud = Crud.create({
 *  pk:'id' // 实体类主键
	,addUrl:ctx + 'addDataSource.do' // 添加请求
	,updateUrl:ctx + 'updateDataSource.do' // 修改请求
	,delUrl:ctx + 'delDataSource.do' // 删除请求
	,dlgId:'dlg' // 对话框id
	,formId:'fm' // 表单id
	,girdId:'dg' // 表格id
})
 */
var Crud = (function(){
	
	var EF = function(){return true;};
	
	var CrudClass = function(param){
		this.addUrl = param.addUrl;
		this.listUrl = param.listUrl;
		this.updateUrl = param.updateUrl;
		this.delUrl = param.delUrl;
		this.searchFormId = param.searchFormId;
		this.pk = param.pk;
		this.encryptConfig = param.encryptConfig;
		this.onBeforeSave = param.onBeforeSave || EF;
		
		this.$dlg = $('#'+param.dlgId);
		this.$form = $('#'+param.formId);
		this.$grid = $('#'+param.gridId);
		
		this.gridType = 'datagrid';
		
		this.submitUrl;
	}
	
	CrudClass.prototype = {
		add:function(title){
			title = title || '添加'
			this.$dlg.dialog('open').dialog('setTitle',title);
			this.$form.form('reset');
			this.submitUrl = this.addUrl;
			
			if(this._hasPkInput()){
				this.getPkInput().prop('disabled',false);
			}
		}
		,update:function(row,title){
			title = title || '修改'
			if (row){
				this.$dlg.dialog('open').dialog('setTitle',title);
				this.$form.form('clear').form('load',row);
				
				this.submitUrl = this.updateUrl + ['?',this.pk,'=',row[this.pk]].join('');
				
				// 如果表单中有主键控件,则不能被修改
				if(this._hasPkInput()){
					this.getPkInput().prop('disabled',true);
				}
			}
		}
		,load:function(param){
			this.runGridMethod('load',param);
		}
		,search:function(){
			var data = Crud.getFormData(this.searchFormId);
			this.load(data);
		}
		,runGridMethod:function(methodName,param){
			this.$grid[this.gridType](methodName,param);
		}
		,_hasPkInput:function(){
			return this.getPkInput().length > 0;
		}
		,getPkInput:function(){
			if(!this.pkInput){
				this.pkInput = this.getByName(this.pk);
			}
			return this.pkInput;
		}
		,getByName:function(name){
			return this.$form.find('[name='+name+']');
		}		,del:function(row,msg){
			msg = msg || '确定要删除该数据吗?';
			var self = this;
			if (row){
				$.messager.confirm('Confirm',msg,function(r){
					if (r){
						Action.post(self.delUrl,row,function(result){
							Action.execResult(result,function(result){
								self.runGridMethod('reload');	// reload the user data
							});
						});
					}
				});
			}
		}
		,save:function(){
			var self = this;
			this.$form.form('submit',{
				url: this.submitUrl,
				onSubmit: function(){
					var ret = self.onBeforeSave(self);
					if( (typeof ret != undefined) && ret === false ){
						return false;
					}
					return $(this).form('validate');
				},
				success: function(resultTxt){
					var result = $.parseJSON(resultTxt);
					Action.execResult(result,function(result){
						self.$dlg.dialog('close');		// close the dialog
						self.runGridMethod('reload');	// reload the user data
					});
				}
			});
		}
		,createOperColumn:function(buttons){
			return Crud.createOperColumn(buttons);
		}
		,createEditColumn:function(appendButton){
			appendButton = $.isArray(appendButton) ? appendButton : [];
			var that = this;
			var buttons = [
				{text:'修改',onclick:function(row){
					that.update(row);
				}}
				,{text:'删除',onclick:function(row){
					that.del(row);
				}}
			].concat(appendButton);
			
			return this.createOperColumn(buttons);
		}
		,createOperFormatter:function(buttons){
			return Crud.createOperFormatter(buttons);
		}
		/**
		 * 创建datagrid,options为追加的datagird属性
		 * crud.datagrid([    
			    {field:'name',title:'名称'}  
			    ,{field:'driverClass',title:'驱动'}  
			    ,{field:'driverClass',title:'驱动'}
			    ,{field:'jdbcUrl',title:'连接'}
			    
			],{toolbar:"#toolbar"});
		 */
		,buildGrid:function(columns,options){
			// 默认参数
			var settings = {    
			    url:this.listUrl,columns:[columns],toolbar:'#toolbar'
			    ,pagination:true,fitColumns:true,singleSelect:true,striped:true
			    ,pageSize:20
			};
			// 合并参数
			$.extend(settings, options);
			
			this.$grid.datagrid(settings);
		}
		,buildTreegrid:function(columns,options){
			this.gridType = 'treegrid';
			// 默认参数
			var settings = {    
			    url:this.listUrl,columns:[columns],toolbar:'#toolbar'
			    ,fitColumns:true,animate:true,collapsible:true
			    ,pageSize:20
			};
			// 合并参数
			$.extend(settings, options);
			
			this.$grid.treegrid(settings);
		}
		,closeDlg:function(){
			this.$dlg.dialog('close');
		}
	}
	
	return {
		create:function(param){
			return new CrudClass(param);
		}
		,createOperColumn:function(buttons){
			return {field:'_operate',title:'操作',align:'center',formatter:this.createOperFormatter(buttons)};
		}
		,createOperFormatter:function(buttons){
			buttons = $.isArray(buttons) ? buttons : [];
			// formatter句柄
			var formatterHandler = function(val,row,index){
				var html = [];
				for(var i=0,len=buttons.length; i<len; i++) {
					var button = buttons[i];
					var showFun = button.showFun || function(){return true;}
					// 是否显示
					if(showFun(row)){
						html.push('<a href="javascript:void(0)" onclick="'+FunUtil.createFun(button,'onclick',row,val,index)+'">'+button.text+'</a>')
					}
				}
				return html.join(' | ');
			}
			
			return formatterHandler;
		}
		/**
		 * 获取表单提交参数
		 */
		,getFormData:function(searchFormId){
			var fields = $("#"+searchFormId).serializeArray();
			var obj = {};
			$.each( fields, function(i, field){
				var addValue = field.value;
				// 如果有同样的参数名,他们的值要变成数组形式保存
				if(obj[field.name]){
					var val = obj[field.name];
		
					if($.isArray(val)){
						val.push(addValue);
					}else{
						obj[field.name] = [val,addValue];
					}
				}else{
					obj[field.name] = addValue;
				}
			});
			
			return obj;
		}
	};
	
})();

