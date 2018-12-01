package org.acrho.server.controller;

import io.swagger.annotations.Api;
import org.acrho.server.model.Result;
import org.acrho.server.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Result")
@RestController
public class ResultController {
    @Autowired
    ResultRepository resultRepository;

    @GetMapping("/results/{runId}")
    public List<Result> getResults(@PathVariable long runId) {
        return resultRepository.findByIdRun(runId);
    }

    @DeleteMapping("/results/{runId}")
    public void deleteResults(@PathVariable long runId) {
        resultRepository.deleteByIdRun(runId);
    }
}
