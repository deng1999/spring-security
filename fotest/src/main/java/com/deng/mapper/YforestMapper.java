package com.deng.mapper;

import com.deng.entity.ForForest;
import com.deng.entity.ForYforest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YforestMapper {
    List<ForYforest> getForestAll();
    void  insertByForest(ForYforest forYforest);
    void  deleteByForest(Integer yid);
    void  updateByArea(ForYforest forYforest);
    ForYforest getForest(Integer yid);
}
