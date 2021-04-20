package amoj.dao;

import amoj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> allUsers();

    User findUserById(Long userId);

    int addUser(User user);

    int updateUserById(User user);

    int deleteUserById(Long userId);

    User authenticate(@Param("userId")Long userId, @Param("password")String password);
}
