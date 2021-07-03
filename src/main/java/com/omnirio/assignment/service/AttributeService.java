package com.omnirio.assignment.service;

import com.omnirio.assignment.dto.AttributeResponseDTO;
import com.omnirio.assignment.dto.AttributeRequestDTO;
import com.omnirio.assignment.exception.BadRequestException;
import com.omnirio.assignment.exception.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

public interface AttributeService {

    List<AttributeResponseDTO> create(UUID categoryId, List<AttributeRequestDTO> attributes) throws BadRequestException;

    List<AttributeResponseDTO> getCategoryId(UUID categoryId) throws BadRequestException, EntityNotFoundException;
}
