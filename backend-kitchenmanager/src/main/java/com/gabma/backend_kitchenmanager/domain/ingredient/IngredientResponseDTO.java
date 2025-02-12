package com.gabma.backend_kitchenmanager.domain.ingredient;

import java.util.Set;

import com.gabma.backend_kitchenmanager.domain.productrelationship.FinalProductIngredient;

public record IngredientResponseDTO(
  Integer id,
  String name,
  String unit,
  Double currentStock,
  Double price,
  String supplier,
  Set<FinalProductIngredient> finalProductIngredients
) {
  
    // Construtor que aceita um objeto Ingredient
    public IngredientResponseDTO(Ingredient ingredient) {
      this(
        ingredient.getId(),
        ingredient.getName(),
        ingredient.getUnit(),
        ingredient.getCurrentStock(),
        ingredient.getPrice(),
        ingredient.getSupplier(),
        ingredient.getFinalProductIngredients()
      );
    }
  
}