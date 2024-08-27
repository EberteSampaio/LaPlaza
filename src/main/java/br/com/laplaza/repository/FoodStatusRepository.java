package br.com.laplaza.repository;

import br.com.laplaza.model.FoodStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodStatusRepository extends JpaRepository<FoodStatus, Long> {
}
