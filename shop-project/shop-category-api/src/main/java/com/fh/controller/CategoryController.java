package com.fh.controller;


import com.fh.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.ResponseServer;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("category")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080")
public class CategoryController {

   @Autowired
   private ICategoryService iCategoryService;

    @GetMapping("queryCategoryList")
    public ResponseServer queryCategoryList(){
        List<Map<String,Object>> categoryList = iCategoryService.queryCategoryList();
        return ResponseServer.success(categoryList);
    }
}
