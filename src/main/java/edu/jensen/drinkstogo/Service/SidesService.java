package edu.jensen.drinkstogo.Service;

import edu.jensen.drinkstogo.DTO.SidesDTO;
import edu.jensen.drinkstogo.Repository.SidesRepository;
import edu.jensen.drinkstogo.entity.Sides;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SidesService {
    private final SidesRepository sidesRepository;
    public SidesService(SidesRepository sidesRepository){
        this.sidesRepository = sidesRepository;
    }
    public List<SidesDTO> getAllSides(){
        List<Sides> dishes = sidesRepository.findAll();
        List<SidesDTO> sidesDTOS = new ArrayList<>();
        for (Sides dishi: dishes){
            SidesDTO dto = new SidesDTO();
            dto.setDish(dishi.getDish());
            dto.setComponents(dishi.getComponents());
            sidesDTOS.add(dto);
        }
        return sidesDTOS;
    }
    public SidesDTO saveDishi(SidesDTO dto){
        Sides dishi = new Sides();
        dishi.setDish(dto.getDish());
        dishi.setComponents(dto.getComponents());
       sidesRepository.save(dishi);  //  Sides saveDishi = sidesRepository.save(dishi); radbyte..

        return dto;
    }

}
