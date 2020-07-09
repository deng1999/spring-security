package com.deng.controller;

import com.deng.entity.ForDforest;
import com.deng.entity.ForForest;
import com.deng.entity.ForYforest;
import com.deng.mapper.YforestMapper;
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
public class YforForesrController {
    @Autowired
    YforestMapper yforestMapper;

    @RequestMapping("/getYforest")
    public String getForest(@RequestParam(required = false,defaultValue = "1") Integer pageNo, Model model){
        PageHelper.startPage(pageNo,1);
        List<ForYforest> forestAll = yforestMapper.getForestAll();
        PageInfo pageInfo=new PageInfo(forestAll);
        model.addAttribute("forest",forestAll);
        model.addAttribute("fenye",pageInfo);
        return "forest/query/ylist";
    }
    @RequestMapping("/deleteYforest/{yid}")
    public String deleteForest(@PathVariable("yid") Integer yid){
        yforestMapper.deleteByForest(yid);
        return "redirect:/getYforest";
    }
    @RequestMapping("/updateyByArea/{yid}")
    public String updateByArea(@PathVariable("yid") Integer yid,Model model){
        ForYforest forest = yforestMapper.getForest(yid);
        model.addAttribute("forests",forest);
        return "forest/update/yupdate";
    }
    @RequestMapping("/updateYforest")
    public String update(ForYforest forYforest){
    yforestMapper.updateByArea(forYforest);
        return "redirect:/getYforest";
    }
    @RequestMapping("/insertByYforest")
    public String insertByforest(){
        return "forest/add/yadd";
    }
    @RequestMapping("/insertByyforest")
    public String insertByFforest(ForYforest forYforest){
      yforestMapper.insertByForest(forYforest);
        return "redirect:/getYforest";
    }
}
