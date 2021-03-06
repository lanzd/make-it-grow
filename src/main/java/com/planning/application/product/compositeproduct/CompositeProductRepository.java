package com.planning.application.product.compositeproduct;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "compositeProduct", path = "compositeProduct")
public interface CompositeProductRepository extends PagingAndSortingRepository<CompositeProduct,Long> {

    List<CompositeProduct> findByName(@Param("name") String name);
}
