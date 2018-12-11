package com.planning.application.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findByName(@Param("name") String name);
}