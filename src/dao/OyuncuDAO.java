/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Oyuncu;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.DAO;
import service.Database;

/**
 *
 * @author irem
 */
public class OyuncuDAO implements DAO<Oyuncu> {

    @Override
    public Oyuncu get(int id) throws SQLException {
        Oyuncu oyuncu = null;

        try ( Connection con = Database.getConnection();) {
            String sql = "SELECT * FROM oyuncu WHERE oyuncu_id = ?";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Oyuncu tablosundan gelen verilerle yeni bir Oyuncu nesnesi oluştur
                        oyuncu = new Oyuncu();
                        oyuncu.setOyuncu_id(resultSet.getInt("oyuncu_id"));
                        oyuncu.setOyuncu_ad(resultSet.getString("oyuncu_adı"));
                        oyuncu.setOyuncu_boy(resultSet.getInt("oyuncu_boy"));
                        oyuncu.setOyuncu_kilo(resultSet.getInt("oyuncu_kilo"));
                        oyuncu.setOy_pozisyon(resultSet.getString("oyuncu_pozisyon"));
                        oyuncu.setOy_dogumt(resultSet.getString("oy_dogumtarih"));
                        oyuncu.setOy_milliyet(resultSet.getString("oy_milliyet"));

                        // Diğer sütunlara göre set etme işlemlerini ekleyebilirsiniz
                    }
                }
            }
        }

        return oyuncu;
    }

    @Override
    public List<Oyuncu> getAll() throws SQLException {
        List<Oyuncu> oyuncular = new ArrayList<>();

        try (Connection con = Database.getConnection();) {
            String sql = "SELECT * FROM oyuncu";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Oyuncu oyuncu = new Oyuncu();
                        oyuncu.setOyuncu_id(resultSet.getInt("oyuncu_id"));
                        oyuncu.setOyuncu_ad(resultSet.getString("oyuncu_adı"));
                        oyuncu.setOyuncu_boy(resultSet.getInt("oyuncu_boy"));
                        oyuncu.setOyuncu_kilo(resultSet.getInt("oyuncu_kilo"));
                        oyuncu.setOy_pozisyon(resultSet.getString("oyuncu_pozisyon"));
                        oyuncu.setOy_dogumt(resultSet.getString("oy_dogumtarih"));
                        oyuncu.setOy_milliyet(resultSet.getString("oy_milliyet"));

                        // Diğer sütunlara göre set etme işlemlerini ekleyebilirsiniz
                        oyuncular.add(oyuncu);
                    }
                }
            }
        }

        return oyuncular;
    }

    @Override
    public int insert(Oyuncu oyuncu) throws SQLException {

        try ( Connection con = Database.getConnection();) {
            String sql = "INSERT INTO oyuncu (oyuncu_id ,oyuncu_ad, oyuncu_boy, oyuncu_kilo,pozisyon, dogum_tarih,milliyet) VALUES (?, ?, ?, ?, ?, ?,?)";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                Oyuncu clonoyuncu = oyuncu.clone();
                clonoyuncu.setOy_pozisyon(oyuncu.getOy_pozisyon());
                
                preparedStatement.setInt(1, oyuncu.getOyuncu_id());
                preparedStatement.setString(2, oyuncu.getOyuncu_ad());
                preparedStatement.setInt(3, oyuncu.getOyuncu_boy());
                preparedStatement.setInt(4, oyuncu.getOyuncu_kilo());
                preparedStatement.setString(5, oyuncu.getOy_pozisyon());
                preparedStatement.setString(6, oyuncu.getOy_dogumt());
                preparedStatement.setString(7, oyuncu.getOy_milliyet());

                int result = preparedStatement.executeUpdate();
                return result;
            }
        }

    }

    @Override
    public int update(Oyuncu oyuncu) throws SQLException {
        int affectedRows = 0;

        try (Connection con = Database.getConnection();) {
            String sql = "UPDATE oyuncu SET oyuncu_adı=?, oyuncu_boy=?, oyuncu_kilo=?, oyuncu_pozisyon=?, oy_dogumtarih=?, oy_milliyet=? WHERE oyuncu_id=?";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                Oyuncu clonedOyuncu = oyuncu.clone();

                preparedStatement.setString(1, clonedOyuncu.getOyuncu_ad());
                preparedStatement.setInt(2, clonedOyuncu.getOyuncu_boy());
                preparedStatement.setInt(3, clonedOyuncu.getOyuncu_kilo());
                preparedStatement.setString(4, clonedOyuncu.getOy_pozisyon());
                preparedStatement.setString(5, clonedOyuncu.getOy_dogumt());
                preparedStatement.setString(6, clonedOyuncu.getOy_milliyet());
                preparedStatement.setInt(7, clonedOyuncu.getOyuncu_id());

                affectedRows = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            // SQLException ile başa çıkma işlemleri
            e.printStackTrace();
        }

        return affectedRows;
    }

    @Override
    public int delete(Oyuncu oyuncu) {
        int affectedRows = 0;

        try ( Connection con = Database.getConnection();) {
            String sql = "DELETE FROM oyuncu WHERE oyuncu_id = ?";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, oyuncu.getOyuncu_id());

                affectedRows = preparedStatement.executeUpdate();

            }
        } catch (SQLException ex) {
            Logger.getLogger(OyuncuDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return affectedRows;

    }
}
