package br.com.laplaza.model;

import br.com.laplaza.record.foodStatus.FoodStatusRegistrationData;
import br.com.laplaza.record.foodStatus.FoodStatusUpdateData;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "food_status")
@Entity (name = "FoodStatus")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FoodStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "idStatus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Food> food;

    public FoodStatus(Long id) {
        this.id = id;
    }

    public FoodStatus(FoodStatusRegistrationData foodStatus) {
        this.shortName = foodStatus.shortName();
        this.description = foodStatus.description();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public boolean updateData(@Valid FoodStatusUpdateData foodStatusUpdate) {
        if (foodStatusUpdate.shortName() == null || foodStatusUpdate.description() == null) {
            return false;
        }

        this.shortName = foodStatusUpdate.shortName();
        this.description = foodStatusUpdate.description();
        this.updatedAt = LocalDateTime.now();

        return true;
    }
}