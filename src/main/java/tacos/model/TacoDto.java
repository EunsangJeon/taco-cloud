package tacos.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TacoDto {

    private long id;
    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Name must not be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<IngredientDto> ingredients;
}
