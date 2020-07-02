package com.deng.service;

import com.deng.entity.ForRole;
import com.deng.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RolesMapper rolesMapper;
    public List<ForRole> getRoleAll() {
        return rolesMapper.getRoleAll();
    }
    public void deleteRoleUserByRid(Integer rid){
        rolesMapper.deleteByRid(rid);
        rolesMapper.deleteRoleUserByRid(rid);
    }
    public void insertRole(ForRole forRole){
        rolesMapper.insertRole(forRole);
    }
}
