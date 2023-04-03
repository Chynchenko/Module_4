package DTO;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsDTO {
        private long countDetails;
        private long brokenMicrocircuits;
        private long producedFuel;
        private long usedFuel;
    }

