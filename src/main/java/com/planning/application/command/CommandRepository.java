package com.planning.application.command;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.domain.Pageable;

import java.util.Date;

@RepositoryRestResource(collectionResourceRel = "command", path = "command")
public interface CommandRepository extends PagingAndSortingRepository<Command,Long> {

    Page<Command> findAllByDateBetween(Date dateStart, Date dateEnd, Pageable pageable);

    Page<Command> findByDateBetween(Date dateStart, Date dateEnd, Pageable pageable);

}
