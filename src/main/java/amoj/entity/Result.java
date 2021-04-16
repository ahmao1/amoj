package amoj.entity;

import lombok.Data;

@Data
public class Result {
    private Long resultId;
    private Long submitId;
    private Long usedTime;
    private Long usedMem;
    private String result;
    private Double acc;
}
