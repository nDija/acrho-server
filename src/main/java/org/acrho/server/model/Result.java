package org.acrho.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Wither
public class Result {

    @Id
    private ResultId id;
    private int position;
    private BigDecimal speed;
    private String time;
    private String avg;
    private long timeMillis;
    private long avgMillis;
    private int points;
}
