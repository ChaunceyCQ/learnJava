package geektime.spring.hello.hellospring.mapper;

import geektime.spring.hello.hellospring.model.User;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

//构建sql类，实现Mybatis 注解版的动态sql语句
public class UserSql {
    public String getCount(User user) {
        String sql = new SQL() {{
            SELECT("count(1)");
            FROM("users");
            if (!StringUtils.isEmpty(user.getName())) {
                WHERE("name = #{name}");
            }
            if (!StringUtils.isEmpty(user.getPassword())) {
                WHERE("password = #{password}");
            }
            //从这个toString可以看出，其内部使用高效的StringBuilder实现SQL拼接
        }}.toString();
        return sql;
    }
}
