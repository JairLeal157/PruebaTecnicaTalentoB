package com.prueba.peopleplace.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "API ", description = "API Rest")
public class MainController {

     @GetMapping("/")
    public String index() {
         return "API Rest";
     }
}
