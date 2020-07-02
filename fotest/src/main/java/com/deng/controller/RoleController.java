package com.deng.controller;

import com.deng.entity.ForRole;
import com.deng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping("/roles")
    @Secured("ROLE_GUEST")
    public String getRoleAll(Model model){
        List<ForRole> roleAll = roleService.getRoleAll();
        model.addAttribute("roles",roleAll);
        return "/role/list";
    }
    @RequestMapping("/deleteRole/{rid}")
    public String deleteRoleUserByRid(@PathVariable("rid") Integer rid){
        roleService.deleteRoleUserByRid(rid);
        return "redirect:/roles";
    }
    @RequestMapping("/insertRole")
    public String insertRole(){
        return "/role/add";
    }
    @PostMapping("/insertRole")
    public String insert(ForRole forRole){
        roleService.insertRole(forRole);
        return "redirect:/roles";
    }
}
