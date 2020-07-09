package com.deng.mapper;

import com.deng.entity.ForForest;
import com.deng.entity.ForLforest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LforestMapper {
    List<ForLforest> getForestAll();
    void  insertByForest(ForLforest forLforest);
    void  deleteByForest(Integer lid);
    void  updateByArea(ForLforest forLforest);
    ForLforest getForest(Integer lid);
}
