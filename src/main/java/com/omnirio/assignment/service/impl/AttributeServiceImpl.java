package com.omnirio.assignment.service.impl;

import com.omnirio.assignment.dto.AttributeResponseDTO;
import com.omnirio.assignment.dto.AttributeRequestDTO;
import com.omnirio.assignment.entity.Attribute;
import com.omnirio.assignment.entity.Category;
import com.omnirio.assignment.exception.BadRequestException;
import com.omnirio.assignment.exception.EntityNotFoundException;
import com.omnirio.assignment.repository.AttributeRepository;
import com.omnirio.assignment.service.AttributeService;
import com.omnirio.assignment.service.CategoryService;
import com.omnirio.assignment.utils.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AttributeServiceImpl implements AttributeService {

    private AttributeRepository attributeRepository;
    private CategoryService categoryService;

    public AttributeServiceImpl(AttributeRepository attributeRepository, CategoryService categoryService) {
        this.attributeRepository = attributeRepository;
        this.categoryService = categoryService;
    }


    /**
     * Create attributes for a category
     * @param categoryId
     * @param attributeDTOS
     * @return List of saved attributes
     * @throws BadRequestException
     */
    @Override
    public List<AttributeResponseDTO> create(UUID categoryId, List<AttributeRequestDTO> attributeDTOS) throws BadRequestException {

        Category category = categoryService.getCategoryById(categoryId);

        List<Attribute> attributes = Arrays.asList(MapperUtil.convertModelToEntity(attributeDTOS, Attribute[].class)).parallelStream().map(attribute -> {
            attribute.setCategory(category);
            return attribute;
        }).collect(Collectors.toList());

        return Arrays.asList(MapperUtil.convertEntityToModel(attributeRepository.saveAll(attributes), AttributeResponseDTO[].class));


    }

    /**
     * Get Attributes by Category id
     * @param categoryId
     * @return list of attributes
     * @throws BadRequestException
     * @throws EntityNotFoundException
     */
    @Override
    public List<AttributeResponseDTO> getCategoryId(UUID categoryId) throws BadRequestException, EntityNotFoundException {
        /**
         * To check category exist
         */
        Category category = categoryService.getCategoryById(categoryId);

        List<Attribute> categories = attributeRepository.findAllByCategory(category);

        if (Objects.isNull(categories) || categories.isEmpty()) {
            log.info(String.format("No attribute exist for category id: '%s'",categoryId));
            throw new EntityNotFoundException(String.format("No attribute exist for category id: '%s'",categoryId));
        }

        return Arrays.asList(MapperUtil.convertEntityToModel(categories, AttributeResponseDTO[].class));
    }


}
