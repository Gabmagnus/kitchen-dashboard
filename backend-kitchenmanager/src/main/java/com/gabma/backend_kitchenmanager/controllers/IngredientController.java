package com.gabma.backend_kitchenmanager.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gabma.backend_kitchenmanager.domain.ingredient.Ingredient;
import com.gabma.backend_kitchenmanager.domain.productrelashionship.dtos.FinalProductIngredientWithNameDTO;
import com.gabma.backend_kitchenmanager.services.IngredientServices;



@RestController
@RequestMapping("/ingredients")
public class IngredientController {
  @Autowired
  private IngredientServices ingredientServices;

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping()
  public ResponseEntity<Set<Ingredient>> getAllIngredients() {
      return ResponseEntity.ok(ingredientServices.getAllIngredients());
  }

@CrossOrigin(origins = "*", allowedHeaders = "*")
@GetMapping("/byproduct")
public ResponseEntity<Set<FinalProductIngredientWithNameDTO>> getIngredientsByProduct(@RequestParam("productId") Integer productId) throws Exception {
    return ResponseEntity.ok(ingredientServices.getAllIngredientsByProduct(productId));
}

  
  
}
