package org.acrho.server.repository;

import org.acrho.server.model.Result;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResultRepository extends MongoRepository<Result, String> {
    List<Result> findByIdRun(long idRun);
    void deleteByIdRun(long idRun);
}

