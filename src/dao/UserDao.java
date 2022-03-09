package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserDao {

    User user = null;

    public User login(String userName, String password) throws SQLException {
        Connection con = Connect.getJDBCConection();

        String sql = "SELECT * FROM user WHERE user_name = ?";

        PreparedStatement prepareStatement = con.prepareStatement(sql);

        prepareStatement.setString(1, userName);

        ResultSet rs = prepareStatement.executeQuery();

        if (rs.next()) {
            user = new User();
            if (password.equals(rs.getString("password"))) {
                user.setId(rs.getInt("id_user"));
                user.setName(rs.getString("name_user"));
                user.setDoB(rs.getString("DoB"));
                user.setCmnd(rs.getString("cmnd"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getInt("role"));
                user.setStatus(rs.getInt("status"));
                user.setSoDu(rs.getInt("so_du"));
            } else {
                user.setId(0);
            }
            return user;
        } else {
            return null;
        }
    }

    // 1: thanh cong
    // -1: mat khau cu sai
    // -2: mat khau xac nhan k trung voi mat khau moi
    public int editPassword(int id, String passwordOld, String passwordNew, String passwordConfirm) throws SQLException {

        PreparedStatement preparedStatement;
        String sql;

        Connection con = Connect.getJDBCConection();

        sql = "SELECT * FROM user WHERE id_user = ? AND password = ?";

        preparedStatement = con.prepareStatement(sql);

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, passwordOld);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            if (passwordNew.equals(passwordConfirm)) {
                sql = "UPDATE user SET password = ? WHERE id_user = ?";

                preparedStatement = con.prepareStatement(sql);

                preparedStatement.setString(1, passwordNew);
                preparedStatement.setInt(2, id);

                int rs1 = preparedStatement.executeUpdate();

                return rs1;
            } else {
                return -2;
            }
        } else {
            return -1;
        }
    }

    public int drawMoney(int id, int money) throws SQLException {
        Connection con = Connect.getJDBCConection();

        String sql = "UPDATE user SET so_du = ? WHERE id_user = ?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setInt(1, money);
        preparedStatement.setInt(2, id);

        int rs = preparedStatement.executeUpdate();

        return rs;
    }

    public List<User> getAllUser() throws SQLException {
        List<User> users = new ArrayList<User>();

        Connection con = Connect.getJDBCConection();

        String sql = "SELECT * FROM user WHERE role = 2";

        PreparedStatement preparedStatement = con.prepareStatement(sql);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id_user"));
            user.setName(rs.getString("name_user"));
            user.setPhoneNumber(rs.getString("phone_number"));
            user.setStatus(rs.getInt("status"));
            users.add(user);
        }
        return users;
    }
    
    public User getUserById(int id) throws SQLException {
        User user = new User();

        Connection con = Connect.getJDBCConection();

        String sql = "SELECT * FROM user WHERE id_user = ?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setInt(1, id);

        ResultSet rs = preparedStatement.executeQuery();

        rs.next();
        user.setId(rs.getInt("id_user"));
        user.setName(rs.getString("name_user"));
        user.setDoB(rs.getString("DoB"));
        user.setCmnd(rs.getString("cmnd"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setAddress(rs.getString("address"));
        user.setUserName(rs.getString("user_name"));
        user.setPassword(rs.getString("password"));
        user.setStatus(rs.getInt("status"));
        user.setSoDu(rs.getInt("so_du"));
        
        return user;
    }
    
    public int updateUserById(User user) throws SQLException {
        Connection con = Connect.getJDBCConection();

        String sql = "UPDATE user"
                + " SET name_user = ?, DoB = ?, cmnd = ?, phone_number = ?, address = ?, user_name = ?"
                + ", password = ?, status = ?, so_du = ?"
                + " WHERE id_user = ?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getDoB());
        preparedStatement.setString(3, user.getCmnd());
        preparedStatement.setString(4, user.getPhoneNumber());
        preparedStatement.setString(5, user.getAddress());
        preparedStatement.setString(6, user.getUserName());
        preparedStatement.setString(7, user.getPassword());
        preparedStatement.setInt(8, user.getStatus());
        preparedStatement.setInt(9, user.getSoDu());
        preparedStatement.setInt(10, user.getId());

        int rs = preparedStatement.executeUpdate();

        return rs;
    }

//    public Card getCardByUserName(String userName) throws SQLException {
//        Card card = new Card();
//        Connection connect = Connect.getJDBCConection();
//        String sql = "SELECT * FROM card WHERE userName=?";
//
//        PreparedStatement preparedStatement = connect.prepareStatement(sql);
//        preparedStatement.setString(1, userName);
//        ResultSet rs = preparedStatement.executeQuery();
//
//        while (rs.next()) {
//
//            card.setIdCard(rs.getInt("idCard"));
//            card.setIdUser(rs.getInt("idUser"));
//            card.setPass(rs.getString("passWord"));
//            card.setUserName(rs.getString("userName"));
//            card.setSoDu(rs.getInt("soDu"));
//            card.setTrangThai(rs.getInt("trangThai"));
//
//        }
//        connect.close();
//        return card;
//    }
//
//    public User getUserByUserName(int idUser) throws SQLException {
//        User user = new User();
//        Connection connect = Connect.getJDBCConection();
//
//        String sql = " SELECT * FROM user WHERE idUser=?";
//
//        PreparedStatement preparedStatement = connect.prepareStatement(sql);
//        preparedStatement.setInt(1, idUser);
//        ResultSet rs = preparedStatement.executeQuery();
//
//        while (rs.next()) {
//
//            user.setIdUser(rs.getInt("idUser"));
//            user.setCmnd(rs.getString("cmnd"));
//            user.setTenUser(rs.getString("tenUser"));
//            user.setDiaChi(rs.getString("diaChi"));
//            user.setSdt(rs.getString("sdt"));
//
//        }
//
//        connect.close();
//        return user;
//    }
//
//    public int checkPass(String userName, String pass) {
//        Card card = new Card();
//        Connection connect = Connect.getJDBCConection();
//        String sql = "SELECT * FROM card WHERE userName=?";
//        PreparedStatement preparedStatement;
//        try {
//            preparedStatement = connect.prepareStatement(sql);
//            preparedStatement.setString(1, userName);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                if (rs.getString("passWord").equals(pass)) {
//                    connect.close();
//                    return 1;
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return 0;
//    }
//
//    public int editPass(String userName, String pass) {
//        Connection connect = Connect.getJDBCConection();
//        String sql = "UPDATE card set passWord=? WHERE userName=?";
//        PreparedStatement preparedStatement;
//
//        try {
//            preparedStatement = connect.prepareStatement(sql);
//            preparedStatement.setString(1, pass);
//            preparedStatement.setString(2, userName);
//            int rs = preparedStatement.executeUpdate();
//            System.out.println(rs);
//            connect.close();
//            return 1;
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//
//        return 0;
//    }
}
