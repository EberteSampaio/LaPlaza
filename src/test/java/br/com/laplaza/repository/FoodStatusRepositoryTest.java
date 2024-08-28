package br.com.laplaza.repository;

import br.com.laplaza.model.FoodStatus;
import br.com.laplaza.record.foodStatus.FoodStatusRegistrationData;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FoodStatusRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    FoodStatusRepository foodStatusRepository;

    @Test
    @DisplayName("Deve obter o Status pelo nome curto com sucesso")
    void findFoodStatusByIdSuccess(){
        FoodStatusRegistrationData newStatus = new FoodStatusRegistrationData("DISP","DISPONIVEL");
        this.createStatusFood(newStatus);

       Optional<FoodStatus> result = Optional.ofNullable(this.foodStatusRepository.findFoodStatusByShortName(newStatus.shortName()));

       assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Deve falhar ao buscar o nome curto no banco de dados")
    void findFoodStatusByIdError(){
        String shortName = "TEST";

        Optional<FoodStatus> result = Optional.ofNullable(this.foodStatusRepository.findFoodStatusByShortName(shortName));

        assertThat(result.isEmpty()).isTrue();
    }


    private FoodStatus createStatusFood(FoodStatusRegistrationData foodStatus){

        FoodStatus newFoodStatus = new FoodStatus(foodStatus);

        entityManager.persist(newFoodStatus);

        return  newFoodStatus;
    }
}