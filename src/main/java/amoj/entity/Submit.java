package amoj.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Submit {
    private Long submitId;
    private Long problemId;
    private Integer language;
    private Long userId;
    private Date submitTime;
    private String source;//源代码
    private Long time;//时限
    private Long mem;//内存限制
    private Long resultId;
}
