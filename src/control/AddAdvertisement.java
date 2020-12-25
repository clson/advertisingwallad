package control;

import model.Advertisement;
import model.LoginResp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import utils.ConnectDatabase;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddAdvertisement {
    LoginResp loginResp;
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
    }

    public boolean addAdvertisement(Advertisement ad){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
        boolean success=false;

        String sqlStr="insert into guanggao_table values(?,?,?,?)";
        try {
            if (ConnectDatabase.getConnection()==null|| loginResp ==null)
                return false;
            if (loginResp.getLoginSuccess()==false)
                return false;
            FileInputStream fileInputStream = new FileInputStream(ad.getPictureFile());
            int length = fileInputStream.available();
//            int count = jdbcTemplate.update(sqlStr, loginResp.getId(),ad.getContent(), fileInputStream, length, loginResp.getId()+ad.getSerialNumber());
            int count = jdbcTemplate.update(sqlStr, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setString(1, loginResp.getId());
                    preparedStatement.setString(2,ad.getContent());
                    preparedStatement.setBinaryStream(3,fileInputStream,length);
                    preparedStatement.setString(4,ad.getSerialNumber());
                }
            });
            if (count!=0)
                success=true;
            else
                success=false;
            ConnectDatabase.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
           success=false;
        }
        return  success;
    }
}
