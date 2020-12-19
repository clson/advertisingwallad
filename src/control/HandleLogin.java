package control;

import model.Login;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.DigestUtils;
import utils.ConnectDatabase;
import java.sql.SQLException;

public class HandleLogin {
       public Login handleLogin(Login login){
           JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
           Login login1 = new Login();
           try {
               if (ConnectDatabase.getConnection()==null){
                  login1.setLoginSuccess(false);
                  return login1;
               }
               String sqlStr="select id,password from register_table where id=? and password=?";
               String pw = DigestUtils.md5DigestAsHex(login.getPassword().getBytes());
               login1 = jdbcTemplate.queryForObject(sqlStr, new BeanPropertyRowMapper<>(Login.class), login.getId(), pw);
               login1.setLoginSuccess(true);
           } catch (SQLException e) {
               e.printStackTrace();
           }catch (DataAccessException e){
               login1.setLoginSuccess(false);
           }
           return login1;
       }

}
