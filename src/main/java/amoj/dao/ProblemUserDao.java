package amoj.dao;

import amoj.entity.ProblemUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemUserDao {
    /*
     * 根据userId查problemId   提交过的问题
     * 根据problemId查userId
     * 根据userId查 solve=1的problemId  解决的问题
     * 根据userId查 solve!=1的problemId   提交未解决的问题
     */
    List<Long> findSubmitProblemIdByUserId(Long userId);
    List<Long> findSolveProblemIdByUserId(Long userId);
    List<Long> findUnSolveProblemIdByUserId(Long userId);
    int addProblemUser(ProblemUser problemUser);
    ProblemUser findProblemUser(@Param("problemId")Long problemId, @Param("userId")Long userId);
    int updateProblemUser(@Param("problemId")Long problemId, @Param("userId")Long userId);//solve=1
    int deleteByUserId(Long userId);
    int deleteByProblemId(Long problemId);
}
