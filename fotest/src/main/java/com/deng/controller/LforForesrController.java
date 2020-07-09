package com.deng.controller;

import com.deng.entity.ForDforest;
import com.deng.entity.ForForest;
import com.deng.entity.ForLforest;
import com.deng.mapper.LforestMapper;
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
public class LforForesrController {
    @Autowired
    LforestMapper lforestMapper;

    @RequestMapping("/getLforest")
    public String getForest(@RequestParam(required = false,defaultValue = "1") Integer pageNo, Model model){
        PageHelper.startPage(pageNo,1);
        List<ForLforest> forestAll = lforestMapper.getForestAll();
        PageInfo pageInfo=new PageInfo(forestAll);
        model.addAttribute("forest",forestAll);
        model.addAttribute("fenye",pageInfo);
        return "forest/query/lflist";
    }
    @RequestMapping("/deleteLforest/{lid}")
    public String deleteForest(@PathVariable("lid") Integer lid){
        lforestMapper.deleteByForest(lid);
        return "redirect:/getLforest";
    }
    @RequestMapping("/updatelByArea/{lid}")
    public String updateByArea(@PathVariable("lid") Integer lid,Model model){
        ForLforest forest = lforestMapper.getForest(lid);
        model.addAttribute("forests",forest);
        return "forest/update/lupdate";
    }
    @RequestMapping("/updateLforest")
    public String update(ForLforest forLforest){
        lforestMapper.updateByArea(forLforest);
        return "redirect:/getLforest";
    }
    @RequestMapping("/insertByLforest")
    public String insertByforest(){
        return "forest/add/ladd";
    }
    @RequestMapping("/insertBylforest")
    public String insertByFforest(ForLforest forLforest){
        lforestMapper.insertByForest(forLforest);
        return "redirect:/getLforest";
    }
}
