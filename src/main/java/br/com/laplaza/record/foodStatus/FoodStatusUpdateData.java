package br.com.laplaza.record.foodStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FoodStatusUpdateData(
        @NotBlank(message = "Forneça o nome curto do status.")
        @NotNull
        String shortName,

        @NotBlank(message = "Forneça a descrição do status.")
        @NotNull
        String description
) {
}
