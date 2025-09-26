package com.example.minu_s_kitchen_mania.repository;

import com.example.minu_s_kitchen_mania.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
