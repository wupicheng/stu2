package com.stu.test;

import com.jcabi.aspects.Loggable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-6-1
 * Time: 下午5:36
 * To change this template use File | Settings | File Templates.
 */
public class TestServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            myDao();
    }
    @Loggable
    public void myDao(){
        System.out.println("mydao is running ");

    }
}
