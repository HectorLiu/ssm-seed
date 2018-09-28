import com.hector.mappers.UserMapper;
import com.hector.models.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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
    public void allUser() {
        logger.info("Begin test");
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void geneHashCode() {
        String password = "123456";
        ByteSource salt = ByteSource.Util.bytes("hector");
        SimpleHash hash = new SimpleHash("MD5", password, salt, 1024);
        logger.info(hash.toString());
    }
}
