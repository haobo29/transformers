package test;

import com.chb.transformers.service.AspectService;
import com.chb.transformers.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Annotation;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTest {
    @Autowired
    private MyService service;
    @Autowired
    private AspectService s2;
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
    @Test
    public void testAspect(){
        s2.save();
    }
}
