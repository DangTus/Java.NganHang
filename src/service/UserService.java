package service;

import dao.UserDao;
import java.sql.SQLException;
import model.User;

public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public User login(String userName, String password) throws SQLException {
        return userDao.login(userName, password);
    }
    
    public int editPassword(int id, String passwordOld, String passwordNew, String passwordConfirm) throws SQLException {
        return userDao.editPassword(id, passwordOld, passwordNew, passwordConfirm);
    }
    
    public User drawMoney(int id, int money) throws SQLException {
        return userDao.drawMoney(id, money);
    }

//    public Card getCardByUserName(String userName) throws SQLException {
//
//        return cardDao.getCardByUserName(userName);
//    }
//
//    public User getUserByUserName(int idUser) throws SQLException {
//        return cardDao.getUserByUserName(idUser);
//    }
//
//    public int checkPass(String userName, String pass) {
//
//        return cardDao.checkPass(userName, pass);
//    }
//
//    public int editPass(String userName, String pass) {
//
//        return cardDao.editPass(userName, pass);
//    }
}
