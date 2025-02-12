package com.gabma.backend_kitchenmanager.domain.ingredient;

import java.io.Serializable;
import java.util.Set;

import com.gabma.backend_kitchenmanager.domain.productrelationship.FinalProductIngredient;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredient implements Serializable {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String unit;

  @Column(nullable = false)
  private Double currentStock;

  @Column(nullable = false)
  private Double price;

  @Column(nullable = false)
  private String supplier;

  @OneToMany(mappedBy = "ingredientId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<FinalProductIngredient> finalProductIngredients;

}