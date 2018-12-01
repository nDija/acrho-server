package org.acrho.server.Function;

import io.hullaert.acrho.client.model.AcrhoRunner;
import org.acrho.server.model.Runner;

import java.util.function.Function;

public class AcrhoRunnerRunnerFunction implements Function<AcrhoRunner, Runner> {
    public Runner apply(AcrhoRunner acrhoRunner) {
        Runner runner = new Runner();
        runner.setBib(acrhoRunner.getBib());
        runner.setBirthDate(acrhoRunner.getBirthDate());
        runner.setCategory(acrhoRunner.getCategory());
        runner.setName(acrhoRunner.getName());
        runner.setTeam(acrhoRunner.getTeam());
        return runner;
    }
}
