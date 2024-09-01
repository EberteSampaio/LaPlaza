package br.com.laplaza.record.Food;

import br.com.laplaza.model.Food;
import br.com.laplaza.model.FoodStatus;
import br.com.laplaza.record.foodStatus.FoodStatusListData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record FoodListData (
        Long id,
        String name,
        String description,
        String idStatus,
        String createdAt,
        String updatedAt
) {
    public FoodListData(Food food){
        this(food.getId(),
                food.getName(),
                food.getDescription(),
                food.getIdStatus().getDescription(),
                food.getCreatedAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                food.getUpdatedAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
