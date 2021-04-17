package amoj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {
    private Long problemId;
    private String title;
    private Long submit;//提交次数
    private Long solve;//解决次数
    private Long time;
    private Long mem;
    private String desc;
    private String input;
    private String output;
    private String inputEx;
    private String outputEx;
    private String tip;
    private String lastSubmitId;
}
