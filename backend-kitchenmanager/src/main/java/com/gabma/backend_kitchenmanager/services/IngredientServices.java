package com.gabma.backend_kitchenmanager.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabma.backend_kitchenmanager.domain.ingredient.IngredientResponseDTO;
import com.gabma.backend_kitchenmanager.repositories.IngredientRepository;

@Service
public class IngredientServices {
  @Autowired
  private IngredientRepository ingredientRepository;

  public Set<IngredientResponseDTO> getAllIngredients() {
    Set<IngredientResponseDTO> ingredients = ingredientRepository.findAll().stream().map(IngredientResponseDTO::new).collect(Collectors.toSet());
    
    return ingredients;
  }
  
  public IngredientResponseDTO getIngredientById(Integer id) {
    IngredientResponseDTO ingredient = new IngredientResponseDTO(ingredientRepository.findById(id).orElse(null));
    
    return ingredient;
  } 

}
