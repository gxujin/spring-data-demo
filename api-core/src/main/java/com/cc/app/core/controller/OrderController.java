package com.cc.app.core.controller;

import com.cc.app.core.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping("/save")
    public Integer save(@RequestParam(name="goodname") String goodName){
        return orderService.save(goodName);
    }

    @GetMapping("/save2")
    public Integer save2(@RequestParam(name="goodname") String goodName){
        return orderService.save2(goodName);
    }

    @GetMapping("/get")
    public Object get(@RequestParam(name="id") Integer id){
        return orderService.get(id);
    }

    @GetMapping("/getAll")
    public Object getAll(){
        return orderService.getAll();
    }

    @GetMapping("/save3")
    public Object save3(@RequestParam(name="goodname") String goodName){
        return orderService.save3(goodName);
    }
}