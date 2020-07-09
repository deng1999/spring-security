package com.deng.controller;

import com.deng.entity.ForRole;
import com.deng.entity.ForUser;
import com.deng.service.RoleService;
import com.deng.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/logout")
    public void logout(){
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/query")
    public String getUserByUsername(@RequestParam("username") String usename,Model model){
        ForUser userByUsername = userService.getUserByUsername(usename);
        model.addAttribute("emps",userByUsername);
        return "user/list";
    }
   @GetMapping("/users")
   @Secured("ROLE_GUEST")
    public String getAll(@RequestParam(required = false,defaultValue = "1") Integer pageNo, Model model){
       PageHelper.startPage(pageNo,2);
       List<ForUser> userAll = userService.getUserAll();
       PageInfo pageInfo=new PageInfo(userAll);
       model.addAttribute("emps",userAll);
       model.addAttribute("fenye",pageInfo);
       return "user/list";
   }
    @RequestMapping("/delete/{uid}")
    public String deleteUserByUid(@PathVariable("uid") Integer uid){
        userService.deleteUserByUid(uid);
        return "redirect:/users";
    }
    @RequestMapping("/insertByUser")
    public  String insertByUser(ForUser forUser){
        return "/user/add";
    }
    @PostMapping("/insertByUser")
    public String insert(ForUser forUser){
        userService.insertUser(forUser);
        return "redirect:/users";
    }
    @RequestMapping("/updatePassword")
    public String updateByUser(Model model){
        String name= SecurityContextHolder.getContext().getAuthentication().getName();
        ForUser userByUsername = userService.getUserByUsername(name);
        model.addAttribute("users",userByUsername);
        return "/user/update";
    }
@RequestMapping("/update")
    public String update(@RequestParam("username") String username,@RequestParam("password") String password){
        userService.updateByUsername(password,username);
        return "redirect:/login";
}
    @RequestMapping("/toAddRolePage/{uid}")
    public String toAddRolePage(Model model, @PathVariable("uid") Integer id,boolean success){
        Map<String, Object> map = userService.toAddRolePage(id);
        model.addAttribute("uid", id);
        model.addAttribute("allRoles", map.get("allRoles"));
        model.addAttribute("myRoles", map.get("myRoles"));
        if(success){
            model.addAttribute("success", "修改成功");
        }
        return "user/roleAdd";
    }
@RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam("ids") Integer[] ids,@RequestParam("uid") Integer uid){
        userService.addRoleToUser(ids, uid);
    return "redirect:/users";
}
}
