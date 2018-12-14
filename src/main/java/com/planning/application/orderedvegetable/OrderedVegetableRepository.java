package com.planning.application.orderedvegetable;

import com.planning.application.order.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orderedVegetable", path = "orderedVegetable")
public interface OrderedVegetableRepository extends PagingAndSortingRepository<OrderedVegetable,Long> {
    Page<OrderedVegetable> findByOrderEntity(OrderEntity orderEntity, Pageable pageable);
}
