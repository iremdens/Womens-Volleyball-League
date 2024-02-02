/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author irem
 */
public class Oyuncu implements Cloneable {

    int oyuncu_id;
    String oyuncu_ad;
    int oyuncu_boy;
    int oyuncu_kilo;
    String oy_pozisyon;
    String oy_dogumt;
    String oy_milliyet;
    Takim oyuncu_takim;

    @Override
    public Oyuncu clone() {
        try {
            Oyuncu clonedPlayer = (Oyuncu) super.clone();
            // Derin kopya: içindeki tüm temel türleri kopyala
            clonedPlayer.oyuncu_ad = new String(this.oyuncu_ad);
            clonedPlayer.oy_pozisyon = new String(this.oy_pozisyon);
            clonedPlayer.oy_milliyet = new String(this.oy_milliyet);
            return clonedPlayer;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Oyuncu() {
    }

    public Oyuncu(int oyuncu_id) {
        this.oyuncu_id = oyuncu_id;
    }

    public Oyuncu(int oyuncu_id, String oyuncu_ad, int oyuncu_boy, int oyuncu_kilo, String oy_pozisyon, String oy_dogumt, String oy_milliyet) {
        this.oyuncu_id = oyuncu_id;
        this.oyuncu_ad = oyuncu_ad;
        this.oyuncu_boy = oyuncu_boy;
        this.oyuncu_kilo = oyuncu_kilo;
        this.oy_pozisyon = oy_pozisyon;
        this.oy_dogumt = oy_dogumt;
        this.oy_milliyet = oy_milliyet;

    }

    public int getOyuncu_id() {
        return oyuncu_id;
    }

    public void setOyuncu_id(int oyuncu_id) {
        this.oyuncu_id = oyuncu_id;
    }

    public String getOyuncu_ad() {
        return oyuncu_ad;
    }

    public void setOyuncu_ad(String oyuncu_ad) {
        this.oyuncu_ad = oyuncu_ad;
    }

    public int getOyuncu_boy() {
        return oyuncu_boy;
    }

    public void setOyuncu_boy(int oyuncu_boy) {
        this.oyuncu_boy = oyuncu_boy;
    }

    public int getOyuncu_kilo() {
        return oyuncu_kilo;
    }

    public void setOyuncu_kilo(int oyuncu_kilo) {
        this.oyuncu_kilo = oyuncu_kilo;
    }

    public String getOy_pozisyon() {
        return oy_pozisyon;
    }

    public void setOy_pozisyon(String oy_pozisyon) {
        this.oy_pozisyon = oy_pozisyon;
    }

    public String getOy_dogumt() {
        return oy_dogumt;
    }

    public void setOy_dogumt(String oy_dogumt) {
        this.oy_dogumt = oy_dogumt;
    }

    public String getOy_milliyet() {
        return oy_milliyet;
    }

    public void setOy_milliyet(String oy_milliyet) {
        this.oy_milliyet = oy_milliyet;
    }

    public Takim getOyuncu_takim() {
        return oyuncu_takim;
    }

    public void setOyuncu_takim(Takim oyuncu_takim) {
        this.oyuncu_takim = oyuncu_takim;
    }

}
