package control;

import model.LoginResp;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.ConnectDatabase;

//删除自己的广告
public class DelAdvertisement {
    LoginResp loginResp;
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
    }

    public boolean delAdvertisement(String serialNumber){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
        boolean success=false;
        String sqlStr="delete from guanggao_table where serialNumber= ? and id=?";
        try {
            if (ConnectDatabase.getConnection()==null|| loginResp ==null)
                return false;
            int count = jdbcTemplate.update(sqlStr, serialNumber,loginResp.getId());
            if (count!=0)
                success=true;
            else
                success=false;
            ConnectDatabase.getConnection().close();
        }catch (Exception e){
            e.printStackTrace();
            success=false;
        }
        return success;
    }
}
