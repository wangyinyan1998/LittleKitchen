package com.example.littlekitchen.controller;

import com.example.littlekitchen.dao.ThumbUpMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

@RestController
public class ThumbUpController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ThumbUpMapper thumbUpMapper;

    @GetMapping("/littlekitchen/updates/addthumbup/{menuid}")
    public void addThumbup(HttpSession session, @NotNull @PathVariable("menuid") Integer menuId){
        logger.info("新增点赞");
        int userId = (Integer)(session.getAttribute("userid"));
        thumbUpMapper.addThumbUp(userId,menuId);
    }
    @GetMapping("/littlekitchen/updates/deletethumbup/{menuid}")
    public void deleteThumbup(HttpSession session, @NotNull @PathVariable("menuid") Integer menuId){
        logger.info("取消点赞");
        int userId = (Integer)(session.getAttribute("userid"));
        thumbUpMapper.deleteThumbUp(userId,menuId);
    }



}
