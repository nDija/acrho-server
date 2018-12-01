package org.acrho.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class Run {

    private Long id;
    private String name;
    private String type;
    private LocalDate date;
    private BigDecimal distance;
}
