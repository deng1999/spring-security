package com.deng.controller;

import com.deng.entity.ForForest;
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
public class ForForesrController {
    @Autowired
    ForForestService forForestService;
    @RequestMapping("/queryForest")
    public String queryForest(){
        return "forest/list";
    }
    @RequestMapping("/insertByForest")
    public String insertByForest(){
        return "forest/add";
    }
    @RequestMapping("/getForest")
    public String getForest(@RequestParam(required = false,defaultValue = "1") Integer pageNo, Model model){
        PageHelper.startPage(pageNo,1);
        List<ForForest> forestAll = forForestService.getForestAll();
        PageInfo pageInfo=new PageInfo(forestAll);
        model.addAttribute("forest",forestAll);
        model.addAttribute("fenye",pageInfo);
        return "forest/query/flist";
    }
    @RequestMapping("/deleteForest/{fid}")
    public String deleteForest(@PathVariable("fid") Integer fid){
        forForestService.deleteByForest(fid);
        return "redirect:/getForest";
    }
    @RequestMapping("/updateByArea/{fid}")
    public String updateByArea(@PathVariable("fid") Integer fid,Model model){
        ForForest forest = forForestService.getForest(fid);
        model.addAttribute("forests",forest);
        return "forest/update/fupdate";
    }
    @RequestMapping("/updateForest")
    public String update(ForForest forForest){
        forForestService.updateByArea(forForest);
        return "redirect:/getForest";
    }
    @RequestMapping("/insertByforest")
    public String insertByforest(){
        return "forest/add/fadd";
    }
    @RequestMapping("/insertByFforest")
    public String insertByFforest(ForForest forForest){
        forForestService.insertByForest(forForest);
        return "redirect:/getForest";
    }
}
