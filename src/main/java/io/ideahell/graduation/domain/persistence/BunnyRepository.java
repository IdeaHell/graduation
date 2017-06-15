package io.ideahell.graduation.domain.persistence;

import org.springframework.data.repository.CrudRepository;

import io.ideahell.graduation.domain.Bunny;

public interface BunnyRepository extends CrudRepository<Bunny, Long> {

}
