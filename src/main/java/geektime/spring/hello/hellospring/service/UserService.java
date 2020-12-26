package geektime.spring.hello.hellospring.service;

import geektime.spring.hello.hellospring.mapper.UserMapper;
import geektime.spring.hello.hellospring.model.User;
import geektime.spring.hello.hellospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

    public void saveUser() {
        User user = new User("neo", "123456", 30);
        userRepository.save(user);
    }

    public int mapperSaveUser() {
        User user = new User("Mapper", "122", 30);
        userMapper.insert(user);
        return 1;
    }

    public List<User> getAll() {
        return userMapper.getAll();
    }
}
