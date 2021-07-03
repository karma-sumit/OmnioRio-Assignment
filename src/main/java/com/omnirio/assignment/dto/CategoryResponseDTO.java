package com.omnirio.assignment.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
public class CategoryResponseDTO {

    private String categoryId;

    @NotNull
    private String name;

    private List<AttributeResponseDTO> attributes;



}
