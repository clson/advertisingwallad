package control;

import model.LoginResp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.DigestUtils;
import utils.ConnectDatabase;

import java.sql.SQLException;

public class UpdateContent {
    LoginResp loginResp;
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
    }
    public boolean updateContent(String content,String serialNumber){
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
        String sqlStr="update guanggao_table set content=? where serialNumber=? and id=?";
        int update = jdbcTemplate.update(sqlStr,content, serialNumber,loginResp.getId());
        if (update!=0){
            success=true;
        }else {
            success=false;
        }
        return success;
    }
}
