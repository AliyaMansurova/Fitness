package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    //    id            INT AUTO_INCREMENT PRIMARY KEY,
    private int id;
    private int id_from;
    private int id_to;
    private String message;
}
