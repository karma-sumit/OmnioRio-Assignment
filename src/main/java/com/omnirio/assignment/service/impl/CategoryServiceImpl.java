package com.omnirio.assignment.service.impl;

import com.omnirio.assignment.dto.CategoryRequestDTO;
import com.omnirio.assignment.dto.CategoryResponseDTO;
import com.omnirio.assignment.entity.Category;
import com.omnirio.assignment.exception.BadRequestException;
import com.omnirio.assignment.repository.CategoryRepository;
import com.omnirio.assignment.service.CategoryService;
import com.omnirio.assignment.utils.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    /**
     * Create Category
     * @param categoryRequestDTO
     * @return CategoryResponseDTO categoryResponseDTO
     */
    @Override
    public CategoryResponseDTO create(CategoryRequestDTO categoryRequestDTO) {

            Category category = MapperUtil.convertModelToEntity(categoryRequestDTO, Category.class);
            category = categoryRepository.save(category);

        return MapperUtil.convertEntityToModel(category, CategoryResponseDTO.class);


    }

    /**
     * Get Category by Id
     * @param categoryId
     * @return Category category
     * @throws BadRequestException
     */
    @Override
    public Category getCategoryById(UUID categoryId) throws BadRequestException {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if (!categoryOptional.isPresent()){
            log.info(String.format("Category with id: '%s' does not exist ", categoryId));
            throw new BadRequestException(String.format("Category with id: '%s' does not exist ", categoryId));
        }
        return categoryOptional.get();
    }
}
