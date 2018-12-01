package org.acrho.server.controller;

import io.swagger.annotations.Api;
import org.acrho.server.AcrhoService;
import org.acrho.server.Function.AcrhoRunnerRunnerFunction;
import org.acrho.server.model.Runner;
import org.acrho.server.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Runner")
@RestController
public class RunnerController {

    @Autowired
    RunnerRepository runnerRepository;

    @GetMapping("/runner/{runnerId}")
    public Runner getRunner(@PathVariable long runnerId) {
        return runnerRepository.findById(runnerId);
    }

    @DeleteMapping("/load/runs/{year}")
    public void deleteRunner(@PathVariable long runner) {
        runnerRepository.deleteById(runner);
    }
}
