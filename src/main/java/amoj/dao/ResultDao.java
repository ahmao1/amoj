package amoj.dao;

import amoj.entity.Result;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultDao {

    List<Result> allResults();

    Result findResultById(Long resultId);

    int addResult(Result result);

    int updateResultById(Result result);

    int deleteResultById(Long resultId);
}
