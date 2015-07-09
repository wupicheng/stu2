package com.stu.login.dao;

import com.base.dao.BaseDao;
import com.stu.entity.User;
import com.stu.login.model.LoginSQLModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-5-8
 * Time: 下午4:09
 * To change this template use File | Settings | File Templates.
 */
public class LoginDao {
    BaseDao baseDao = new BaseDao();
    LoginSQLModel loginSQLModel = new LoginSQLModel();

    public List loginDao(User user, Connection connection) throws SQLException, InstantiationException, IllegalAccessException {
        return baseDao.query(loginSQLModel.loginSql(user),new User(), connection);

    }

    public List menuDao(User user, Connection connection) throws SQLException {
        ArrayList menus = new ArrayList();
        List menu1s = baseDao.query(loginSQLModel.menu1Sql(user), connection);
        for (Object o : menu1s) {
            HashMap menu = new HashMap();

            Map menu1 = (Map) o;
            menu.put("menu1", menu1);
            String menu1_id = menu1.get("node_id").toString();
            List menu2 = baseDao.query(loginSQLModel.menu2Sql(menu1_id, user), connection);
            menu.put("menu2s",menu2);
            menus.add(menu);
        }
        return menus;
    }
}
