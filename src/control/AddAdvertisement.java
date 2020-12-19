package control;

import model.Advertisement;
import model.Login;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import utils.ConnectDatabase;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddAdvertisement {
    Login login;
    public void setLogin(Login login){
        this.login=login;
    }

    public boolean addAdvertisement(Advertisement ad){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
        boolean success=false;

        String sqlStr="insert into guanggao_table values(?,?,?,?)";
        try {
            if (ConnectDatabase.getConnection()==null||login==null)
                return false;
            if (login.getLoginSuccess()==false)
                return false;
            FileInputStream fileInputStream = new FileInputStream(ad.getPictureFile());
            int length = fileInputStream.available();
//            int count = jdbcTemplate.update(sqlStr, login.getId(),ad.getContent(), fileInputStream, length, login.getId()+ad.getSerialNumber());
            int count = jdbcTemplate.update(sqlStr, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setString(1,login.getId());
                    preparedStatement.setString(2,ad.getContent());
                    preparedStatement.setBinaryStream(3,fileInputStream,length);
                    preparedStatement.setString(4,ad.getSerialNumber());
                }
            });
            if (count!=0)
                success=true;
            else
                success=false;

        } catch (Exception e) {
            e.printStackTrace();
           success=false;
        }
        return  success;
    }
}
