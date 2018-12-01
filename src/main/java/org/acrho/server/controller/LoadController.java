package org.acrho.server.controller;

import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.acrho.server.AcrhoService;
import org.acrho.server.Function.AcrhoResultResultFunction;
import org.acrho.server.Function.AcrhoRunRunFunction;
import org.acrho.server.Function.AcrhoRunnerRunnerFunction;
import org.acrho.server.model.Result;
import org.acrho.server.model.Run;
import org.acrho.server.model.Runner;
import org.acrho.server.repository.ResultRepository;
import org.acrho.server.repository.RunRepository;
import org.acrho.server.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Result")
@RestController
@Log4j2
public class LoadController {

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    RunRepository runRepository;

    @Autowired
    RunnerRepository runnerRepository;

    @Autowired
    AcrhoService acrhoService;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     *
     * @param runId The requested run by id
     * @return A list of result by year
     */
    @GetMapping("/load/results/{runId}")
    public List<Result> loadResults(@PathVariable long runId) {
        log.debug("Load run: " + runId);
        resultRepository.deleteByIdRun(runId);
        List<Result> results = acrhoService.getResult(String.valueOf(runId)).stream()
                .map(new AcrhoResultResultFunction())
                .collect(Collectors.toList());
        results.stream().forEach(r -> r.getId().setRun(runId));
        resultRepository.saveAll(results);
        long firstRunnerId = results.get(0).getId().getRunner();
        String type = acrhoService.getRunType(String.valueOf(runId), String.valueOf(firstRunnerId));
        Run run = runRepository.findById(runId);
        run.setType(type);
        runRepository.save(run);
        return results;
    }

    @GetMapping("/load/runs/{year}")
    public List<Run> loadRuns(@PathVariable int year) {
        LocalDate currentYear = LocalDate.parse(String.valueOf(year) + "0101" , dtf);
        LocalDate nextYear = LocalDate.parse(String.valueOf(year + 1) + "0101", dtf);
        runRepository.deleteByYear(currentYear, nextYear);
        List<Run> runs = acrhoService.getRuns(String.valueOf(year)).stream()
                .map(new AcrhoRunRunFunction())
                .collect(Collectors.toList());
        runRepository.saveAll(runs);
        return runRepository.findByYear(currentYear, nextYear);
    }


    @GetMapping("/load/runner/{runnerId}")
    public Runner loadRunner(@PathVariable long runnerId) {
        runnerRepository.deleteById(runnerId);
        Runner runner = new AcrhoRunnerRunnerFunction().apply(acrhoService.getRunner(String.valueOf(runnerId)));
        runner.setId(runnerId);
        runnerRepository.save(runner);
        return runner;
    }

    @GetMapping("/load/{year}")
    public String loadYear(@PathVariable int year) {
        List<Run> runs = loadRuns(year);
        runs.forEach(run -> loadResults(run.getId()));
        return "done";
    }
}
