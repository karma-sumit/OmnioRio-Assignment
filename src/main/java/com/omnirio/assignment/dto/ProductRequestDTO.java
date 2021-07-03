package com.omnirio.assignment.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductRequestDTO {

    @NotNull
    @NotEmpty
    private String name;

}
