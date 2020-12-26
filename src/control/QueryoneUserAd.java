package control;

import model.Advertisement;
import model.LoginResp;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import utils.ConnectDatabase;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class QueryoneUserAd {
    LoginResp loginResp;
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
    }
    public List<Advertisement> queryOneUser(String id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
        List<Advertisement> adList=new ArrayList();
        Advertisement[] advertisements=null;

        Statement st=null;
        ResultSet rs;
        try {
            Connection con = ConnectDatabase.getConnection();
            if (ConnectDatabase.getConnection() == null || loginResp == null)
                return null;
            if (loginResp.getLoginSuccess() == false)
                return null;
            String sqlStr = "select * from guanggao_table where id='" + id + "'";
            adList = (List) jdbcTemplate.query(sqlStr, new ResultSetExtractor() {
                @Override
                public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                    List<Advertisement> arrayList = new ArrayList<>();
                    while (resultSet.next()) {
                        Advertisement advertisement = new Advertisement();
                        advertisement.setID(resultSet.getString(1));
                        advertisement.setContent(resultSet.getString(2));
                        InputStream in = resultSet.getBinaryStream("imageFile");
                        try {
                            int length = in.available();
                            byte[] b = new byte[length];
                            in.read(b);
                            in.close();
                            Image image = Toolkit.getDefaultToolkit().createImage(b);
                            advertisement.setImage(image);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        advertisement.setSerialNumber(resultSet.getString(4));
                        arrayList.add(advertisement);
                    }
                    return arrayList;
                }
            });
            ConnectDatabase.getConnection().close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return adList;
    }
}
