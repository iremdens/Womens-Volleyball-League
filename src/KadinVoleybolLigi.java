/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import controller.ProxyUser;
import dao.OyuncuDAO;
import entities.Oyuncu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * int oyuncu_id, String oyuncu_ad, int oyuncu_boy, int oyuncu_kilo, String
 * oy_pozisyon, Date oy_dogumt, String oy_milliyet, int oy_siralam
 *
 * @author irem
 */
public class KadinVoleybolLigi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        OyuncuDAO dao = new OyuncuDAO();
        Oyuncu oy = new Oyuncu(23, "Gökçe Keleşyılmaz", 190, 65, "Smaçör", "1994-09-05", "Türkiye");
        Oyuncu klonoyuncu = oy.clone();
        klonoyuncu.setOy_pozisyon("Pasör");

        int ekle = dao.insert(klonoyuncu);
      
        /*  String username = "elifyilmaz";
        String password = "23456";
        ProxyUser user = new ProxyUser(username, password);
        user.login(); */
 /* Oyuncu orijinalOyuncu = new Oyuncu();
        orijinalOyuncu.setOyuncu_id(1);
        orijinalOyuncu.setOyuncu_ad("John Doe");
        orijinalOyuncu.setOyuncu_boy(180);
        orijinalOyuncu.setOyuncu_kilo(75);
        orijinalOyuncu.setOy_pozisyon("Pasör");
        orijinalOyuncu.setOy_dogumt("2000-12-08");
        orijinalOyuncu.setOy_milliyet("USA");

        Oyuncu klonlananOyuncu = orijinalOyuncu.clone();

        // Klonlanan oyuncunun pozisyonunu set etmeden kullan
        klonlananOyuncu.setOyuncu_id(20);
        klonlananOyuncu.setOyuncu_ad("Jane Doe");

        // OyuncuDAO sınıfını kullanarak veritabanına ekleme işlemi
        OyuncuDAO dao = new OyuncuDAO();
        try {
            int ekle = dao.insert(klonlananOyuncu);
            System.out.println("Ekleme Sonucu: " + ekle);
        } catch (SQLException e) {
            e.printStackTrace();
         */
    }

}
