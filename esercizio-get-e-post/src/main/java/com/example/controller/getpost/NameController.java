package com.example.controller.getpost;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class NameController {

    // Metodo per restituire il nome alla chiamata GET
    @GetMapping ( "/name")
    public String name(@RequestParam String name) {
        return name;
    }

    // Metodo per restituire il nome al contrario alla chiamata POST
    @PostMapping ("/reverse")
    public String reverseName(@RequestParam String name) {
        StringBuilder reversedName = new StringBuilder(name);
        return reversedName.reverse().toString();
    }
}
