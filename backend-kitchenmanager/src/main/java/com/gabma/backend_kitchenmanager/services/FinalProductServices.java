package com.gabma.backend_kitchenmanager.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabma.backend_kitchenmanager.domain.finalproduct.FinalProduct;
import com.gabma.backend_kitchenmanager.repositories.FinalProductRepository;

@Service
public class FinalProductServices {
  @Autowired
  private FinalProductRepository finalProductRepository;


  public Set<FinalProduct> getAllFinalProducts() {
    return finalProductRepository.findAll().stream().collect(Collectors.toSet());
  }

  
}
