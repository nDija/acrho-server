package org.acrho.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Wither
public class Runner {

    @Id
    private long id;
    private String name;
    private LocalDate birthDate;
    private String category;
    private String team;
    private int bib;
}
