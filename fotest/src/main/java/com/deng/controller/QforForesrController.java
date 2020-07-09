package com.deng.controller;

import com.deng.entity.ForDforest;
import com.deng.entity.ForForest;
import com.deng.entity.ForQforest;
import com.deng.mapper.QforestMapper;
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
public class QforForesrController {
    @Autowired
    QforestMapper qforestMapper;

    @RequestMapping("/getQforest")
    public String getForest(@RequestParam(required = false,defaultValue = "1") Integer pageNo, Model model){
        PageHelper.startPage(pageNo,1);
        List<ForQforest> forestAll = qforestMapper.getForestAll();
        PageInfo pageInfo=new PageInfo(forestAll);
        model.addAttribute("forest",forestAll);
        model.addAttribute("fenye",pageInfo);
        return "forest/query/qlist";
    }
    @RequestMapping("/deleteQforest/{qid}")
    public String deleteForest(@PathVariable("qid") Integer qid){
        qforestMapper.deleteByForest(qid);
        return "redirect:/getQforest";
    }
    @RequestMapping("/updateqByArea/{qid}")
    public String updateByArea(@PathVariable("qid") Integer qid,Model model){
        ForQforest forest = qforestMapper.getForest(qid);
        model.addAttribute("forests",forest);
        return "forest/update/qupdate";
    }
    @RequestMapping("/updateQforest")
    public String update(ForQforest forQforest){
        qforestMapper.updateByArea(forQforest);
        return "redirect:/getQforest";
    }
    @RequestMapping("/insertByQforest")
    public String insertByforest(){
        return "forest/add/qadd";
    }
    @RequestMapping("/insertByqforest")
    public String insertByFforest(ForQforest forQforest){
      qforestMapper.insertByForest(forQforest);
        return "redirect:/getQforest";
    }
}
