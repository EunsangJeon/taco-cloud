package tacos.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.repository.IngredientRepository;

@Component
public class IngredientByIdConverter
        implements Converter<String, IngredientDto> {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public IngredientDto convert(String id) {
        return ingredientRepo.findById(id);
    }
}
