package amoj;

import amoj.vo.JudgeResult;
import amoj.vo.JudgeTask;

public class test {
    public static void main(String[] args) {
        JudgeTask task = new JudgeTask(
                "1",
                1,
                5,
                1000,
                //"import java.util.Scanner;public class Main { public static void main(String[] args) {Scanner sc=new Scanner(System.in);System.out.println(sc.nextInt()+sc.nextInt());    }}",
                "print(sum(map(int, input().split())))",
                1000,
                10000,
                false
        );
        JudgeResult x = Judge.judge(task);
    }
}
