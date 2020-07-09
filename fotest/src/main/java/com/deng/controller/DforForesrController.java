package com.deng.controller;

import com.deng.entity.ForDforest;
import com.deng.entity.ForForest;
import com.deng.mapper.DforestMapper;
import com.deng.service.ForForestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DforForesrController {
    @Autowired
    DforestMapper dforestMapper;

    @RequestMapping("/getDforest")
//    @Secured({"ROLE_GUEST","ROLE_DINGYUAN","ROLE_USER"})
    public String getForest(@RequestParam(required = false,defaultValue = "1") Integer pageNo, Model model){
        PageHelper.startPage(pageNo,1);
        List<ForDforest> forestAll = dforestMapper.getForestAll();
        PageInfo pageInfo=new PageInfo(forestAll);
        model.addAttribute("forest",forestAll);
        model.addAttribute("fenye",pageInfo);
        return "forest/query/dlist";
    }
    @RequestMapping("/deleteDforest/{did}")
    public String deleteForest(@PathVariable("did") Integer did){
       dforestMapper.deleteByForest(did);
        return "redirect:/getDforest";
    }
    @RequestMapping("/updatedByArea/{did}")
    public String updateByArea(@PathVariable("did") Integer did,Model model){
        ForDforest forest = dforestMapper.getForest(did);
        model.addAttribute("forests",forest);
        return "forest/update/dupdate";
    }
    @RequestMapping("/updateDforest")
    public String update(ForDforest forDforest){
     dforestMapper.updateByArea(forDforest);
        return "redirect:/getDforest";
    }
    @RequestMapping("/insertByDforest")
    public String insertByforest(){
        return "forest/add/dadd";
    }
    @RequestMapping("/insertBydforest")
    public String insertByFforest(ForDforest forDforest){
        dforestMapper.insertByForest(forDforest);
        return "redirect:/getDforest";
    }
}
