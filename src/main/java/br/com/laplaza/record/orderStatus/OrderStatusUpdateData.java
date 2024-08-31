package br.com.laplaza.record.orderStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderStatusUpdateData(
        @NotNull
        Long id,

        @NotBlank(message = "Forneça o nome curto do status.")
        String shortName,

        @NotBlank(message = "Forneça a descrição do status.")
        String description
) {
}
