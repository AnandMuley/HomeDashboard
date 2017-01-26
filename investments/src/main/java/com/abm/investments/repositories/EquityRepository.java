package com.abm.investments.repositories;

import com.abm.investments.model.Equity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EquityRepository extends MongoRepository<Equity, String> {
}
