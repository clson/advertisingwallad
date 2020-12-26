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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryAllUserAD {
    LoginResp loginResp;
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
    }
    List<Advertisement> adList=new ArrayList();
    public List<Advertisement> queryAllUser() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
        try {
            if (ConnectDatabase.getConnection()==null || loginResp ==null)
                return null;
            String sqlStr="select * from guanggao_table";
           adList=(List)jdbcTemplate.query(sqlStr, new ResultSetExtractor() {
                @Override
                public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                    List<Advertisement> arrayList = new ArrayList<>();
                    while (resultSet.next()){
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
