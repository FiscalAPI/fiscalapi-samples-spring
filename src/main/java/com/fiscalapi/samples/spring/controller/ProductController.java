/**
 * ┌───────────────────────────────────────────────────────────────────────────────┐
 * │                          IMPORTANTE - AVISO                                   │
 * │                                                                               │
 * │ Este controlador ha sido creado con fines exclusivamente demostrativos.       │
 * │                                                                               │
 * │ La mayoría de los datos están hardcodeados directamente en las acciones       │
 * │ del controlador para facilitar las pruebas inmediatas sin necesidad de        │
 * │ configurar cuerpos de peticiones. Esto permite probar la funcionalidad        │
 * │ simplemente haciendo clic en el botón "Probar" de Swagger.                    │
 * │                                                                               │
 * │ ADVERTENCIA: Las rutas y cURL paths generados por Swagger en esta aplicación  │
 * │ NO CORRESPONDEN CON LAS rutas y recursos de FiscalAPI, son generados          │
 * │ localmente para la aplicación Spring Boot. Para ver las rutas y todo el API   │
 * │ reference visite: https://docs.fiscalapi.com                                  │
 * │                                                                               │
 * │ En esta aplicación de ejemplo solo se han creado dos controladores:           │
 * │ el de productos y el de facturas, para demostrar el funcionamiento            │
 * │ básico de la API. Si desea ver ejemplos de todos los recursos                 │
 * │ disponibles en la API, visite los ejemplos completos de PHP en:               │
 * │ https://github.com/FiscalAPI/fiscalapi-php/blob/main/examples.php             │
 * │                                                                               │
 * │ Este código NO representa una arquitectura limpia ni sigue las mejores        │
 * │ prácticas para aplicaciones en producción. Aunque el SDK de FiscalAPI         │
 * │ implementa las mejores prácticas internamente, esta aplicación de             │
 * │ ejemplo en Spring Boot está diseñada priorizando la simplicidad y facilidad   │
 * │ de prueba.                                                                    │
 * │                                                                               │
 * │ En un entorno de producción, se recomienda utilizar una arquitectura          │
 * │ apropiada con separación de responsabilidades, validación adecuada,           │
 * │ manejo de errores, autenticación, autorización, etc.                          │
 * └───────────────────────────────────────────────────────────────────────────────┘
 */

package com.fiscalapi.samples.spring.controller;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.Product;
import com.fiscalapi.models.ProductTax;
import com.fiscalapi.samples.spring.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Products", description = "Endpoint para la gestión de productos")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation( summary = "Crea un nuevo producto", description = "Los datos están 'harcodeados' en la acción del controlador, en la vida real lea los valores del cuerpo de la petición via @RequestBody")
    @PostMapping

    public ResponseEntity<ApiResponse<Product>> createProduct() {

        Product product = new Product();
        product.setDescription("Libro de Spring sin impuestos");
        product.setUnitPrice(100.75986);
        ApiResponse<Product> apiResponse = productService.createProduct(product);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @Operation( summary = "Actualiza un nuevo producto", description = "Los datos están 'harcodeados' en la acción del controlador, en la vida real lea los valores del cuerpo de la petición via @RequestBody")
    @PutMapping
    public ResponseEntity<ApiResponse<Product>> updateProduct() {

        Product product = new Product();
        product.setId("2c6aafcf-8cd2-4fb1-94a8-687adc671380");
        product.setDescription("Libro de Spring con Impuestos");
        product.setUnitPrice(150.75);
        product.setSatUnitMeasurementId("H87"); // Clave Unidad de medida SAT (Pieza)
        product.setSatProductCodeId("81111602"); // Clave producto SAT libros
        product.setSatTaxObjectId("02"); // Si objeto de impuesto

        // Impuestos del producto
        List<ProductTax> taxes = new ArrayList<>();

        ProductTax iva16 = new ProductTax();
        iva16.setTaxId("002"); // IVA
        iva16.setRate(0.160000); // 16%
        iva16.setTaxTypeId("Tasa"); //Tasa
        iva16.setTaxFlagId("T"); // Traslado

        ProductTax iva1067 = new ProductTax(); // Retención 2/3 partes iva
        iva1067.setTaxId("002");
        iva1067.setRate(0.010667);
        iva1067.setTaxTypeId("Tasa");
        iva1067.setTaxFlagId("T");

        taxes.add(iva16);
        taxes.add(iva1067);

        product.setProductTaxes(taxes); // vincular impuestos al producto

        ApiResponse<Product> response = productService.updateProduct(product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation( summary = "Obtiene un producto por su id")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(
            @PathVariable String id,
            @RequestParam(defaultValue = "false") boolean details) {
        ApiResponse<Product> response = productService.getProductById(id, details);
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