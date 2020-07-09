package com.deng.service;

import com.deng.entity.ForForest;
import com.deng.mapper.ForestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForForestService {
    @Autowired
    ForestMapper forestMapper;
public ForForest getForest(Integer fid){
    ForForest forForest = forestMapper.getForest(fid);
    return forForest;
}
    public List<ForForest> getForestAll(){

        List<ForForest> forestAll = forestMapper.getForestAll();
        return forestAll;
    }
    public void  deleteByForest(Integer fid){
        forestMapper.deleteByForest(fid);
    }
    public void updateByArea(ForForest forForest){
        forestMapper.updateByArea(forForest);
    }
    public void insertByForest(ForForest forForest){
        forestMapper.insertByForest(forForest);
    }
}
