package amoj.entity;

import lombok.Data;

@Data
public class Problem {
    private Long problemId;
    private String title;
    private Long submit;
    private Long solve;
    private Long time;
    private Long mem;
    private String desc;
    private String input;
    private String output;
    private String inputEx;
    private String outputEx;
    private String tip;
}
