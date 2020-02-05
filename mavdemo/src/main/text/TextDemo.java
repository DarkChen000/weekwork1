import com.itdr.pojo.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextDemo {

    @Test
    public void text1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        Users users = (Users) ac.getBean("u");
        System.out.println(users);

        Users users1 = (Users) ac.getBean("u1");
        System.out.println(users1);

        Users users2 = new Users("jd","123");
        System.out.println(users2);

    }

}
