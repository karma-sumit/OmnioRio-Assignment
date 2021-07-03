package com.omnirio.assignment.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class AttributeRequestDTO {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String value;


}
