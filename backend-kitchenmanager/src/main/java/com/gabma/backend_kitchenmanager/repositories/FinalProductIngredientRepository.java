package com.gabma.backend_kitchenmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabma.backend_kitchenmanager.domain.productrelashionship.FinalProductIngredient;


public interface FinalProductIngredientRepository extends JpaRepository<FinalProductIngredient, Integer> {

}
