package amoj.dao;

import amoj.entity.Problem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProblemDao {

    List<Problem> allProblems();

    Problem findProblemById(Long problemId);

    int addProblem(Problem problem);

    int updateProblemById(Problem problem);

    int deleteProblemById(Long problemId);
}
