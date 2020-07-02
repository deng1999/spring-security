package com.deng.service;

import com.deng.entity.ForRole;
import com.deng.entity.ForUser;
import com.deng.mapper.RolesMapper;
import com.deng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RolesMapper rolesMapper;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
//    登录验证
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ForUser user = userMapper.loadUserByUsername(s);
     if (user==null){
         return null;
     }
        List<ForRole> rolesByUid = rolesMapper.getRolesByUid(user.getUid());
     user.setRoles(rolesByUid);
     return user;
    }
//    插入用户
    public void insertUser(ForUser forUser){
        forUser.setPassword(passwordEncoder.encode(forUser.getPassword()));
        userMapper.insertUser(forUser);
    }
//    查询全部用户
   public List<ForUser> getUserAll(){
        return userMapper.getUserAll();
    }
//    通过账号查询用户
    public ForUser getUserByUsername(String username){
        return userMapper.getUserByUsername(username);
    }
//    删除用户
    public void deleteUserByUid(Integer uid){
        userMapper.deleteUserByUid(uid);
        userMapper.deleteUserRolesByUid(uid);
    }
//    修改密码
    public void updateByUsername(String password,String username){
        ForUser forUser = userMapper.getUserByUsername(username);

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
            String encode = encoder.encode(password);
            forUser.setPassword(encode);
            System.out.println(encode);
            userMapper.updateByUsername(encode,username);
        }
      public ForUser  getUserByUid(Integer uid){
      ForUser userByUid = userMapper.getUserByUid(uid);
      List<ForRole> rolesByUid = rolesMapper.getRolesByUid(uid);
      userByUid.setRoles(rolesByUid);
      return userByUid;
  }
    public Map<String, Object> toAddRolePage(Integer uid) {
        List<ForRole> roleAll = rolesMapper.getRoleAll();
        List<Integer> myRoles = userMapper.findRolesByUid(uid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("allRoles", roleAll);
        map.put("myRoles", myRoles);
        return map;
    }
public void addRoleToUser(Integer[] ids,Integer uid){
        userMapper.deleteUserRolesByUid(uid);
        if (ids.length>0){
            for (Integer rid:ids){
                userMapper.addRoles(uid,rid);
            }
        }
}
}
