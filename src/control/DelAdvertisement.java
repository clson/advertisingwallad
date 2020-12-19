package control;

import model.Login;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.ConnectDatabase;

//删除某个用户的广告
public class DelAdvertisement {
    Login login;
    public void setLogin(Login login){
        this.login=login;
    }
    public boolean delAdvertiserment(String serialNumber){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
        boolean success=false;
        String sqlStr="delete from guanggao_table where serialNumber= ?";
        try {
            if (ConnectDatabase.getConnection()==null||login==null)
                return false;
            int count = jdbcTemplate.update(sqlStr, serialNumber);
            if (count!=0)
                success=true;
            else
                success=false;
        }catch (Exception e){
            e.printStackTrace();
            success=false;
        }
        return success;
    }
}
