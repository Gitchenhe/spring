package com.example.demo.service.impl;

import com.example.demo.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by chenhe on 2018/3/2.
 */
@Service
public class RoleServiceImpl implements RoleService {
    private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public Set<String> queryRole(String userName) {
        logger.info("查询用户角色信息,userName={}",userName);
        if (StringUtils.isEmpty(userName)){
            return new HashSet(1);
        }
        return roleAndPermiss.keySet();
    }

    @Override
    public Set<String> QueryPermissions(String userName) {
        logger.info("查询用户权限信息,userName={}",userName);
        Set<String> permissions = new HashSet<>();
        if (StringUtils.isEmpty(userName)){
            return new HashSet<>(1);
        }
        roleAndPermiss.forEach((key,value) -> queryPermissions(key,permissions));
        return permissions;
    }

    private void queryPermissions(String role, Set<String> permissions) {
        permissions.addAll(roleAndPermiss.get(role));
    }


    private HashMap<String, List<String>> roleAndPermiss = new HashMap<>();

    private void addPermiss() {
        List<String> permiss = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            permiss.add("/admin_"+i);
        }
        roleAndPermiss.put("admin",permiss);


        permiss = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            permiss.add("/guest_"+i);
        }
        roleAndPermiss.put("guest",permiss);

        permiss = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            permiss.add("/role1_"+i);
        }
        roleAndPermiss.put("role1",permiss);
    }

    public RoleServiceImpl(){
        addPermiss();
    }
}
