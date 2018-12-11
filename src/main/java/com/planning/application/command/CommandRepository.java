package com.planning.application.command;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "command", path = "command")
public interface CommandRepository extends CrudRepository<Command,Long> {

}
