package br.com.laplaza.record.Food;

import br.com.laplaza.model.FoodStatus;
import br.com.laplaza.record.foodStatus.FoodStatusUpdateData;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FoodUpdateData(
        @NotNull
        Long id,

        @NotBlank(message = "Preencha o nome.")
        String name,

        @NotBlank(message = "Preencha a descrição.")
        String description,

        @NotNull(message = "Forneça valores acima de zero.")
        Double value,

        @NotNull(message = "Preencha o status.")
        FoodStatusUpdateData idStatus
) {

}
