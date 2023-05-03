package com.campusdual.appmazing.controller;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/contactos")
public class ContactosController {
    @GetMapping
    public String testController(){
        return "Contacts controller works!";
    }

    @PostMapping
    public String testController(@RequestBody String name){
        return "Contacts controller works, " +name + "!";
    }
}
