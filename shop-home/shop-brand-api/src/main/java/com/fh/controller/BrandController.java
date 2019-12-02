package com.fh.controller;


import com.fh.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.ResponseServer;


@RestController
@RequestMapping("/brand")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080")
public class BrandController {

    @Autowired
    private IBrandService iBrandService;



    @GetMapping("/{pid}")
    public ResponseServer queryBrandList(@PathVariable("pid") Integer pid){
        return iBrandService.queryBrandList(pid);
    }

}
