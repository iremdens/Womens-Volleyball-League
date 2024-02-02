/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author irem
 */
public class User {

    public int id;
    public String ad_soyad;
    public String kullanici_adi;
    public String sifre;

    public User() {
    }

    public User(String kullanici_adi, String sifre) {
        this.kullanici_adi = kullanici_adi;
        this.sifre = sifre;
    }

    public User(String ad_soyad, String kullanici_adi, String sifre) {
        this.ad_soyad = ad_soyad;
        this.kullanici_adi = kullanici_adi;
        this.sifre = sifre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

}
