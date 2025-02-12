package com.gabma.backend_kitchenmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabma.backend_kitchenmanager.domain.ingredient.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
  
}
