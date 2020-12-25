package control;

import model.LoginResp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.DigestUtils;
import utils.ConnectDatabase;

import java.sql.SQLException;

public class UpdateUserPW {
    LoginResp loginResp;
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
    }
    public boolean updatePw(String pw){
        boolean success=false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
        try {
            if (ConnectDatabase.getConnection() == null||loginResp==null) {
                return false;
            }
            if (loginResp.getLoginSuccess()==false){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlStr="update register_table set password=? where id=?";
        String uPw = DigestUtils.md5DigestAsHex(pw.getBytes());
        int update = jdbcTemplate.update(sqlStr, uPw, loginResp.getId());
        if (update!=0){
            success=true;
            //修改成功之后，设置登录属性为失败，强制重新登录才可进行其他操作
            loginResp.setLoginSuccess(false);
        }else {
            success=false;
        }
        return success;
    }
}
