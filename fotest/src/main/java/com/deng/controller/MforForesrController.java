package com.deng.controller;

import com.deng.entity.ForDforest;
import com.deng.entity.ForForest;
import com.deng.entity.ForMforest;
import com.deng.mapper.MforestMapper;
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
public class MforForesrController {
    @Autowired
    MforestMapper mforestMapper;
    @RequestMapping("/getMforest")
    public String getForest(@RequestParam(required = false,defaultValue = "1") Integer pageNo, Model model){
        PageHelper.startPage(pageNo,1);
        List<ForMforest> forestAll = mforestMapper.getForestAll();
        PageInfo pageInfo=new PageInfo(forestAll);
        model.addAttribute("forest",forestAll);
        model.addAttribute("fenye",pageInfo);
        return "forest/query/mflist";
    }
    @RequestMapping("/deletemForest/{mid}")
    public String deleteForest(@PathVariable("mid") Integer mid){
        mforestMapper.deleteByForest(mid);
        return "redirect:/getMforest";
    }
    @RequestMapping("/updatemByArea/{mid}")
    public String updateByArea(@PathVariable("mid") Integer mid,Model model){
        ForMforest forest = mforestMapper.getForest(mid);
        model.addAttribute("forests",forest);
        return "forest/update/mupdate";
    }
    @RequestMapping("/updateMforest")
    public String update(ForMforest forMforest){
     mforestMapper.updateByArea(forMforest);
        return "redirect:/getMforest";
    }
    @RequestMapping("/insertByMforest")
    public String insertByforest(){
        return "forest/add/madd";
    }
    @RequestMapping("/insertBymforest")
    public String insertByFforest(ForMforest forMforest){
        mforestMapper.insertByForest(forMforest);
        return "redirect:/getMforest";
    }
}
