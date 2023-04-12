package com.belajar.belajar_crud.service;

import com.belajar.belajar_crud.DTO.ProductRequest;
import com.belajar.belajar_crud.entity.Product;
import com.belajar.belajar_crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public  String create(ProductRequest productRequest){
        Product product = new Product();
            product.setName(productRequest.getName());
            product.setPrice(productRequest.getPrice());
            product.setQuantity(productRequest.getQuantity());
            productRepository.save(product);
            return "SUCCES CREATE YOUR PRODUCT "+ product.getName();

    }

}
