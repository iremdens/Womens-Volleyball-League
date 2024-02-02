/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author irem
 */
public class Musabaka {
int musabaka_id;
String mac_tarihi;
String mac_yeri;
String mac_ulke;

    public Musabaka() {
    }

    public Musabaka(int musabaka_id, String mac_tarihi, String mac_yeri, String mac_ulke) {
        this.musabaka_id = musabaka_id;
        this.mac_tarihi = mac_tarihi;
        this.mac_yeri = mac_yeri;
        this.mac_ulke = mac_ulke;
    }

    public int getMusabaka_id() {
        return musabaka_id;
    }

    public void setMusabaka_id(int musabaka_id) {
        this.musabaka_id = musabaka_id;
    }

    public String getMac_tarihi() {
        return mac_tarihi;
    }

    public void setMac_tarihi(String mac_tarihi) {
        this.mac_tarihi = mac_tarihi;
    }

    public String getMac_yeri() {
        return mac_yeri;
    }

    public void setMac_yeri(String mac_yeri) {
        this.mac_yeri = mac_yeri;
    }

    public String getMac_ulke() {
        return mac_ulke;
    }

    public void setMac_ulke(String mac_ulke) {
        this.mac_ulke = mac_ulke;
    }


}
