package org.apache.ibatis.demo;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    public User select(int id);

    @Select("SELECT * FROM user WHERE name = #{name}")
    public User selectByName(String name);
}
