package org.acrho.server.repository;


import org.acrho.server.model.Runner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RunnerRepository extends MongoRepository<Runner, String> {
    Runner findById(long id);
    void deleteById(long id);
}

