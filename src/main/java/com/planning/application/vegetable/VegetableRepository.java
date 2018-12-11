package com.planning.application.vegetable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "vegetable", path = "vegetable")
public interface VegetableRepository extends CrudRepository<Vegetable,Long> {

    List<Vegetable> findByName(@Param("name") String name);
}
