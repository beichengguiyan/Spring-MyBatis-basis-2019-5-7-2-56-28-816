package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    // 1. 实现查询所有用户
    @Select("select * from user where 1=1")
    default List<User> getAllUser() {
        return null;
    }
    // 2. 根据用户id查询用户
    @Select("select * from user where id = ${id}")
    User getUserById(@Param("id") int id);
    // 3. 添加新用户
    @Insert("insert into user (id, name) values (${id}, #{name})")
    int insertNewUser(User u);
    // 4. 根据用户id删除用户
    @Delete("delete from user where id = ${id}")
    int deleteUserById(@Param("id") int id);
    // 5. 根据用户id更新用户
    @Update("update user set id = #{id},name = #{name} where id = ${id_1}")
    int updateUserById(User u ,@Param("id_1") int id);

}
