package com.belajar.belajar_crud.controller;

import com.belajar.belajar_crud.DTO.ProductRequest;
import com.belajar.belajar_crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/test")
        public String getTest(){
        return "Version Belajar CRUD Firs API";
    }
    @PostMapping("/create")
    public String create(@RequestBody ProductRequest productRequest){
        return productService.create(productRequest);
    }
}
