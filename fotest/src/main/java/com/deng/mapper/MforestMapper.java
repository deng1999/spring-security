package com.deng.mapper;

import com.deng.entity.ForForest;
import com.deng.entity.ForMforest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MforestMapper {
    List<ForMforest> getForestAll();
    void  insertByForest(ForMforest forMforest);
    void  deleteByForest(Integer mid);
    void  updateByArea(ForMforest forMforest);
    ForMforest getForest(Integer mid);
}
