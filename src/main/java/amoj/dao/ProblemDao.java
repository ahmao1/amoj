package amoj.dao;

import amoj.entity.Problem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemDao {

    List<Problem> allProblems();

    Problem findProblemById(Long problemId);

    int addProblem(Problem problem);

    int updateProblemById(Problem problem);

    int deleteProblemById(Long problemId);
}
