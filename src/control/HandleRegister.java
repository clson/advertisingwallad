package control;

import org.springframework.util.DigestUtils;
import model.Register;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.ConnectDatabase;
import java.sql.SQLException;


public class HandleRegister {
    public boolean handleRegister(Register register){
        JdbcTemplate jdbcTemplate=new JdbcTemplate(ConnectDatabase.getDataSource());
        try {
            if (ConnectDatabase.getConnection()==null)
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean isSuccess=false;
        String sqlStr="insert into register_table values(?,?)";
        int count=0;
//        String pw = Encrypt.encrypt(register.getPassword(), "mimajiami");
        //使用md5加密简单加密
        String pw = DigestUtils.md5DigestAsHex(register.getPassword().getBytes());
        if (StringUtils.isNotBlank(register.getId())&&StringUtils.isNotBlank(register.getPassword())){
            count=jdbcTemplate.update(sqlStr,register.getId(),pw);
        }
        if (count>=1){
            isSuccess=true;
        }
        return isSuccess;
    }
}
