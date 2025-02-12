package com.gabma.backend_kitchenmanager.domain.finalproduct;

import java.util.Set;

import com.gabma.backend_kitchenmanager.domain.productrelationship.FinalProductIngredient;

public record FinalProductResponseDTO(Integer id, String name, Double price, Set<FinalProductIngredient> finalProductIngredients) {
  
  public FinalProductResponseDTO(FinalProduct finalProduct) {
    this(
      finalProduct.getId(),
      finalProduct.getName(),
      finalProduct.getPrice(),
      finalProduct.getFinalProductIngredients()
    );
  }
}
