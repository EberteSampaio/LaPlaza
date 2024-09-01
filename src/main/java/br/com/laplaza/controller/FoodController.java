package br.com.laplaza.controller;

import br.com.laplaza.model.Food;
import br.com.laplaza.model.FoodStatus;
import br.com.laplaza.record.Food.FoodListData;
import br.com.laplaza.record.Food.FoodRegistrationData;
import br.com.laplaza.record.Food.FoodUpdateData;
import br.com.laplaza.record.foodStatus.FoodStatusListData;
import br.com.laplaza.repository.FoodRepository;
import br.com.laplaza.repository.FoodStatusRepository;
import br.com.laplaza.repository.IngredientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private FoodStatusRepository foodStatusRepository;


    @GetMapping("/all")
    public Page<FoodListData> all(@PageableDefault(size = 10, sort = {"name"})Pageable pageable){
        return this.foodRepository.findAll(pageable).map(FoodListData::new);
    }

    @Transactional
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid FoodRegistrationData newFood){
        Optional<FoodStatus> foodStatus = this.foodStatusRepository.findById(newFood.idStatus().getId());

        if(foodStatus.isEmpty()){
            return ResponseEntity.badRequest().body("Não foi possível cadastrar uma nova comida.");
        }

        Food food = this.foodRepository.save(new Food(newFood));

        return ResponseEntity.ok("Comida cadastrada com sucesso!");
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid FoodUpdateData updateData){

        if(!this.foodRepository.existsById(updateData.id())){
            return ResponseEntity.badRequest().body("Não foi possível achar a comida especificada.");
        }

        Food updateFood = this.foodRepository.getReferenceById(updateData.id());

        updateFood.updateFood(updateData);

        return ResponseEntity.ok("Comida atualizada com sucesso.");
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(!this.foodRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        Food deleteFood = this.foodRepository.getReferenceById(id);

        this.foodRepository.delete(deleteFood);

        return ResponseEntity.ok("Comida deletada com sucesso.");
    }

}
