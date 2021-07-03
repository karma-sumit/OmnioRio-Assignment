package com.omnirio.assignment.service;

import com.omnirio.assignment.dto.CategoryRequestDTO;
import com.omnirio.assignment.dto.CategoryResponseDTO;
import com.omnirio.assignment.entity.Category;
import com.omnirio.assignment.exception.BadRequestException;

import java.util.UUID;


public interface CategoryService {

    CategoryResponseDTO create(CategoryRequestDTO categoryRequestDTO);

    Category getCategoryById(UUID categoryId) throws BadRequestException;
}
