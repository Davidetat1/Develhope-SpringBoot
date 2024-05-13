package co.develhope.EsercizioControllerconProtezionetramiteCORS.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class NameController {

    @GetMapping("/api/name")
    public String getName(@RequestParam String name) {
        return name;
    }

    @PostMapping("/api/reverse-name")
    public String getReverseName(@RequestBody String name) {
        return new StringBuilder(name).reverse().toString();
    }
}
