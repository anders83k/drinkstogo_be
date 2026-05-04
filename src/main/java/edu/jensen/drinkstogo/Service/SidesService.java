package edu.jensen.drinkstogo.Service;

import edu.jensen.drinkstogo.DTO.SidesDTO;
import edu.jensen.drinkstogo.Repository.SidesRepository;
import edu.jensen.drinkstogo.entity.Sides;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
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
    public SidesDTO getSidesById(Integer id){
        Sides side = sidesRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("No Side of that name found"));

        SidesDTO dto = new SidesDTO();
        dto.setDish(side.getDish());
        dto.setComponents(side.getComponents());
        return dto;
    }

    public SidesDTO saveDishi(SidesDTO dto){
        Sides dishi = new Sides();
        dishi.setDish(dto.getDish());
        dishi.setComponents(dto.getComponents());
       sidesRepository.save(dishi);  //  Sides saveDishi = sidesRepository.save(dishi); radbyte..

        return dto;
    }
    public SidesDTO updateSides(Integer id, SidesDTO dto){
        Sides existingSide = sidesRepository.findById(id).orElse(null);
        if(existingSide==null) {
            return null;
        }
        existingSide.setDish(dto.getDish());
        existingSide.setComponents(dto.getComponents());
        Sides updateSides = sidesRepository.save(existingSide);

        SidesDTO responseDto = new SidesDTO();
        responseDto.setDish(updateSides.getDish());
        responseDto.setComponents(updateSides.getComponents());
        return responseDto;
    }
    public void deleteSideById(Integer id){
        sidesRepository.deleteById(id);
    }

}
