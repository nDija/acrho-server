package org.acrho.server.repository;

import org.acrho.server.model.Run;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RunRepository extends MongoRepository<Run, String> {
    Run findById(long runId);
    @Query("{'date' :{'$gte':?0, '$lt':?1}}")
    List<Run> findByYear(LocalDate date, LocalDate newdate);
    @Query(value="{'date' :{'$gte':?0, '$lt':?1}}", delete=true)
    void deleteByYear(LocalDate date, LocalDate newdate);
}