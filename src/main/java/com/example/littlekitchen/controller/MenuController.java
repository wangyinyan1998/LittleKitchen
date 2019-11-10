package com.example.littlekitchen.controller;

import com.example.littlekitchen.component.Tools;
import com.example.littlekitchen.dao.MenuMapper;
import com.example.littlekitchen.dao.UserMapper;
import com.example.littlekitchen.entities.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/littlekitchen")
public class MenuController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MenuMapper menuMapper;
    @Autowired
    UserMapper userMapper;

    @GetMapping("/home/recommend")
    public Map<String, Object> getRecommend(){
        logger.info("查询推荐菜单");
        List<Menu> menuList = new ArrayList<>();
        List<Integer> list = menuMapper.getRecommendMenuID();
        for(int i = 0; i < list.size(); i++){
            Menu menu = menuMapper.getMenuById(list.get(i));
            menuList.add(menu);
        }
        return Tools.getMapByMenu(menuList);
    }

    @GetMapping("/home/new")
    public Map<String, Object> getNew(){
        logger.info("查询最新创建的菜单");
        List<Menu> menuList = menuMapper.getNewMenu();
        return Tools.getMapByMenu(menuList);
    }

    @GetMapping("/type/{typeid}")
    public Map<String, Object> getType(@PathVariable("typeid") Integer tid){
        logger.info("查询菜系的菜单");
        List<Menu> menuList = menuMapper.getMenuByType(tid);
        return Tools.getMapByMenu(menuList);
    }

    @GetMapping("/home/search/{keyword}")
    public Map<String, Object> getSearch(@PathVariable("keyword") String searchStr){
        logger.info("搜索菜谱");
        List<Menu> menuList = menuMapper.getSearchMenu(searchStr);
        return Tools.getMapByMenu(menuList);
    }

    @GetMapping("/details/{menuid}")
    public Menu getDetail(@PathVariable("menuid") Integer mid){
        logger.info("查看菜谱详情");
        return menuMapper.getMenuById(mid);
    }

    @PutMapping("")
    public void insertMenu(Menu menu){
        logger.info("创建新菜谱");
        menuMapper.addMenu(menu);
    }

    @PostMapping("")
    public void updateMenu(Menu menu){
        logger.info("更新已创建的菜谱");
        menuMapper.updateMenu(menu);
    }

    @DeleteMapping("")
    public void deleteMenu(Integer mid){
        logger.info("删除已创建的菜谱");
        menuMapper.deleteMenu(mid);
    }
}
