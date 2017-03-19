package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Mission {
    //id          INT AUTO_INCREMENT PRIMARY KEY
    private int id;

    //id_trainer    INT
    private User id_trainer;

    //id_sportsman      INT
    private User id_sportsman;

    //mission VARCHAR (500) NOT NULL
    private String mission;

    //state BOOL NOT NULL
    private boolean state;

    //date DATE,
    private LocalDate date;
}
