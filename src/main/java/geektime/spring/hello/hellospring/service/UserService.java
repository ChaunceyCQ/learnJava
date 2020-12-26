package geektime.spring.hello.hellospring.service;

import geektime.spring.hello.hellospring.mapper.UserMapper;
import geektime.spring.hello.hellospring.mapper.UserMapper2;
import geektime.spring.hello.hellospring.model.User;
import geektime.spring.hello.hellospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserMapper2 userMapper2;

    //使用jdbc进行数据访问
    public void saveUser() {
        User user = new User("neo", "123456", 30);
        userRepository.save(user);
    }
    public User findByIdRepository(int id) {
        return userRepository.findById(id);
    }

    //使用Mybatis XML配置进行数据访问
    public int mapperSaveUser() {
        User user = new User("Mapper", "122", 30);
        userMapper.insert(user);
        return 1;
    }
    public List<User> getAll() {
        return userMapper.getAll();
    }

    public void updateUser(){
        User user = new User(4,"update1","22",12);
        user.setPassword(null);
        userMapper.update(user);
    }

    //使用Mybatis 注解版进行数据访问
    public List<User> getAll2() {
        return userMapper2.getAll();
    }

    public void delete(int id) {
        userMapper2.delete(id);
    }

    public int mapperSaveUser2() {
        User user = new User("Mapper2", "122", 31);
        userMapper2.insert(user);
        return 1;
    }

    public void updateUser2(){
        User user = new User(6,"update1","22",12);
        user.setPassword(null);
        userMapper2.updateUser(user);
    }

    public int getCount(){
        User user = new User();
        user.setName("update1");
        return userMapper2.getCount(user);
    }

    /**
     * MyBatis的两种模式各有特点，注解版适合简单快速的模式，
     * 在微服务架构中，一般微服务都有自己对应的数据库，多表连接查询的需求会大大的降低，会越来越适合注解版。
     * XML 模式比适合大型项目，可以灵活地动态生成 SQL，方便调整 SQL，也有痛痛快快、洋洋洒洒地写 SQL 的感觉。
     * 在具体开发过程中，根据公司业务和团队技术基础进行选型即可。
     */


}
