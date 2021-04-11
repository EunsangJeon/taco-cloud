package tacos.repository;

import tacos.model.IngredientDto;

public interface IngredientRepository {
    Iterable<IngredientDto> findAll();
    IngredientDto findById(String id);
    IngredientDto save(IngredientDto ingredient);
}
