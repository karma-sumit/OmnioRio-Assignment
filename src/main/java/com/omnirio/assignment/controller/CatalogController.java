package com.omnirio.assignment.controller;

import com.omnirio.assignment.dto.*;
import com.omnirio.assignment.exception.BadRequestException;
import com.omnirio.assignment.exception.EntityNotFoundException;
import com.omnirio.assignment.service.AttributeService;
import com.omnirio.assignment.service.CategoryService;
import com.omnirio.assignment.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static com.omnirio.assignment.utils.Constants.*;


@RestController
@RequestMapping(CATEGORY)
@Api(value="catalog-application", produces = "Operations pertaining to Category management in the Catalog application")
public class CatalogController {

    private CategoryService categoryService;
    private AttributeService attributeService;
    private ProductService productService;


    public CatalogController(CategoryService categoryService, AttributeService attributeService, ProductService productService) {
        this.categoryService = categoryService;
        this.attributeService = attributeService;
        this.productService = productService;
    }

    /**
     * Create Categary endpoint
     * @param categoryRequestDTO category Payload
     * @return categoryDTO created category.
     */
    @PostMapping
    @ApiOperation(value = "Create Category", nickname = "Category creation", notes = "Create a Category in catalog application", response = CategoryRequestDTO.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Category created in case there is no technical or validation errors", response = CategoryRequestDTO.class),
            @ApiResponse(code = 400, message = "Bad Requests", response = BadRequestException.class)})
    public ResponseEntity<CategoryResponseDTO> create(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {

        return new ResponseEntity<>(categoryService.create(categoryRequestDTO),HttpStatus.CREATED);

    }

    /**
     * Create attributes for a Category
     * @param categoryId
     * @param attributeDTOList
     * @return List of created attributes
     * @throws BadRequestException
     */
    @PostMapping(value = ATTRIBUTE)
    @ApiOperation(value = "Create category attributes", nickname = "Category attribute creation", notes = "Create a Category's attribute in catalog application", response = List.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Category's attribute created in case there is no technical or validation errors", response = AttributeRequestDTO.class),
            @ApiResponse(code = 400, message = "Bad Requests", response = BadRequestException.class)})
    public ResponseEntity<List<AttributeResponseDTO>> createAttribute(@PathVariable("categoryId") @Valid UUID categoryId , @Valid @RequestBody List<AttributeRequestDTO> attributeDTOList) throws BadRequestException {

        return new ResponseEntity<>(attributeService.create(categoryId,attributeDTOList),HttpStatus.CREATED);

    }

    /**
     * Create a Product
     * @param categoryId
     * @param productRequestDTO
     * @return created product
     */
    @PostMapping(PRODUCTS)
    @ApiOperation(value = "Create product", nickname = "Product creation", notes = "Create a product in catalog application", response = ProductResponseDTO.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Product created in case there is no technical or validation errors", response = ProductRequestDTO.class),
            @ApiResponse(code = 400, message = "Bad Requests", response = BadRequestException.class)})
    public ResponseEntity<ProductResponseDTO> createProduct(@PathVariable("categoryId") UUID categoryId, @Valid @RequestBody ProductRequestDTO productRequestDTO) throws BadRequestException {

        return new ResponseEntity<>(productService.create(categoryId, productRequestDTO), HttpStatus.CREATED);
    }

    /**
     *  Get category attributes by category id
     * @param categoryId
     * @return list of attributes
     * @throws BadRequestException
     */
    @GetMapping(ATTRIBUTE_BY_CATEGORY_ID)
    @ApiOperation(value = "Get a attributes by category id", nickname = "product by id", notes = "Get category attributes by category id", response = List.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get category attributes by category id", response = UUID.class),
            @ApiResponse(code = 400, message = "Bad Requests", response = BadRequestException.class)})
    public ResponseEntity<List<AttributeResponseDTO>> getAttributeByCategoryId(@PathVariable("categoryId") UUID categoryId) throws BadRequestException, EntityNotFoundException {

        return new ResponseEntity<>(attributeService.getCategoryId(categoryId), HttpStatus.OK);
    }



    /**
     * Get a product by id
     * @param productId
     * @return
     * @throws BadRequestException
     */
    @GetMapping(PRODUCT_BY_ID)
    @ApiOperation(value = "Get a product by id", nickname = "product by id", notes = "Get product by id", response = ProductResponseDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get category attributes by category id", response = UUID.class),
            @ApiResponse(code = 400, message = "Bad Requests", response = BadRequestException.class)})
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable("productId") UUID productId) throws BadRequestException {

        return new ResponseEntity<>(productService.getById(productId), HttpStatus.OK);
    }


}
