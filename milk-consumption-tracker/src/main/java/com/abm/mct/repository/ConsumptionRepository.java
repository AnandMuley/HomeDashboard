package com.abm.mct.repository;

import com.abm.mct.model.Consumption;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionRepository extends MongoRepository<Consumption,String>{

}
