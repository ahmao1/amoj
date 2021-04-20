package amoj.dao;

import amoj.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    Admin authenticate(@Param("adminId")Long adminId, @Param("password")String password);
}
