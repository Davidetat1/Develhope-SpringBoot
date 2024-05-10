package co.develhope.EsercizioSwagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/name")
public class NameController {
    @Operation(summary = "restituisce il nome dato in input")
    @GetMapping
    public String getname(@RequestParam String name) {
        return name;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operazione completata con successo"),
            @ApiResponse(responseCode = "400", description = "Richiesta non valida")

    })

    @Operation(summary = "restituisce il nome dato in input al contrario ")
    @PostMapping
    public String getReverseName(@RequestBody String name) {
        StringBuilder nameReversed = new StringBuilder(name);
        return nameReversed.reverse().toString();
    }
}

