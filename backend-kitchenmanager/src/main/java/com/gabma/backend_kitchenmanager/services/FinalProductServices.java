package com.gabma.backend_kitchenmanager.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabma.backend_kitchenmanager.domain.finalproduct.FinalProductResponseDTO;
import com.gabma.backend_kitchenmanager.repositories.FinalProductRepository;

@Service
public class FinalProductServices {
  @Autowired
  private FinalProductRepository finalProductRepository;


  public Set<FinalProductResponseDTO> getAllFinalProducts() {
    Set<FinalProductResponseDTO> products = finalProductRepository.findAll().stream().map(FinalProductResponseDTO::new).collect(Collectors.toSet());
    
    return products;
  }


  public FinalProductResponseDTO getFinalProductById(Integer id) {
    FinalProductResponseDTO product = new FinalProductResponseDTO(finalProductRepository.findById(id).orElse(null));

    return product;
  }

  
}
