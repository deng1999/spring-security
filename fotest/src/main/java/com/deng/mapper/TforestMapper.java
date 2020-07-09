package com.deng.mapper;

import com.deng.entity.ForForest;
import com.deng.entity.ForTforest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TforestMapper {
    List<ForTforest> getForestAll();
    void  insertByForest(ForTforest forTforest);
    void  deleteByForest(Integer tid);
    void  updateByArea(ForTforest forTforest);
    ForTforest getForest(Integer tid);
}
