package com.gabma.backend_kitchenmanager.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabma.backend_kitchenmanager.domain.finalproduct.FinalProduct;
import com.gabma.backend_kitchenmanager.domain.ingredient.Ingredient;
import com.gabma.backend_kitchenmanager.domain.productrelashionship.FinalProductIngredient;
import com.gabma.backend_kitchenmanager.domain.productrelashionship.dtos.FinalProductIngredientWithNameDTO;
import com.gabma.backend_kitchenmanager.repositories.FinalProductIngredientRepository;
import com.gabma.backend_kitchenmanager.repositories.FinalProductRepository;
import com.gabma.backend_kitchenmanager.repositories.IngredientRepository;

@Service
public class IngredientServices {
  @Autowired
  private IngredientRepository ingredientRepository;

  @Autowired
  private FinalProductRepository finalProductRepository;
  
  @Autowired
  private FinalProductIngredientRepository finalProductIngredientRepository;


  public Set<Ingredient> getAllIngredients() {
    return ingredientRepository.findAll().stream().collect(Collectors.toSet());
  }
  
  public Ingredient getIngredientById(Integer id) {
    return ingredientRepository.findById(id).orElse(null);
  } 


  public FinalProductIngredient AddIngredientToFinalProduct(FinalProduct finalProductId, Ingredient ingredientId, Double quantity) {
    FinalProductIngredient finalProductIngredient = new FinalProductIngredient();
    finalProductIngredient.setFinalProductId(finalProductId);
    finalProductIngredient.setIngredientId(ingredientId);
    finalProductIngredient.setQuantity(quantity);

    return finalProductIngredientRepository.save(finalProductIngredient);
  }

  public Ingredient saveIngredient(Ingredient ingredient) {
    return ingredientRepository.save(ingredient);
  }

  public Set<FinalProductIngredientWithNameDTO> getAllIngredientsByProduct(Integer finalProductId) throws Exception {
      FinalProduct finalProduct = finalProductRepository.findById(finalProductId).orElseThrow(() -> new Exception("FinalProduct not found"));
      Set<FinalProductIngredientWithNameDTO> finalProductIngredients = finalProduct.getFinalProductIngredient().stream().map(
        fpIngredient -> {
          String ingredientName = ingredientRepository.findById(fpIngredient.getIngredientId().getId())
                                                      .map(Ingredient::getName)
                                                      .orElse("Unknown Ingredient");
          
          return new FinalProductIngredientWithNameDTO(fpIngredient.getId(), ingredientName, fpIngredient.getQuantity());
        }
      ).collect(Collectors.toSet());
      return finalProductIngredients;
}

}
