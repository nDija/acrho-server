package org.acrho.server.Function;

import io.hullaert.acrho.client.model.AcrhoResult;
import org.acrho.server.model.Result;
import org.acrho.server.model.ResultId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.function.Function;

public class AcrhoResultResultFunction implements Function<AcrhoResult, Result> {
        private static String timeHumanReadable(long time, String pattern) {
                DateFormat df = new SimpleDateFormat(pattern);
                df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
                return df.format(new Date(time));
        }
        public Result apply(AcrhoResult acrhoResult) {
                Result result = new Result();
                result.setAvgMillis(acrhoResult.getAvg());
                result.setAvg(timeHumanReadable(acrhoResult.getAvg(), "mm'm'ss's'"));
                result.setId(new ResultId(0, acrhoResult.getIdRunner()));
                result.setPoints(acrhoResult.getPoints());
                result.setPosition(acrhoResult.getPosition());
                result.setSpeed(acrhoResult.getSpeed());
                result.setTimeMillis(acrhoResult.getTime());
                result.setTime(timeHumanReadable(acrhoResult.getTime(), "HH'h'mm'm'ss's'"));
                return result;
        }
}