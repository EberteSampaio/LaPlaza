package br.com.laplaza.record.Food;

import br.com.laplaza.model.FoodStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record FoodRegistrationData(
        @NotBlank(message = "Preencha o nome.")
        String name,

        @NotBlank(message = "Preencha a descrição.")
        String description,

        @NotNull(message = "Preencha o preço.")
        @Positive(message = "O valor tem que ser maior que zero." )
        Double value,

        @NotNull(message = "Preencha o status.")
        FoodStatus idStatus
) {
}
