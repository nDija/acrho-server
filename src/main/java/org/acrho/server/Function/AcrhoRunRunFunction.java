package org.acrho.server.Function;

import io.hullaert.acrho.client.model.AcrhoRun;
import org.acrho.server.model.Run;

import java.util.function.Function;

public class AcrhoRunRunFunction implements Function<AcrhoRun, Run> {
    public Run apply(AcrhoRun acrhoRun) {
        Run run = new Run();
        run.setDate(acrhoRun.getDate());
        run.setDistance(acrhoRun.getDistance());
        run.setId(acrhoRun.getId());
        run.setName(acrhoRun.getName());
        return run;
    }
}
