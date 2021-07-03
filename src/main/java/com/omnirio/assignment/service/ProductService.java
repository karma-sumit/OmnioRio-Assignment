package com.omnirio.assignment.service;

import com.omnirio.assignment.dto.ProductRequestDTO;
import com.omnirio.assignment.dto.ProductResponseDTO;
import com.omnirio.assignment.exception.BadRequestException;

import java.util.UUID;

public interface ProductService {

    ProductResponseDTO create(UUID categoryId, ProductRequestDTO productRequestDTO) throws BadRequestException;

    ProductResponseDTO getById(UUID productId)throws BadRequestException;
}
