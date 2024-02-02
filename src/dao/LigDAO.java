/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import entities.Lig;
import java.sql.SQLException;
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
public class LigDAO implements DAO<Lig> {

    @Override
    public Lig get(int id) throws SQLException {
        Lig lig = null;

        try (Connection con = Database.getConnection();) {
            String sql = "SELECT lig_id, lig_adı, lig_ulke, takim_sayi FROM lig WHERE lig_id = ?";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        lig = new Lig();
                        lig.setLig_id(resultSet.getInt("lig_id"));
                        lig.setLig_adi(resultSet.getString("lig_adı"));
                        lig.setLig_ulke(resultSet.getString("lig_ulke"));
                        lig.setTakim_sayisi(resultSet.getInt("takim_sayi"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return lig;
    }

    @Override
    public List<Lig> getAll() throws SQLException {
        List<Lig> ligler = new ArrayList<>();

        try ( Connection con = Database.getConnection();) {
            String sql = "SELECT lig_id, lig_adı, lig_ulke, takim_sayi FROM lig";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Lig lig = new Lig();
                        lig.setLig_id(resultSet.getInt("lig_id"));
                        lig.setLig_adi(resultSet.getString("lig_adı"));
                        lig.setLig_ulke(resultSet.getString("lig_ulke"));
                        lig.setTakim_sayisi(resultSet.getInt("takim_sayi"));

                        ligler.add(lig);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return ligler;
    }

    @Override
    public int insert(Lig lig) throws SQLException {
        int affectedRows = 0;

        try (Connection con = Database.getConnection();) {
            String sql = "INSERT INTO lig (lig_adı, lig_ulke, takim_sayi) VALUES (?, ?, ?)";

            try ( PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, lig.getLig_adi());
                preparedStatement.setString(2, lig.getLig_ulke());
                preparedStatement.setInt(3, lig.getTakim_sayisi());

                affectedRows = preparedStatement.executeUpdate();

                // Eğer bir otomatik artan (auto-increment) sütun varsa, eklenen kaydın ID'sini alabilirsiniz
                try ( ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        lig.setLig_id(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("ID alınamadı, lig eklenemedi.");
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
    public int update(Lig lig) throws SQLException {
         int affectedRows = 0;

        try (Connection con = Database.getConnection();) {
            String sql = "UPDATE lig SET lig_adı=?, lig_ulke=?, takim_sayi=? WHERE lig_id=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, lig.getLig_adi());
                preparedStatement.setString(2, lig.getLig_ulke());
                preparedStatement.setInt(3, lig.getTakim_sayisi());
                preparedStatement.setInt(4, lig.getLig_id());

                affectedRows = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return affectedRows;
    }

    

    @Override
    public int delete(Lig lig) {
      int affectedRows = 0;

        try (Connection con = Database.getConnection();) {
            String sql = "DELETE FROM lig WHERE lig_id=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, lig.getLig_id());

                affectedRows = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
          try {
              throw e;
          } catch (SQLException ex) {
              Logger.getLogger(LigDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
        }

        return affectedRows;
    }

    

}
