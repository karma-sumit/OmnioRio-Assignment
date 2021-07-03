package com.omnirio.assignment.service.impl;

import com.omnirio.assignment.dto.ProductRequestDTO;
import com.omnirio.assignment.dto.ProductResponseDTO;
import com.omnirio.assignment.entity.Category;
import com.omnirio.assignment.entity.Product;
import com.omnirio.assignment.exception.BadRequestException;
import com.omnirio.assignment.repository.ProductRepository;
import com.omnirio.assignment.service.CategoryService;
import com.omnirio.assignment.service.ProductService;
import com.omnirio.assignment.utils.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    /**
     * Create Product
     * @param categoryId
     * @param productRequestDTO
     * @return Product  product
     * @throws BadRequestException
     */
    @Override
    public ProductResponseDTO create(UUID categoryId, ProductRequestDTO productRequestDTO) throws BadRequestException {

        Category category = categoryService.getCategoryById(categoryId);

        Product product = MapperUtil.convertModelToEntity(productRequestDTO, Product.class);
        product.setCategory(category);

        return MapperUtil.convertModelToEntity(productRepository.save(product),ProductResponseDTO.class);
    }

    /**
     * Get product by id
     * @param productId
     * @return Product product
     * @throws BadRequestException
     */
    @Override
    public ProductResponseDTO getById(UUID productId) throws BadRequestException {

        Optional<Product> productOptional = productRepository.findById(productId);

        if (!productOptional.isPresent()) {
            log.info(String.format("Product with id: '%s' does not exist ", productId));
            throw new BadRequestException(String.format("Product with id: '%s' does not exist ", productId));
        }

        return MapperUtil.convertEntityToModel(productOptional.get(),ProductResponseDTO.class) ;
    }
}
