/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import service.DAO;
import service.Database;

/**
 *
 * @author irem
 */
public class KullaniciDAO implements DAO<User> {

    private static final int MIN_PASSWORD_LENGTH = 5;

    public static boolean authenticate(String kullanici_adi, String sifre) {
        try ( Connection con = Database.getConnection();) {
            if (sifre.length() < MIN_PASSWORD_LENGTH) {
                throw new IllegalArgumentException("Şifre " + MIN_PASSWORD_LENGTH + " karakter uzunluğunda olmalıdır.");

            } else if (sifre.length() > MIN_PASSWORD_LENGTH) {
                throw new IllegalArgumentException("Şifre " + MIN_PASSWORD_LENGTH + " karakter uzunluğunda olmalıdır.");
            }
            String sql = "SELECT * FROM kullanici_kayit WHERE kullanici_adi = ? AND sifre = ? ";
            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, kullanici_adi);
                preparedStatement.setString(2, sifre);

                try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // Eğer sonuç varsa, kullanıcı doğrulanmıştır.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Hata durumunda hata izleme
        }

        return false; // Doğrulama başarısız olursa

    }

    @Override
    public User get(int id) throws SQLException {
        User user = null;

        try ( Connection con = Database.getConnection();) {
            String sql = "SELECT * FROM kullanici_kayit WHERE kullanici_id = ?";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // kullanici_kayit tablosundan gelen verilerle yeni bir User nesnesi oluştur
                        user = new User();
                        user.setId(resultSet.getInt("kullanici_id"));
                        user.setAd_soyad(resultSet.getString("ad_soyad"));
                        user.setKullanici_adi(resultSet.getString("kullanici_adi"));
                        user.setSifre(resultSet.getString("sifre"));
                        // Diğer sütunlara göre set etme işlemlerini ekleyebilirsiniz
                    }
                }
            }
        }

        return user;
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> userList = new ArrayList<>();

        try (Connection con = Database.getConnection();) {
            String sql = "SELECT * FROM kullanici_kayit";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int userId = resultSet.getInt("user_id");
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        // Diğer sütunlara göre set etme işlemlerini ekleyebilirsiniz

                        // Yeni User nesnesi oluşturup listeye ekle
                        User user = new User();
                        user.setId(userId);
                        user.setKullanici_adi(username);
                        user.setSifre(password);
                        // Diğer sütunlara göre set etme işlemlerini ekleyebilirsiniz
                        
                        userList.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Hata durumunda başa çıkma işlemleri
            throw e;
        }

        return userList;
    }
    

    @Override
    public int insert(User user) throws SQLException {
        try ( Connection con = Database.getConnection();) {
            String sql = "INSERT INTO kullanici_kayit(ad_soyad, kullanici_adi, sifre) VALUES (?, ?, ?)";
            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getAd_soyad());
                preparedStatement.setString(2, user.getKullanici_adi());
                preparedStatement.setString(3, user.getSifre());

                return preparedStatement.executeUpdate(); // Etkilenen satır sayısını döndür
            }
        }
    }

    @Override
    public int update(User user) throws SQLException {
        int affectedRows = 0;

        try (Connection con = Database.getConnection();) {
            String sql = "UPDATE kullanici_kayit SET ad_soyad=?, kullanici_adi=? sifre=? WHERE id=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getAd_soyad());
                preparedStatement.setString(2, user.getKullanici_adi());
                preparedStatement.setString(3, user.getSifre());

                affectedRows = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Hata durumunda başa çıkma işlemleri
            throw e;
        }

        return affectedRows;
    }
    

    @Override
    public int delete(User user) {
         int affectedRows = 0;

        try (Connection con = Database.getConnection();) {
            String sql = "DELETE FROM kullanici_kayit WHERE user_id = ?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, user.getId());

                affectedRows = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
             try {
                 // Hata durumunda başa çıkma işlemleri
                 throw e;
             } catch (SQLException ex) {
                 Logger.getLogger(KullaniciDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
        }

        return affectedRows;
    }
    
}
