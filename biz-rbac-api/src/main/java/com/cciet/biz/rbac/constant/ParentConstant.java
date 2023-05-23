package com.cciet.biz.rbac.constant;

/**
 * @author cmw
 */
public interface ParentConstant {

    /**
     * 一级
     */
    Long TOP = 0L;

    /**
     * path拼接符
     */
    StringBuffer SPLIT = new StringBuffer("/");


    /**
     * 拼接方法
     * @param parentPath
     * @param selfPath
     * @return
     */
    static String appendPath(String parentPath, Object selfPath) {
        StringBuffer parent = new StringBuffer(parentPath);
        return parent.append(selfPath.toString()).append(ParentConstant.SPLIT).toString();
    }
}
