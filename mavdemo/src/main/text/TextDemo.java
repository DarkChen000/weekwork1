import com.itdr.controller.BankController;
import com.itdr.service.NameService;
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

    @Test
    public void text2(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        BankController bc = ac.getBean(BankController.class);

        String zz = bc.zz("cch", "qq", 10);
        System.out.println(zz);

    }

    @Test
    public void text3(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        BankController bc = ac.getBean(BankController.class);

        bc.zz2("cch", "qq", 10);

    }

    @Test
    public void text4(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        NameService ns = ac.getBean(NameService.class);

        String a  = ns.game("狗", "12月", "魔羯座");

        System.out.println(a);

    }
}
