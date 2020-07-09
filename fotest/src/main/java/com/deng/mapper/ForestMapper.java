package com.deng.mapper;

import com.deng.entity.ForForest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ForestMapper {
   List<ForForest> getForestAll();
   void  insertByForest(ForForest forForest);
  void  deleteByForest(Integer fid);
  void  updateByArea(ForForest forForest);
   ForForest getForest(Integer fid);
}
