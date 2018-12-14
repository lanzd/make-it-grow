package com.planning.application.product.compositeproduct.component;

import com.planning.application.product.compositeproduct.CompositeProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "compositeProductComponent", path = "compositeProductComponent")
public interface CompositeProductComponentRepository extends PagingAndSortingRepository<CompositeProductComponent,Long> {
    Page<CompositeProductComponent> findByProduct(CompositeProduct product, Pageable pageable);
}
