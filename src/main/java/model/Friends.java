package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Friends
{
    //id          INT AUTO_INCREMENT PRIMARY KEY
    private int id;

    //id_friend1    INT
    private int id_friend1;

    //id_friend2       INT
    private int id_friend2;

}
