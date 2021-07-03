package com.omnirio.assignment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private String id;

    private String name;

    private CategoryRequestDTO category;


}
