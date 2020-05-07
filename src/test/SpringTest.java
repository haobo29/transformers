package test;

import com.chb.transformers.service.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTest {
    @Autowired
    private Service service;
    @Test
    public void test(){
        service.print();
    }
}
