package br.com.laplaza.record.Ingredient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IngredientUpdateData(
        @NotNull
        Long id,
        @NotBlank(message = "Forneça o nome do ingrediente.")
        String name
) {
}
