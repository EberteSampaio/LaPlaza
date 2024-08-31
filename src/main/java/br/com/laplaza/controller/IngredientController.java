package br.com.laplaza.controller;

import br.com.laplaza.model.Ingredient;
import br.com.laplaza.record.Ingredient.IngredientListData;
import br.com.laplaza.record.Ingredient.IngredientRegistrationData;
import br.com.laplaza.record.Ingredient.IngredientUpdateData;
import br.com.laplaza.repository.IngredientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Transactional
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid IngredientRegistrationData newIngredient){

        this.ingredientRepository.save(new Ingredient(newIngredient));

        return ResponseEntity.ok("O ingrediente foi registrado com sucesso.");
    }

    @GetMapping("/all")
    public Page<IngredientListData> all(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){

        return this.ingredientRepository.findAll(pageable).map(IngredientListData::new);
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid IngredientUpdateData updateData) throws Exception {
        Ingredient ingredient = this.ingredientRepository.getReferenceById(updateData.id());


        ingredient.updateIngredient(updateData);

        return  ResponseEntity.ok("Dados atualizado com sucesso.");
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Ingredient deleteIngredient = this.ingredientRepository.getReferenceById(id);

        this.ingredientRepository.delete(deleteIngredient);

        return ResponseEntity.ok("Ingrediente removido com sucesso.");
    }
}
