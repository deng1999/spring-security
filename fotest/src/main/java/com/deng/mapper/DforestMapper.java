package com.deng.mapper;

import com.deng.entity.ForDforest;
import com.deng.entity.ForForest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DforestMapper {
    List<ForDforest> getForestAll();
    void  insertByForest(ForDforest forDforest);
    void  deleteByForest(Integer did);
    void  updateByArea(ForDforest forDforest);
    ForDforest getForest(Integer did);
}
