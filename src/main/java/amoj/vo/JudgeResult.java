package amoj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JudgeResult {

  private Long submitId;
  private Long status;
  private Long timeUsed;
  private Long memoryUsed;
  private String errorMessage;

}
