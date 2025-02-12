package com.gabma.backend_kitchenmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabma.backend_kitchenmanager.domain.finalproduct.FinalProduct;

public interface FinalProductRepository extends JpaRepository<FinalProduct, Integer> {
  
}
