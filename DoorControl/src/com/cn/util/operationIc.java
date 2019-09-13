package rfid.DoorControl.src.com.cn.util;
import rfid.DoorControl.src.com.cn.peopleInfo.people;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class operationIc {
    public void addPerson(people people)throws SQLException
    {
        Connection con=Dbutil.getConnection();
        String sql=""+"" +
                "insert into userInfo"+
                "(name,id,dom,major,phone,IdCard) "+
                "values(?,?,?,?,?,?)";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, people.getName());
        psmt.setString(2, people.getId());
        psmt.setString(3, people.getDom());
        psmt.setString(4,people.getMajor());
        psmt.setString(5,people.getPhone());
        psmt.setString(6,people.getIdCard());
        //执行SQL语句
        psmt.execute();
    }
    public people showPerson(String IdCard)throws SQLException
    {
        people people=new people();
        Connection con=Dbutil.getConnection();
        String sql=""+
                "select * from userInfo where IdCard = '"+IdCard+"'";
        PreparedStatement psmt = con.prepareStatement(sql);
        ResultSet re=psmt.executeQuery();
        while(re.next())
        {
            people.setName(re.getString("name"));
            people.setId(re.getString("id"));
            people.setDom(re.getString("dom"));
            people.setMajor(re.getString("major"));
            people.setPhone(re.getString("phone"));
            people.setIdCard(re.getString("IdCard"));
        }
        return people;
    }


}
