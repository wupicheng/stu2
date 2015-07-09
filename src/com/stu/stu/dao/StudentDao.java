package com.stu.stu.dao;

import com.base.dao.BaseDao;
import com.base.model.SQLModel;
import com.base.util.PageObject;
import com.stu.stu.model.StudentModel;
import javafx.util.converter.NumberStringConverter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-5-18
 * Time: 上午8:55
 * To change this template use File | Settings | File Templates.
 */
public class StudentDao {
    StudentModel studentModel = new StudentModel();
    BaseDao baseDao = new BaseDao();

    public List queryAllDao(Connection connection, PageObject pageObject) throws SQLException {
        return baseDao.query(studentModel.queryAllSQL(pageObject), connection);
    }

    public int countAllDao(Connection connection) throws SQLException {
        List nums = baseDao.query(studentModel.countAllSQL(), connection);
        HashMap map = (HashMap) nums.get(0);
        int num = Integer.parseInt(map.get("num").toString());
        return num;
    }
    public List queryStudentByIdDao(String student_id,Connection connection) throws SQLException {

        return   baseDao.query(studentModel.queryStudentByIdSQL(student_id), connection);

    }
}
