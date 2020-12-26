package geektime.spring.hello.hellospring.mapper;


import geektime.spring.hello.hellospring.model.User;

import java.util.List;

public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    int update(User user);

    int delete(Long id);
}
