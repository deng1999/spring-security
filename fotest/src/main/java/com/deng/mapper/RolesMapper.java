package com.deng.mapper;

import com.deng.entity.ForRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolesMapper {
   List<ForRole> getRolesByUid(Integer uid);
   List<ForRole> getRoleAll();
  void deleteByRid(Integer rid);
  void deleteRoleUserByRid(Integer rid);
  void  insertRole(ForRole forRole);
}
