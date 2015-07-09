package com.stu.stu.action;

import com.base.db.DBManager;
import com.base.util.PageObject;
import com.stu.stu.dao.StudentDao;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-5-18
 * Time: 上午8:33
 * To change this template use File | Settings | File Templates.
 */
public class StudentAction {
    HttpServletRequest request = ServletActionContext.getRequest();
    //HttpSession session = request.getSession();
    StudentDao studentDao=new StudentDao();
    public String queryAll(){
       String currentPageNumPara= request.getParameter("currentPageNum");
        int currentPageNum=0;
        if(currentPageNumPara==null){
            currentPageNum=1;
        }else {
            currentPageNum=  Integer.parseInt(currentPageNumPara);
        }
       int   everyPageNum=5;
        Connection connection=null;
        try {
            connection=  DBManager.getConnection();
            int totalRecordNum=studentDao.countAllDao(connection);
            PageObject pageObject=new PageObject(totalRecordNum,everyPageNum,currentPageNum);
            List students= studentDao.queryAllDao(connection,pageObject);
            request.setAttribute("students",students);
            request.setAttribute("pageObject",pageObject);
            request.setAttribute("content_div", "/user/students.jsp");

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }finally {
            DBManager.closeResourse(null,null, connection);
        }

        return "queryAllStudent";

    }
    public String addStudent(){
        return "addStudent";

    }
    public String deleteStudent(){
        return "deleteStudent";

    }
    public String editStudent() throws SQLException {
        Connection connection=null;
        connection=DBManager.getConnection();
      String student_id=  request.getParameter("student_id");
      List students=   studentDao.queryStudentByIdDao(student_id,connection);
      request.setAttribute("student",students.get(0));
      request.setAttribute("content_div", "/user/student.jsp");
      return "editStudent";

    }
}
