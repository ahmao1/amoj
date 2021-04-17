package amoj.entity;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Long userId;

    private String username;

    private String password;

    private Long submit;//提交次数

    private Long solveNumber;

    private String solvePid;

    private Long submitNumber;

    private String submitPid;
}
