package org.acrho.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Wither
public final class ResultId implements Serializable {
    private long run;
    private long runner;
}
