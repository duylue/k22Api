package com.k22Api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ProductController {
    @GetMapping("/list")
    public String view() {
        return "list";
    }

    @GetMapping("/save/{id}")
    public String save(@PathVariable int id, Model model) {
        model.addAttribute("pid",id);
        return "save";
    }

}
