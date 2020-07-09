package com.deng.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleControllerException {
//    @ExceptionHandler(RuntimeException.class)
//    public String expectionHandler(RuntimeException e){
//        if (e instanceof AccessDeniedException){
//            return "redirect:/error/403";
//        }
//        return "redirect:/error/404";
//    }
}
