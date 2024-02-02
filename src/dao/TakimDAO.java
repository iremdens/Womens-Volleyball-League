/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Takim;
import java.sql.SQLException;
import java.util.List;
import service.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import service.Database;

/**
 *
 * @author irem
 */
public class TakimDAO implements DAO<Takim> {

    @Override
    public Takim get(int id) throws SQLException {
        Takim takim = null;

        try ( Connection con = Database.getConnection();) {
            String sql = "SELECT * FROM takim WHERE takim_id = ?";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Takim tablosundan gelen verilerle yeni bir Takim nesnesi oluştur
                        takim = new Takim();
                        takim.setTakim_id(resultSet.getInt("takim_id"));
                        takim.setTakim_ad(resultSet.getString("takim_ad"));
                        takim.setKurulus_tarih(resultSet.getInt("kurulus_tarih"));
                        takim.setTakim_ulke(resultSet.getString("takim_ulke"));
                        // Diğer sütunlara göre set etme işlemlerini ekleyebilirsiniz
                    }
                }
            }
        }

        return takim;
    }

    @Override
    public List<Takim> getAll() throws SQLException {
        List<Takim> takimlar = new ArrayList<>();

        try (Connection con = Database.getConnection();) {
            String sql = "SELECT takim_id, takim_ad, kurulus_tarih, takım_ulke FROM takim";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Takim takim = new Takim();
                        takim.setTakim_id(resultSet.getInt("takim_id"));
                        takim.setTakim_ad(resultSet.getString("takim_ad"));
                        takim.setKurulus_tarih(resultSet.getInt("kurulus_tarih"));
                        takim.setTakim_ulke(resultSet.getString("takım_ulke"));

                        takimlar.add(takim);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return takimlar;
    }

    @Override
    public int insert(Takim takim) throws SQLException {
        int affectedRows = 0;

        try (Connection con = Database.getConnection();) {
            String sql = "INSERT INTO takim (takim_ad, kurulus_tarih, takım_ulke) VALUES (?, ?, ?)";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, takim.getTakim_ad());
                preparedStatement.setInt(2, takim.getKurulus_tarih());
                preparedStatement.setString(3, takim.getTakim_ulke());

                affectedRows = preparedStatement.executeUpdate();

                // Eğer bir otomatik artan (auto-increment) sütun varsa, eklenen kaydın ID'sini alabilirsiniz
                try ( ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        takim.setTakim_id(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("ID alınamadı, takim eklenemedi.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return affectedRows;
    }

    @Override
    public int update(Takim takim) throws SQLException {
        int affectedRows = 0;

        try (Connection con = Database.getConnection();) {
            String sql = "UPDATE takim SET takim_ad=?, kurulus_tarih=?, takım_ulke=? WHERE takim_id=?";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, takim.getTakim_ad());
                preparedStatement.setInt(2, takim.getKurulus_tarih());
                preparedStatement.setString(3, takim.getTakim_ulke());
                preparedStatement.setInt(4, takim.getTakim_id());

                affectedRows = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return affectedRows;
    }

    @Override
    public int delete(Takim takim) {
       int affectedRows = 0;

        try (Connection con = Database.getConnection();) {
            String sql = "DELETE FROM takim WHERE takim_id=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, takim.getTakim_id());

                affectedRows = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
           try {
               throw e;
           } catch (SQLException ex) {
               Logger.getLogger(TakimDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

        return affectedRows;
    }

    }


