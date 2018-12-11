package com.planning.application.vegetableCommand;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orderedVegetable", path = "orderedVegetable")
public interface OrderedVegetableRepository extends PagingAndSortingRepository<OrderedVegetable,Long> {

}
