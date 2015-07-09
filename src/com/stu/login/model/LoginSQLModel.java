package com.stu.login.model;

import com.stu.entity.User;
import com.base.model.SQLModel;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-5-8
 * Time: 下午4:10
 * To change this template use File | Settings | File Templates.
 */
public class LoginSQLModel {

    public SQLModel loginSql(User user){
        SQLModel sqlModel=new SQLModel();
        sqlModel.setSqlstr("select * from stu2_user " +
                "where user_name=? and user_password=? ");
        ArrayList paramters=new ArrayList() ;
        paramters.add(user.getUser_name());
        paramters.add(user.getUser_password());

        sqlModel.setParameters(paramters);
        return  sqlModel;

    }
    public SQLModel menu1Sql(User user){
        SQLModel sqlModel=new SQLModel();
        sqlModel.setSqlstr("SELECT \n" +
                "  u.user_id,\n" +
                "  u.user_name,\n" +
                "  r.role_id,\n" +
                "  r.role_name,\n" +
                "  n.node_id,\n" +
                "  n.node_name, \n" +
                "  n.node_url \n" +
                "FROM \n" +
                "  stu2_user u,\n" +
                "  stu2_role r,\n" +
                "  stu2_node n,\n" +
                "  stu2_user_role ur,\n" +
                "  stu2_role_node rn \n" +
                "WHERE ur.role_id = r.role_id\n" +
                "AND ur.user_id = u.user_id \n" +
                "AND rn.node_id = n.node_id\n" +
                "AND  rn.role_id = r.role_id \n" +
                "AND n.node_level='1' \n" +
                "AND u.user_id=? ");
        ArrayList paramters=new ArrayList() ;
        paramters.add(user.getUser_id());

        sqlModel.setParameters(paramters);
        return  sqlModel;

    }
    public SQLModel menu2Sql(String parent_id,User user){
        SQLModel sqlModel=new SQLModel();
        sqlModel.setSqlstr("SELECT \n" +
                "  u.user_id,\n" +
                "  u.user_name,\n" +
                "  r.role_id,\n" +
                "  r.role_name,\n" +
                "  n.node_id,\n" +
                "  n.node_name, \n" +
                "  n.node_url \n" +
                "FROM \n" +
                "  stu2_user u,\n" +
                "  stu2_role r,\n" +
                "  stu2_node n,\n" +
                "  stu2_user_role ur,\n" +
                "  stu2_role_node rn \n" +
                "WHERE ur.role_id = r.role_id\n" +
                "AND ur.user_id = u.user_id \n" +
                "AND rn.node_id = n.node_id\n" +
                "AND  rn.role_id = r.role_id \n" +
                "AND n.node_level=2 " +
                "and n.node_parent_id=? \n" +
                "AND u.user_id=?");
        ArrayList paramters=new ArrayList() ;
        paramters.add(parent_id);
        paramters.add(user.getUser_id());

        sqlModel.setParameters(paramters);
        return  sqlModel;

    }
}
