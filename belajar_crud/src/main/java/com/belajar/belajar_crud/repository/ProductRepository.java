package com.belajar.belajar_crud.repository;

import com.belajar.belajar_crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product ,Long> {

}
