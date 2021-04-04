package tacos.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.model.IngredientDto;
import tacos.model.IngredientDto.Type;
import tacos.model.TacoDto;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<IngredientDto> ingredients = Arrays.asList(
                new IngredientDto("FLTO", "Flour Tortilla", Type.WRAP),
                new IngredientDto("COTO", "Corn Tortilla", Type.WRAP),
                new IngredientDto("GRBF", "Ground Beef", Type.PROTEIN),
                new IngredientDto("CARN", "Carnitas", Type.PROTEIN),
                new IngredientDto("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new IngredientDto("LETC", "Lettuce", Type.VEGGIES),
                new IngredientDto("CHED", "Cheddar", Type.CHEESE),
                new IngredientDto("JACK", "Monterrey Jack", Type.CHEESE),
                new IngredientDto("SLSA", "Salsa", Type.SAUCE),
                new IngredientDto("SRCR", "Sour Cream", Type.SAUCE));

        Type[] types = IngredientDto.Type.values();
        for(Type type: types) {
            log.debug(type.toString().toLowerCase());
        }
        for(Type type: types) {
            model.addAttribute(
                    type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        model.addAttribute("taco", new TacoDto());

        return "design";
    }

    @PostMapping
    public String processDesign(TacoDto design) {
        // TODO: DB integration
        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }

    private List<IngredientDto> filterByType(List<IngredientDto> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
