/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author irem
 */
public class Takim {

    int takim_id;
    String takim_ad;
    int kurulus_tarih;
    String takim_ulke;
    String takim_lig;

    public Takim() {
    }

    public Takim(int takim_id, String takim_ad, int kurulus_tarih, String takim_ulke, String takim_lig) {
        this.takim_id = takim_id;
        this.takim_ad = takim_ad;
        this.kurulus_tarih = kurulus_tarih;
        this.takim_ulke = takim_ulke;
        this.takim_lig = takim_lig;
    }

    public int getTakim_id() {
        return takim_id;
    }

    public void setTakim_id(int takim_id) {
        this.takim_id = takim_id;
    }

    public String getTakim_ad() {
        return takim_ad;
    }

    public void setTakim_ad(String takim_ad) {
        this.takim_ad = takim_ad;
    }

    public int getKurulus_tarih() {
        return kurulus_tarih;
    }

    public void setKurulus_tarih(int kurulus_tarih) {
        this.kurulus_tarih = kurulus_tarih;
    }

    public String getTakim_ulke() {
        return takim_ulke;
    }

    public void setTakim_ulke(String takim_ulke) {
        this.takim_ulke = takim_ulke;
    }

    public String getTakim_lig() {
        return takim_lig;
    }

    public void setTakim_lig(String takim_lig) {
        this.takim_lig = takim_lig;
    }
    
}
