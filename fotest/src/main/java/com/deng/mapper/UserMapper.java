package com.deng.mapper;

import com.deng.entity.ForUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
   ForUser loadUserByUsername(String username);
    void   insertUser(ForUser forUser);
  List<ForUser> getUserAll();
    void   deleteUserByUid(Integer uid);
    void   deleteUserRolesByUid(Integer uid);
   ForUser getUserByUsername(String username);
   ForUser getUserByUid(Integer uid);
   void updateByUsername(@Param("password") String password,@Param("username") String username);
    List<Integer> findRolesByUid(Integer uid);
    void addRoles(@Param("user_id") Integer uid,@Param("role_id") Integer id);
}
