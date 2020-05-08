package test;

import com.chb.transformers.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTest {
    @Autowired
    private MyService service;
    @Test
    public void test(){
        service.save();
    }
    @Test
    public void testAround(){
        service.query("junit");
    }
    @Test
    public void testUpdate(){
        service.update();
    }
}
