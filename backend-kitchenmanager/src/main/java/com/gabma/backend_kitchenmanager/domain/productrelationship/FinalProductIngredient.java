package com.gabma.backend_kitchenmanager.domain.productrelationship;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabma.backend_kitchenmanager.domain.finalproduct.FinalProduct;
import com.gabma.backend_kitchenmanager.domain.ingredient.Ingredient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FinalProductIngredient {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @JoinColumn(name = "final_product_id", nullable = false)
  private FinalProduct finalProductId;


  @ManyToOne
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @JoinColumn(name = "ingredient_id", nullable = false)
  private Ingredient ingredientId;

  @Column(nullable = false)
  private Double quantity;
  
}
