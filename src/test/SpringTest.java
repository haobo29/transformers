package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.chb.transformers.aop.Account;
import com.chb.transformers.service.AspectService;
import com.chb.transformers.service.MyService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTest {
    @Autowired
    private MyService service;
    @Autowired
    private AspectService s2;
   
    @Test
    public void testSave() {
    	service.save();
    }
    @Test
    public void testUpdate() {
    	service.update();
    }
    @Test
    public void testAccount() {
    	for(int i = 0; i < 10; ++i) {
    		Account a = new Account();
        	System.out.println(a);
        	a.save();
    	}
    }
}
