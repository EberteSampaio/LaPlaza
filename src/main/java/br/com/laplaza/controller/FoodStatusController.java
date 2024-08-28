package br.com.laplaza.controller;

import br.com.laplaza.model.FoodStatus;
import br.com.laplaza.record.foodStatus.FoodStatusListData;
import br.com.laplaza.record.foodStatus.FoodStatusRegistrationData;
import br.com.laplaza.record.foodStatus.FoodStatusUpdateData;
import br.com.laplaza.repository.FoodStatusRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/food-status")
public class FoodStatusController {

    @Autowired
    private FoodStatusRepository foodStatusRepository;

    @Transactional
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody  @Valid FoodStatusRegistrationData newFoodStatus){

        FoodStatus foodStatus = this.foodStatusRepository.save(new FoodStatus(newFoodStatus));

        return ResponseEntity.ok("O novo status "+ foodStatus.getShortName() + " - " + foodStatus.getDescription() + " foi criado com sucesso!");
    }

    @GetMapping("/all")
    public Page<FoodStatusListData> all(@PageableDefault(size = 10, sort = {"description"}) Pageable pageable) {

        return this.foodStatusRepository.findAll(pageable).map(FoodStatusListData::new);
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid FoodStatusUpdateData foodStatusUpdate) throws Exception {

        var foodStatus = this.foodStatusRepository.findById(foodStatusUpdate.id())
                .orElseThrow(() -> new Exception("Status da comida não foi encontrado."));

        if(!foodStatus.updateData(foodStatusUpdate)){

            return ResponseEntity.badRequest().body("Não foi possível atualizar os dados. Verifique os parâmetros passados.");
        }

        return ResponseEntity.ok("Os dados do status da comida foram atualizados.");
    }

    @GetMapping("/find/{shortName}")
    public FoodStatus findFoodStatusByShortName(String shortName) throws Exception {

        FoodStatus foodStatusByshortName  = null;

        if(shortName == null)
            throw new Exception("Não é aceito valores nulos. Informe o nome curto.");

        foodStatusByshortName = this.foodStatusRepository.getReferenceByShortName(shortName);

        if(foodStatusByshortName == null)
            throw new Exception("Não foi encontrado um Status com o nome curto "+ shortName +".");

        return  foodStatusByshortName;
    }

    @GetMapping("/find/{id}")
    public FoodStatus findFoodStatusById(Long id) throws Exception {

        FoodStatus foodStatusById  = null;

        if(id == null)
            throw new Exception("Não é aceito valores nulos");

        foodStatusById = this.foodStatusRepository.getReferenceById(id);

        if(foodStatusById == null)
            throw new Exception("Não foi encontrado um Status com o id "+ id);

        return  foodStatusById;
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){

        var foodStatus = this.foodStatusRepository.getReferenceById(id);

        this.foodStatusRepository.delete(foodStatus);

        return ResponseEntity.ok("Dados deletados com sucesso.");
    }

}
