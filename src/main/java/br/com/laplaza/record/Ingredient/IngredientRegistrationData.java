package br.com.laplaza.record.Ingredient;

import jakarta.validation.constraints.NotBlank;

public record IngredientRegistrationData(
        @NotBlank(message = "Forneça o nome do ingrediente.")
        String name
) {

}
