package com.chb.transformers.servlet;

import com.chb.transformers.aop.Account;
import com.chb.transformers.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        MyService s = ac.getBean(MyService.class);
        s.save();
        resp.getWriter().println("hello1");
        for(int i = 0; i < 10; ++i) {
    		Account a = new Account();
        	System.out.println(a);
        	a.save();
    	}
    }
    
}
