import com.hector.mappers.UserMapper;
import com.hector.models.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserTest extends BaseTest {

    final static Logger logger = LoggerFactory.getLogger(UserTest.class);
    @Autowired
    private UserMapper userMapper;

    @Test
    public void allUser(){
        logger.info("Begin test");
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectAll();
        userList.forEach(System.out::println);
    }
}
