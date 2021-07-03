package com.omnirio.assignment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AttributeResponseDTO {

    private UUID id;

    private String name;

    private String value;


}
