package com.dsp.cms.controller;

import com.dsp.cms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;

/**
 * Created by Saef Rahal on 5/25/2021.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/list")
    public String getCategoryList(Model model){
        model.addAttribute("categories",categoryRepository.findAll());
        return "categories/category-list";
    }

    public String getCategoryShow(){
        return "category-show";
    }


    public String getCategoryCreate(){
        return "category-create";
    }

}
