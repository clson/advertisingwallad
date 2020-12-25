package control;

import model.LoginResp;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.DigestUtils;
import utils.ConnectDatabase;

import java.sql.SQLException;

public class HandleLogin {
       public LoginResp handleLogin(LoginResp loginResp){
           JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
           try {
               if (ConnectDatabase.getConnection()==null){
                  loginResp.setLoginSuccess(false);
                  return loginResp;
               }
               String sqlStr="select id,password from register_table where id=? and password=?";
               String pw = DigestUtils.md5DigestAsHex(loginResp.getPassword().getBytes());
               jdbcTemplate.queryForObject(sqlStr, new BeanPropertyRowMapper<>(LoginResp.class), loginResp.getId(), pw);
               loginResp.setLoginSuccess(true);
               ConnectDatabase.getConnection().close();
           } catch (Exception e) {
               e.printStackTrace();
               loginResp.setLoginSuccess(false);
           }
           return loginResp;
       }

}
