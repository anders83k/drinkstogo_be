package edu.jensen.drinkstogo.controller;

import edu.jensen.drinkstogo.DTO.DrinkstogoDTO;
import edu.jensen.drinkstogo.Service.DrinkstogoService;
import edu.jensen.drinkstogo.entity.Drinkstogo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinkstogo")
public class DrinkstogoController {
    private final DrinkstogoService drinkstogoService;

    public DrinkstogoController(DrinkstogoService drinkstogoService) {
        this.drinkstogoService = drinkstogoService;
    }

    @GetMapping
    public List<DrinkstogoDTO> getAllDrinks(){

        return drinkstogoService.getAllDrinks();
    }
    @GetMapping ("/{id}")
    public DrinkstogoDTO getDrinkById(@PathVariable Integer id){
        return drinkstogoService.getDrinkById(id);
    }
    @PostMapping
    public DrinkstogoDTO createDrink(@RequestBody DrinkstogoDTO dto){
        return drinkstogoService.saveDrink(dto);
    }
    @PutMapping ("/{id}")
    public DrinkstogoDTO updateDrink(@PathVariable Integer id, @RequestBody DrinkstogoDTO dto){
        return drinkstogoService.updateDrink(id, dto);
    }

    @DeleteMapping ("/{id}")
    public void deleteDrink(@PathVariable Integer id) {
        drinkstogoService.deleteDrinkById(id);
    }

}
