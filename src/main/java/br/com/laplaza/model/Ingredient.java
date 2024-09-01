package br.com.laplaza.model;

import br.com.laplaza.record.Ingredient.IngredientRegistrationData;
import br.com.laplaza.record.Ingredient.IngredientUpdateData;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Table(name = "ingredients")
@Entity(name = "Ingredient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ingredient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime UpdatedAt;


    public Ingredient(IngredientRegistrationData newIngredient){
        this.setName(newIngredient.name());
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    public void updateIngredient(IngredientUpdateData updateData){
        if(updateData.name() != null){
            this.setName(updateData.name());
        }

        this.setUpdatedAt(LocalDateTime.now());
    }

}
