package org.durcframework.rms.util;

import java.util.ArrayList;
import java.util.List;

import org.durcframework.rms.entity.RSysRes;

public class TreeUtil {

	public static List<RSysRes> buildTreeData(List<RSysRes> list) {

		List<RSysRes> menu = new ArrayList<RSysRes>();

		resolveMenuTree(list, 0, menu);

		return menu;
	}

	public static int resolveMenuTree(List<RSysRes> menus, int parentMenuId,
			List<RSysRes> nodes) {

		int count = 0;
		for (RSysRes menu : menus) {
			if (menu.getParentId() == parentMenuId) {
				RSysRes node = new RSysRes();

				nodes.add(node);
				node.setSrId(menu.getId());
				node.setResName(menu.getText());
				node.setUrl(menu.getUrl());
				node.setParentId(menu.getParentId());

				resolveMenuTree(menus, menu.getId(), node.getChildren());
				count++;
			}
		}
		return count;
	}
}
