package tacos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import tacos.model.IngredientDto;
import tacos.model.IngredientDto.Type;
import tacos.model.OrderDto;
import tacos.model.TacoDto;
import tacos.repository.IngredientRepository;
import tacos.repository.TacoRepository;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("orderDto")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;
    private final TacoRepository tacoRepo;

    @Autowired
    public DesignTacoController(
            IngredientRepository ingredientRepo, TacoRepository tacoRepo) {

        this.ingredientRepo = ingredientRepo;
        this.tacoRepo = tacoRepo;
    }

    @ModelAttribute(name = "orderDto")
    public OrderDto order() {
        return new OrderDto();
    }

    @ModelAttribute(name = "tacoDto")
    public TacoDto taco() {
        return new TacoDto();
    }

    @GetMapping
    public String showDesignForm(Model model) {

        addIngredientToViewModel(model);
        model.addAttribute("tacoDto", new TacoDto());

        return "design";
    }

    @PostMapping
    public String processDesign(
            @Valid TacoDto design, BindingResult result,
            Model model, @ModelAttribute OrderDto orderDto) {

        if (result.hasErrors()) {
            addIngredientToViewModel(model);

            return "design";
        }

        TacoDto saved = tacoRepo.save(design);
        orderDto.addDesign(saved);
        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }

    private List<IngredientDto> filterByType(List<IngredientDto> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    private void addIngredientToViewModel(Model model) {

        List<IngredientDto> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(ingredients::add);

        Type[] types = IngredientDto.Type.values();

        for (Type type : types) {
            model.addAttribute(
                    type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }
}
