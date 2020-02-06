import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class TextDemo {

    @Test
    public void text1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");
        for (Map<String, Object> map : maps) {
            for (String s : map.keySet()){
                System.out.println(map.get(s));
            }
        }

        int update = jdbcTemplate.update("update user set password='111' where username='chen'");
        System.out.println(update);

        int update1 = jdbcTemplate.update("insert into user values (null ,'qq','123')");
        System.out.println(update1);
    }

}
