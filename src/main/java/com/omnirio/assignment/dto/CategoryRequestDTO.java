package com.omnirio.assignment.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
public class CategoryRequestDTO {

    @NotNull
    @NotEmpty
    private String name;

}
