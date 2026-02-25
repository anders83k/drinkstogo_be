package edu.jensen.drinkstogo.Repository;

import edu.jensen.drinkstogo.entity.Drinkstogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkstogoRepository extends JpaRepository<Drinkstogo, Integer> {
}
