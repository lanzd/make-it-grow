package com.planning.application.computedharvestdate;

import com.planning.application.vegetable.Vegetable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;

@RepositoryRestResource(collectionResourceRel = "computedHarvestDate", path = "computedHarvestDate")
public interface ComputedHarvestDateRepository extends PagingAndSortingRepository<ComputedHarvestDate,ComputedHarvestDateIdentity> {

    Page<ComputedHarvestDate> findByComputedHarvestDateIdentitySeedingDay(Date seedingDate, Pageable pageable);

    Page<ComputedHarvestDate> findByComputedHarvestDateIdentityVegetable(Vegetable vegetable, Pageable pageable);
}
