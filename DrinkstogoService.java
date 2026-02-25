package edu.jensen.drinkstogo.Service;

import edu.jensen.drinkstogo.DTO.DrinkstogoDTO;
import edu.jensen.drinkstogo.Repository.DrinkstogoRepository;
import edu.jensen.drinkstogo.entity.Drinkstogo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrinkstogoService {
    private final DrinkstogoRepository drinkstogoRepository;

    public DrinkstogoService(DrinkstogoRepository drinkstogoRepository){
        this.drinkstogoRepository = drinkstogoRepository;
    }
    public List<DrinkstogoDTO> getAllDrinks(){
        List<Drinkstogo> drinks =drinkstogoRepository.findAll();
        List<DrinkstogoDTO> drinkDTOs = new ArrayList<>();
        for (Drinkstogo drink : drinks){
            DrinkstogoDTO dto = new DrinkstogoDTO();
            dto.setName(drink.getName());
            dto.setRecipe(drink.getRecipe());
            drinkDTOs.add(dto);
        }
        return drinkDTOs;
    }
    public DrinkstogoDTO saveDrink(DrinkstogoDTO dto) {
        Drinkstogo drink = new Drinkstogo();
        drink.setName(dto.getName());
        drink.setRecipe(dto.getRecipe());

        drinkstogoRepository.save(drink);
        return dto;
    }


}
