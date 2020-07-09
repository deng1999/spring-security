package com.deng.mapper;

import com.deng.entity.ForForest;
import com.deng.entity.ForQforest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QforestMapper {
    List<ForQforest> getForestAll();
    void  insertByForest(ForQforest forQforest);
    void  deleteByForest(Integer qid);
    void  updateByArea(ForQforest forQforest);
    ForQforest getForest(Integer qid);
}
