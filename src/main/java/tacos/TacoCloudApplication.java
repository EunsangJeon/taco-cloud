package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tacos.model.IngredientDto;
import tacos.model.IngredientDto.Type;
import tacos.repository.IngredientRepository;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo) {
        return args -> {
            repo.save(new IngredientDto("FLTO", "Flour Tortilla", Type.WRAP));
            repo.save(new IngredientDto("COTO", "Corn Tortilla", Type.WRAP));
            repo.save(new IngredientDto("GRBF", "Ground Beef", Type.PROTEIN));
            repo.save(new IngredientDto("CARN", "Carnitas", Type.PROTEIN));
            repo.save(new IngredientDto("TMTO", "Diced Tomatoes", Type.VEGGIES));
            repo.save(new IngredientDto("LETC", "Lettuce", Type.VEGGIES));
            repo.save(new IngredientDto("CHED", "Cheddar", Type.CHEESE));
            repo.save(new IngredientDto("JACK", "Monterrey Jack", Type.CHEESE));
            repo.save(new IngredientDto("SLSA", "Salsa", Type.SAUCE));
            repo.save(new IngredientDto("SRCR", "Sour Cream", Type.SAUCE));
        };
    }
}
