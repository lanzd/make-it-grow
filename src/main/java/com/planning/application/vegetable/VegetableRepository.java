package com.planning.application.vegetable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "vegetable", path = "vegetable")
public interface VegetableRepository extends PagingAndSortingRepository<Vegetable,Long> {

    List<Vegetable> findByName(@Param("name") String name);


}
