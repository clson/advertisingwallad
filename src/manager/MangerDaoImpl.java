package manager;

import model.Manager;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.DigestUtils;
import utils.ConnectDatabase;

import java.sql.SQLException;

public class MangerDaoImpl implements ManagerDao {
    Manager manage;

    public void setLogin(Manager manager){
        this.manage=manager;
    }

    /**
     * @param manager
     * @return model.Manager
     * 管理员登录操作
     */
    @Override
    public Manager login(Manager manager) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
        try {
            if (ConnectDatabase.getConnection()==null){
                manager.setLoginSuccess(false);
            }
            String sqlStr="select * from manager_table where id=? and password=?";
            String pw = DigestUtils.md5DigestAsHex(manager.getPassword().getBytes());
            jdbcTemplate.queryForObject(sqlStr,new BeanPropertyRowMapper<>(Manager.class),manager.getId(),pw);
            manager.setLoginSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            manager.setLoginSuccess(false);
        }
        return manage;
    }
    /**
     * @param pw
     * @return boolean
     * 管理员修改自己密码
     */
    @Override
    public boolean updatePw(String pw) {
        boolean success = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
        try {
            if (ConnectDatabase.getConnection() == null || !manage.isLoginSuccess()) {
                return false;
            }
            String sqlStr="update manager_table set password=? where id=?";
            String uPw = DigestUtils.md5DigestAsHex(pw.getBytes());
            int update = jdbcTemplate.update(sqlStr, uPw, manage.getId());
            if (update!=0){
                success=true;
                //修改成功之后，设置登录属性为失败，强制重新登录才可进行其他操作
                manage.setLoginSuccess(false);
            }else {
                success=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return success;
    }
    /**
     * @param id
     * @return boolean
     * 管理员删除用户
     */
    @Override
    public boolean deleteUser(String id) {
        boolean success = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
        try {
            if (ConnectDatabase.getConnection() == null || !manage.isLoginSuccess()) {
                return false;
            }
            String sqlStr="delete from register_table where id=?";
            int update = jdbcTemplate.update(sqlStr, id);
            if (update!=0)
                success=true;
            else
                success=false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return success;
    }
    /**
     * @param serialNumber
     * @return boolean
     * 管理员删除广告
     */
        @Override
    public boolean deleteAdvertisement(String serialNumber) {
            boolean success = false;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
            try {
                if (ConnectDatabase.getConnection() == null || !manage.isLoginSuccess()) {
                    return false;
                }
                String sqlStr="delete from guanggao_table where serialNumber=?";
                int update = jdbcTemplate.update(sqlStr, serialNumber);
                if (update!=0)
                    success=true;
                else
                    success=false;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return success;
    }
    /**
     * @param manager
     * @return boolean
     * 管理员注册
     */
    @Override
    public boolean register(Manager manager) {
        boolean success=false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
        try {
            if (ConnectDatabase.getConnection()==null){
                return false;
            }
            String sqlStr="insert into manager_table values(?,?)";
            String pw = DigestUtils.md5DigestAsHex(manager.getPassword().getBytes());
            int update = jdbcTemplate.update(sqlStr, manager.getId(), pw);
            if (update!=0)
                success=true;
            else
                success=false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return success;
    }
}
