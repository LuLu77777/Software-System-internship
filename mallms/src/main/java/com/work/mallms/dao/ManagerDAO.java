package com.work.mallms.dao;

import com.work.mallms.dto.Manager;
import com.work.mallms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

//用于完成管理员信息的数据库访问
public class ManagerDAO {

    /**
     * 根据管理员登录名查询管理员信息
     * @param loginName 管理员登录名
     * @return 如果查询成功则返回管理员对象，如果查询没有结果则返回null
     */
    public Manager selectManagerByLoginName(String loginName){
        Manager manager = null;
        try {
            //SQL指令
            String sql="SELECT mgr_id mgrId,login_name loginName,login_pwd loginPwd,mgr_name mgrName,mgr_gender mgrGender,mgr_tel mgrTel,mgr_email mgrEmail,mgr_qq mgrQQ,create_time createTime FROM tb_managers WHERE login_name = ?";
            //QueryRunner
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            //通过QueryRunner执行SQL
            manager = queryRunner.query(sql,new BeanHandler<Manager>(Manager.class),loginName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }
}
