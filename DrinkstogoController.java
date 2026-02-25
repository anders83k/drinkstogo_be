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
    public List<DrinkstogoDTO> getAllDrinks(){      //eller List<DrinkstogoDTO> alt: getDrinkByID(){
                                                     //fetchalldrinks(); rad 24 & 25 alt: drinkstogoService.getDrinkById(2); plockas bort om man kör list
        return drinkstogoService.getAllDrinks();        //getDrinkById() ex: getDrinkById(2) ;
    }
    @PostMapping
    public DrinkstogoDTO createDrink(@RequestBody DrinkstogoDTO dto){
        return drinkstogoService.saveDrink(dto);
    }

}
