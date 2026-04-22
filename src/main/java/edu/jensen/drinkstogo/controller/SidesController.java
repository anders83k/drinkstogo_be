package edu.jensen.drinkstogo.controller;

import edu.jensen.drinkstogo.DTO.SidesDTO;
import edu.jensen.drinkstogo.Service.SidesService;
import org.springframework.web.bind.annotation.*;
import edu.jensen.drinkstogo.entity.Sides;
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
   @GetMapping("/{id}")
   public SidesDTO getSidesById(@PathVariable Integer id){return sidesService.getSidesById(id);}

    @PostMapping
    public SidesDTO createDishi(@RequestBody SidesDTO dto){
        return sidesService.saveDishi(dto);
    }
    @PutMapping("/{id}")
    public SidesDTO updateSides(@PathVariable Integer id, @RequestBody SidesDTO dto)
    {return sidesService.updateSides(id, dto);
    }
    @DeleteMapping("/{id}")
    public void deleteSide(@PathVariable Integer id){
        sidesService.deleteSideById(id);
    }
}
