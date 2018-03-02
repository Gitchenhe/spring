package com.example.demo.service;

import java.util.Set;

/**
 * Created by chenhe on 2018/3/2.
 */
public interface RoleService {
    /**
     * 查询角色
     * @return
     */
    Set<String> queryRole(String userName);

    /**
     * 查询权限
     * @return
     */
    Set<String> QueryPermissions(String userName);
}
