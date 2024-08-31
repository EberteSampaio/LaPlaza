package br.com.laplaza.record.Ingredient;

import br.com.laplaza.model.Ingredient;

import java.time.LocalDateTime;

public record IngredientListData(
        Long id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public IngredientListData(Ingredient ingredient){
        this(ingredient.getId(), ingredient.getName(), ingredient.getCreatedAt(), ingredient.getUpdatedAt());
    }
}
