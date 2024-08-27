package br.com.laplaza.model;

import br.com.laplaza.record.foodStatus.FoodStatusRegistrationData;
import br.com.laplaza.record.foodStatus.FoodStatusUpdateData;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import java.time.LocalDateTime;

@Table  (name = "food_status")
@Entity (name = "FoodStatus")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FoodStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public FoodStatus(FoodStatusRegistrationData foodStatus){
        this.setShortName(foodStatus.shortName());
        this.setDescription(foodStatus.description());
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    public boolean updateData(@Valid FoodStatusUpdateData foodStatusUpdate) {

        if((foodStatusUpdate.shortName() == null) && (foodStatusUpdate.description() == null)){
            return false;
        }

        this.setShortName(foodStatusUpdate.shortName());
        this.setDescription(foodStatusUpdate.description());
        this.setUpdatedAt(LocalDateTime.now());

        return true;
    }
}
