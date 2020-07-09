package com.deng.controller;

import com.deng.entity.ForDforest;
import com.deng.entity.ForForest;
import com.deng.entity.ForTforest;
import com.deng.mapper.TforestMapper;
import com.deng.service.ForForestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TforForesrController {
    @Autowired
    TforestMapper tforestMapper;
    @RequestMapping("/getTforest")
    public String getForest(@RequestParam(required = false,defaultValue = "1") Integer pageNo, Model model){
        PageHelper.startPage(pageNo,1);
        List<ForTforest> forestAll = tforestMapper.getForestAll();
        PageInfo pageInfo=new PageInfo(forestAll);
        model.addAttribute("forest",forestAll);
        model.addAttribute("fenye",pageInfo);
        return "forest/query/tflist";
    }
    @RequestMapping("/deleteTforest/{tid}")
    public String deleteForest(@PathVariable("tid") Integer tid){
       tforestMapper.deleteByForest(tid);
        return "redirect:/getTforest";
    }
    @RequestMapping("/updatetByArea/{tid}")
    public String updateByArea(@PathVariable("tid") Integer tid,Model model){
        ForTforest forest = tforestMapper.getForest(tid);
        model.addAttribute("forests",forest);
        return "forest/update/tupdate";
    }
    @RequestMapping("/updateTforest")
    public String update(ForTforest forTforest){
        tforestMapper.updateByArea(forTforest);
        return "redirect:/getTforest";
    }
    @RequestMapping("/insertByTforest")
    public String insertByforest(){
        return "forest/add/tadd";
    }
    @RequestMapping("/insertBytforest")
    public String insertByFforest(ForTforest forTforest){
       tforestMapper.insertByForest(forTforest);
        return "redirect:/getTforest";
    }
}
