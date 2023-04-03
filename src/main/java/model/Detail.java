package model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Detail {
    @Id
    private String id;
    private LocalDate dateCreation;
    private int producedFuel;
    private int usedFuel;
    private int brokenMicrocircuits;
    private double productionTime;
}