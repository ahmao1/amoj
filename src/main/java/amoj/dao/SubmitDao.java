package amoj.dao;

import amoj.entity.Submit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmitDao {

    List<Submit> allSubmits();
    List<Submit> finSubmitsByUserId(@Param("userId")String userId);
    Submit findSubmitById(Long submitId);

    int addSubmit(Submit submit);

    int updateSubmitById(Submit submit);

    int deleteSubmitById(Long submitId);

}
