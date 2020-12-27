package control;

import model.LoginResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.util.DigestUtils;
import utils.ConnectDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAdvertisement {
    LoginResp loginResp;
    public void setLoginResp(LoginResp loginResp){
        this.loginResp = loginResp;
    }
    public boolean updateAd(String content, File pictureFile, String serialNumber){
        boolean success=false;
        int update=0;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectDatabase.getDataSource());
        try {
            if (ConnectDatabase.getConnection() == null||loginResp==null) {
                return false;
            }
            if (loginResp.getLoginSuccess()==false){
                return false;
            }
            //修改图片及广告内容的sql语句
            String sqlStr="update guanggao_table set content=?,imageFile=? where serialNumber=? and id=?";
            //修改广告内容的sql语句
            String sqlContent="update guanggao_table set content=? where serialNumber=? and id=?";
            //修改广告图片的sql语句
            String sqlImg="update guanggao_table set imageFile=? where serialNumber=? and id=?";
            if (pictureFile!=null && content!=null){
               update= jdbcTemplate.update(sqlStr, new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        FileInputStream fileInputStream = null;
                        int length=0;
                        try {
                            fileInputStream = new FileInputStream(pictureFile);
                            length = fileInputStream.available();
                            preparedStatement.setString(1,content);
                            preparedStatement.setBinaryStream(2,fileInputStream,length);
                            preparedStatement.setString(3,serialNumber);
                            preparedStatement.setString(4,loginResp.getId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }else if (content==null){
                update= jdbcTemplate.update(sqlImg, new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        FileInputStream fileInputStream = null;
                        int length=0;
                        try {
                            fileInputStream = new FileInputStream(pictureFile);
                            length = fileInputStream.available();
                            preparedStatement.setBinaryStream(1,fileInputStream,length);
                            preparedStatement.setString(2,serialNumber);
                            preparedStatement.setString(3,loginResp.getId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }else {
                update= jdbcTemplate.update(sqlContent,content,serialNumber,loginResp.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if (update!=0)
            success=true;
        else
            success=false;
        return success;
    }
}
