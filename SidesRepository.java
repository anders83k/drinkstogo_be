package edu.jensen.drinkstogo.Repository;

import edu.jensen.drinkstogo.entity.Sides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SidesRepository extends JpaRepository<Sides, Integer> {
}
