package com.gabma.backend_kitchenmanager.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabma.backend_kitchenmanager.domain.ingredient.IngredientResponseDTO;
import com.gabma.backend_kitchenmanager.services.IngredientServices;



@RestController
@RequestMapping("/ingredients")
public class IngredientController {
  @Autowired
  private IngredientServices ingredientServices;

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping()
  public ResponseEntity<Set<IngredientResponseDTO>> getAllIngredients() {
      return ResponseEntity.ok(ingredientServices.getAllIngredients());
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping("/{id}")
  public ResponseEntity<IngredientResponseDTO> getMethodName(@PathVariable Integer id) {
      return ResponseEntity.ok(ingredientServices.getIngredientById(id));
  }
  
  
  
}
