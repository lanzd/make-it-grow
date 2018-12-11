package com.planning.application.order;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.domain.Pageable;

import java.util.Date;

@RepositoryRestResource(collectionResourceRel = "orderEntity", path = "order")
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity,Long> {

    Page<OrderEntity> findAllByDateBetween(Date dateStart, Date dateEnd, Pageable pageable);

    Page<OrderEntity> findByDateBetween(Date dateStart, Date dateEnd, Pageable pageable);

}
