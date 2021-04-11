package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import tacos.model.IngredientDto;

public interface IngredientRepository
    extends CrudRepository<IngredientDto, String> {
}
