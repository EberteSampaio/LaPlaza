package br.com.laplaza.record.foodStatus;

import br.com.laplaza.model.FoodStatus;

import java.time.LocalDateTime;

public record FoodStatusListData(Long id, String shortName, String description, LocalDateTime create_at, LocalDateTime updated_at) {

    public FoodStatusListData(FoodStatus foodStatus){
        this(foodStatus.getId(), foodStatus.getShortName(), foodStatus.getDescription(), foodStatus.getCreatedAt(), foodStatus.getUpdatedAt());
    }
}
