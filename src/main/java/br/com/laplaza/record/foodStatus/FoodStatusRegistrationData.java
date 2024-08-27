package br.com.laplaza.record.foodStatus;


import jakarta.validation.constraints.NotBlank;

public record FoodStatusRegistrationData(

        @NotBlank(message = "Forneça o nome curto do status.")
        String shortName,

        @NotBlank(message = "Forneça a descrição do status.")
        String description
) {
}
