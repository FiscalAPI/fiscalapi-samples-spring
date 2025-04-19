package com.fiscalapi.samples.spring.controller;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.Product;
import com.fiscalapi.samples.spring.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Products", description = "Endpoint para la gestión de productos")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation( summary = "Crea un nuevo producto")
    @PostMapping
    public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody Product product) {
        ApiResponse<Product> response = productService.createProduct(product);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @Operation( summary = "Actualiza un nuevo producto")
    @PutMapping
    public ResponseEntity<ApiResponse<Product>> updateProduct(@RequestBody Product product) {
        ApiResponse<Product> response = productService.updateProduct(product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation( summary = "Obtiene un producto por su id")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(
            @PathVariable String id,
            @RequestParam(defaultValue = "false") boolean includeDeleted) {
        ApiResponse<Product> response = productService.getProductById(id, includeDeleted);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation( summary = "Lista los productos con paginación")
    @GetMapping
    public ResponseEntity<ApiResponse<PagedList<Product>>> getProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        ApiResponse<PagedList<Product>> response = productService.getProducts(page, pageSize);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation( summary = "Elimina un producto por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteProduct(@PathVariable String id) {
        ApiResponse<Boolean> response = productService.deleteProduct(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}