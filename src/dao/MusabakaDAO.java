/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Mac_takvimi;
import entities.Musabaka;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import service.DAO;

/**
 *
 * @author irem
 */
public class MusabakaDAO implements DAO<Mac_takvimi> {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/kadinvoleybollig";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "1234";

    public static void main(String[] args) {
        List<String> takimlar = getTakimListesi();

        if (takimlar.size() < 2) {
            System.out.println("Veritabanında en az iki takım olmalıdır.");
            return;
        }

        // Rastgele iki takım seç
        Random random = new Random();
        int takim1Index = random.nextInt(takimlar.size());
        int takim2Index;
        do {
            takim2Index = random.nextInt(takimlar.size());
        } while (takim2Index == takim1Index);

        String takim1 = takimlar.get(takim1Index);
        String takim2 = takimlar.get(takim2Index);

        // Rastgele skor üret
        int skor1 = random.nextInt(6); // Örneğin, 0-5 arası rastgele bir skor
        int skor2 = random.nextInt(6);

        // Skorları ekrana yazdır
        System.out.println(takim1 + " " + skor1 + " - " + skor2 + " " + takim2);
        // Skorları veritabanına ekle
        ekleSkorVeritabani(takim1, takim2, skor1, skor2);

    }

    public static List<String> getTakimListesi() {
        List<String> takimlar = new ArrayList<>();

        try ( Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT takim_ad FROM takim";
            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        takimlar.add(resultSet.getString("takim_ad"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return takimlar;
    }

    public static void ekleSkorVeritabani(String takim1, String takim2, int skor1, int skor2) {
        try ( Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO mac_takvimi (takim_adi1, takim_adi2, skor1, skor2) VALUES (?, ?, ?, ?)";
            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, takim1);
                preparedStatement.setString(2, takim2);
                preparedStatement.setInt(3, skor1);
                preparedStatement.setInt(4, skor2);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Mac_takvimi get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Mac_takvimi> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(Mac_takvimi t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Mac_takvimi t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Mac_takvimi t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
