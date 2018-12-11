package com.planning.application.product.simpleproduct;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "compositeProduct", path = "compositeProduct")
public interface SimpleProductRepository extends CrudRepository<SimpleProduct,Long> {

    List<SimpleProduct> findByName(@Param("name") String name);
}
