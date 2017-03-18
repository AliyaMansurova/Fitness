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
public class Message {
    //    id            INT AUTO_INCREMENT PRIMARY KEY,
    private int id;

    //id_from     INT
    private User id_from;

    // id_to       INT
    private User id_to;

    //message VARCHAR(1000) NOT NULL,
    private String message;
    private LocalDate date;
}
