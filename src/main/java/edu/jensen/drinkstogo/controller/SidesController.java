package edu.jensen.drinkstogo.controller;

import edu.jensen.drinkstogo.DTO.SidesDTO;
import edu.jensen.drinkstogo.Service.SidesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sides")
public class SidesController {
    private final SidesService sidesService;

    public SidesController(SidesService sidesService){
        this.sidesService = sidesService;
    }
    @GetMapping
    public List<SidesDTO>getAllSides(){
        return sidesService.getAllSides();
    }
    @PostMapping
    public SidesDTO createDishi(@RequestBody SidesDTO dto){
        return sidesService.saveDishi(dto);
    }
}
