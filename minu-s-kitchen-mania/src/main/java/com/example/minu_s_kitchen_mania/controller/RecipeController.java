package com.example.minu_s_kitchen_mania.controller;

import com.example.minu_s_kitchen_mania.model.Contact;
import com.example.minu_s_kitchen_mania.model.Recipe;
import com.example.minu_s_kitchen_mania.repository.ContactRepository;
import com.example.minu_s_kitchen_mania.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RecipeController {
    private final RecipeRepository recipeRepository;
    private ContactRepository contactRepository;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("contact", new Contact());
        return "index";
    }

    @PostMapping("/addRecipe")
    public String addRecipe(@ModelAttribute Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editRecipe(@PathVariable Long id, Model model) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid recipe Id:" + id));
        model.addAttribute("recipe", recipe);
        model.addAttribute("recipes", recipeRepository.findAll()); // to reload table
        return "index"; // reusing index.html for edit
    }

    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute Contact contact) {
        contactRepository.save(contact);
        return "redirect:/#contact"; // redirect back to contact section
    }

    @PostMapping("/update/{id}")
    public String updateRecipe(@PathVariable Long id, @ModelAttribute Recipe recipe) {
        Recipe existingRecipe = recipeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid recipe Id:" + id));
        existingRecipe.setDishName(recipe.getDishName());
        existingRecipe.setChefName(recipe.getChefName());
        recipeRepository.save(existingRecipe);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
        return "redirect:/";
    }
}
