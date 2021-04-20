package amoj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitView {
    private Long submitId;
    private Long userId;
    private String username;
    private Long problemId;
    private String problemTitle;
    private int language;
    private String languageName;
    private String result;
    private Long usedTime;
    private Long usedMem;
}
