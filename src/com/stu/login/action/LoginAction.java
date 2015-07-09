package com.stu.login.action;

import com.base.constant.BaseConstant;
import com.base.db.DBManager;
import com.stu.entity.User;
import com.stu.login.dao.LoginDao;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-5-8
 * Time: 下午4:04
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction {

    LoginDao loginDao = new LoginDao();
    User user;
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();

    public String login() {
        System.out.println("loginaction login ....");
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
            List users = loginDao.loginDao(user, connection);
            if (users.size() > 0) {
                //存储用户信息进session
                session.setAttribute(BaseConstant.SESSION_LOGIN_USER, users.get(0));
                //菜单信息存储进session
                List menus = loginDao.menuDao((User) users.get(0), connection);
                session.setAttribute(BaseConstant.SESSION_LOGIN_MENU, menus);
                request.setAttribute("content_div", "/user/blank.jsp");
                return "login_success";
            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        return "";
    }

    public String loginOut() {
        session.invalidate();

        return "sign-in";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
