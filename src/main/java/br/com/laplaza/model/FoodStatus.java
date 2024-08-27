package br.com.laplaza.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table  (name = "food_status")
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
    private Date created_at;
    private Date updated_at;

}
