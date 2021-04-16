package amoj.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class User {
    private Long userId;

    private String username;

    private String password;

    private Long submit;//提交次数

    private Long solveNumber;

    private JSON solvePid;

    private Long submitNumber;

    private JSON submitPid;
}
