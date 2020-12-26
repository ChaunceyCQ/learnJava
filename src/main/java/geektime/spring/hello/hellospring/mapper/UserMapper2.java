package geektime.spring.hello.hellospring.mapper;

import geektime.spring.hello.hellospring.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper2 {

    //@Results注解的作用是将数据库中查询到的数值转化为具体的字段，
    // 修饰返回的结果集，关联实体类属性和数据库字段一一对应，
    // 如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
    //下文就是将数据库里age列的值赋予age2变量，则age变量值为0.
    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "age2", column = "age")
    })
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "age", column = "age")
    })
    User getOne(Long id);

    @Insert("INSERT INTO users(name,password,age) VALUES(#{name}, #{password}, #{age})")
    void insert(User user);

    @Update("UPDATE users SET name=#{name},password=#{password} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(int id);

    //拼接sql语句，实现动态更新
    @Update({"<script> ",
            "update users ",
            "<set>",
            " <if test='name != null'>name=#{name},</if>",
            " <if test='password != null'>password=#{password},</if>",
            " </set> ",
            "where id=#{id} ",
            "</script>"})
    void updateUser(User user);

    //使用SelectProvider，实现动态sql语句拼接
    @SelectProvider(type = UserSql.class, method = "getCount")
    int getCount(User user);
}
