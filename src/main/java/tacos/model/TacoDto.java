package tacos.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class TacoDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Name must not be at least 5 characters long")
    private String name;

    @ManyToMany(targetEntity = IngredientDto.class)
    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<IngredientDto> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
