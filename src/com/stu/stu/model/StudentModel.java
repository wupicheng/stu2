package com.stu.stu.model;

import com.base.model.SQLModel;
import com.base.util.PageObject;
import com.stu.entity.User;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-5-18
 * Time: 上午8:51
 * To change this template use File | Settings | File Templates.
 */
public class StudentModel {
    public SQLModel queryAllSQL(PageObject pageObject){
        SQLModel sqlModel=new SQLModel();
        sqlModel.setSqlstr("select * from stu2_student limit ?,?");
        ArrayList paramters=new ArrayList() ;
         paramters.add(pageObject.getFromRecord()-1);
         paramters.add(pageObject.getToRecord()-pageObject.getFromRecord()+1);

        sqlModel.setParameters(paramters);
        return  sqlModel;

    }
    public SQLModel countAllSQL(){
        SQLModel sqlModel=new SQLModel();
        sqlModel.setSqlstr("select count(1) num  from stu2_student");
        ArrayList paramters=new ArrayList() ;

        sqlModel.setParameters(paramters);
        return  sqlModel;

    }
    public SQLModel addStudentSQL(){
        SQLModel sqlModel=new SQLModel();
        sqlModel.setSqlstr("select * from stu2_student ");
        ArrayList paramters=new ArrayList() ;

        sqlModel.setParameters(paramters);
        return  sqlModel;

    }
    public SQLModel deleteStudentSQL(){
        SQLModel sqlModel=new SQLModel();
        sqlModel.setSqlstr("select * from stu2_student ");
        ArrayList paramters=new ArrayList() ;

        sqlModel.setParameters(paramters);
        return  sqlModel;

    }
    public SQLModel editStudentSQL(){
        SQLModel sqlModel=new SQLModel();
        sqlModel.setSqlstr("select * from stu2_student ");
        ArrayList paramters=new ArrayList() ;

        sqlModel.setParameters(paramters);
        return  sqlModel;

    }
    public SQLModel queryStudentByIdSQL(String student_id){
        SQLModel sqlModel=new SQLModel();
        sqlModel.setSqlstr("select * from stu2_student where student_id=? ");
        ArrayList paramters=new ArrayList() ;
        paramters.add(student_id);
        sqlModel.setParameters(paramters);
        return  sqlModel;

    }
}
