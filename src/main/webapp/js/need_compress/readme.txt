这里存放需要压缩的JS文件
压缩方法:
cmd进入项目根目录,如c:/workspace/RMS/
运行Maven命令:mvn yuicompressor:compress

运行后会把src/main/webapp/js/need_compress下所有JS文件合并到
src/main/webapp/js/common.js中
并生成一个common.min.js
不会影响到其它js,css

详见pom.xml