package com.gabma.backend_kitchenmanager.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabma.backend_kitchenmanager.domain.finalproduct.FinalProductResponseDTO;
import com.gabma.backend_kitchenmanager.services.FinalProductServices;


@RestController
@RequestMapping("/products")
public class FinalProductController {
  @Autowired
  private FinalProductServices finalProductServices;


  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping()
  public ResponseEntity<Set<FinalProductResponseDTO>> getAllFinalProducts() {
      return ResponseEntity.ok(finalProductServices.getAllFinalProducts());
  }

  @GetMapping("/{id}")
  public ResponseEntity<FinalProductResponseDTO> getFinalProductById(@PathVariable Integer id) {
    return ResponseEntity.ok(finalProductServices.getFinalProductById(id));
  }
  
}
