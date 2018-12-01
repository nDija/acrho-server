package org.acrho.server.controller;

import io.swagger.annotations.Api;
import org.acrho.server.model.Run;
import org.acrho.server.repository.RunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Api(tags = "Run")
@RestController
public class RunController {

    @Autowired
    RunRepository runRepository;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

    @GetMapping("/runs/{year}")
    public List<Run> findByYear(@PathVariable int year) {
        String currentYear = String.valueOf(year) + "0101";
        String nextYear = String.valueOf(year + 1) + "0101";
        List<Run> runs = runRepository.findByYear(LocalDate.parse(currentYear, dtf), LocalDate.parse(nextYear, dtf));
        return runs;
    }

    @DeleteMapping("/runs/{year}")
    public void deleteByYear(@PathVariable int year) {
        String currentYear = String.valueOf(year) + "0101";
        String nextYear = String.valueOf(year + 1) + "0101";
        runRepository.deleteByYear(LocalDate.parse(currentYear, dtf), LocalDate.parse(nextYear, dtf));
    }
}
