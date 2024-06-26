package com.atguigu.aclservice.helper;

import com.atguigu.aclservice.entity.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 根据权限数据构建菜单数据
 * </p>
 *
 * @author qy
 * @since 2019-11-11
 */
public class PermissionHelper {

    /**
     * 使用递归方法建菜单
     * @param treeNodes
     * @return
     */
    public static List<Permission> bulid(List<Permission> treeNodes) {
        List<Permission> trees = new ArrayList<>();
        for (Permission treeNode : treeNodes) {
            if ("0".equals(treeNode.getPid())) {//必须有一条pid为0，寻找递归的起点，该起点为全部数据也就是最开始的菜单
                treeNode.setLevel(1);//将该父节点设为等级为1级菜单
                trees.add(findChildren(treeNode,treeNodes));
                break;
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点，查找2级，3级等等菜单
     * @param treeNodes
     * @return
     */
    public static Permission findChildren(Permission treeNode,List<Permission> treeNodes) {
        treeNode.setChildren(new ArrayList<Permission>());

        for (Permission it : treeNodes) {
            if(treeNode.getId().equals(it.getPid())) {
                int level = treeNode.getLevel() + 1;
                it.setLevel(level);
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.getChildren().add(findChildren(it,treeNodes));//递归查询
            }
        }
        return treeNode;
    }
}
