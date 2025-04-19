package com.fiscalapi.samples.spring.service;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.Product;
import com.fiscalapi.services.FiscalApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final FiscalApiClient fiscalApiClient;

    @Autowired
    public ProductService(FiscalApiClient fiscalApiClient) {
        this.fiscalApiClient = fiscalApiClient;
    }

    public ApiResponse<Product> createProduct(Product product) {
        return fiscalApiClient.getProductService().create(product);
    }

    public ApiResponse<Product> updateProduct(Product product) {
        return fiscalApiClient.getProductService().update(product);
    }

    public ApiResponse<Product> getProductById(String id, boolean details) {
        return fiscalApiClient.getProductService().getById(id, details);
    }

    public ApiResponse<PagedList<Product>> getProducts(int page, int pageSize) {
        return fiscalApiClient.getProductService().getList(page, pageSize);
    }

    public ApiResponse<Boolean> deleteProduct(String id) {
        return fiscalApiClient.getProductService().delete(id);
    }
}