package br.com.laplaza.model;

import br.com.laplaza.record.Food.FoodRegistrationData;
import br.com.laplaza.record.Food.FoodUpdateData;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Table(name = "foods")
@Entity(name = "food")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status", nullable = false)
    private FoodStatus idStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Food(FoodRegistrationData newFood) {
        this.name = newFood.name();
        this.description = newFood.description();
        this.value = newFood.value();
        this.idStatus = newFood.idStatus();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void updateFood(FoodUpdateData updateData) {
        if (updateData.name() != null) {
            this.name = updateData.name();
        }

        if (updateData.description() != null) {
            this.description = updateData.description();
        }

        if (updateData.value() != null) {
            this.value = updateData.value();
        }

        if (updateData.idStatus() != null) {
            this.getIdStatus().updateData(updateData.idStatus());
        }

        this.updatedAt = LocalDateTime.now();
    }
}