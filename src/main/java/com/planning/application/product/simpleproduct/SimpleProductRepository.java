package com.planning.application.product.simpleproduct;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "simpleProduct", path = "simpleProduct")
public interface SimpleProductRepository extends PagingAndSortingRepository<SimpleProduct,Long> {

    List<SimpleProduct> findByName(@Param("name") String name);
}
