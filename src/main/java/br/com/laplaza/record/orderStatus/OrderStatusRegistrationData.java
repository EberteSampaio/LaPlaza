package br.com.laplaza.record.orderStatus;

import jakarta.validation.constraints.NotBlank;

public record OrderStatusRegistrationData(
        @NotBlank(message = "Forneça o nome curto do status.")
        String shortName,

        @NotBlank(message = "Forneça a descrição do status.")
        String description
) {


}
