package com.planning.application.vegetableCommand;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "vegetableCommand", path = "vegetableCommand")
public interface VegetableCommandRepository extends PagingAndSortingRepository<VegetableCommand,Long> {

}
