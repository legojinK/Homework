package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@Controller
@RequestMapping("/48th/vueboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueController48th {

    @Autowired
    private ItemService service;


    @GetMapping("/list")
    public ResponseEntity<List<Item>> getVueItemList () {
        log.info("getVueItemList()");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @PostMapping ("/register")
    public ResponseEntity<Item> postRegisterItem (@RequestBody Item item) {
        log.info("postRegisterItem()" );

        service.register(item);

        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/{itemNo}")
    public ResponseEntity<Item> getVueItemRead(@PathVariable ("itemNo") Integer itemNo){
        log.info("getVueItemRead()");

        Item item= service.read(itemNo);

        return new ResponseEntity<>(item,HttpStatus.OK);
    }




}
