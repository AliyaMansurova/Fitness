package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import sun.util.resources.LocaleData;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Mission {
    private int id;
    private int id_trainer;
    private int id_sportsman;
    private String mission;
    private String state;
    private LocaleData data;
}
