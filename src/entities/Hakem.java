/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.logging.Logger;

/**
 *
 * @author irem
 */
public class Hakem {
int hakem_id;
String hakem_adi;
String milliyet;
String hakem_turu;

    public Hakem() {
    }

    public Hakem(int hakem_id, String hakem_adi, String milliyet, String hakem_turu) {
        this.hakem_id = hakem_id;
        this.hakem_adi = hakem_adi;
        this.milliyet = milliyet;
        this.hakem_turu = hakem_turu;
    }

    public int getHakem_id() {
        return hakem_id;
    }

    public void setHakem_id(int hakem_id) {
        this.hakem_id = hakem_id;
    }

    public String getHakem_adi() {
        return hakem_adi;
    }

    public void setHakem_adi(String hakem_adi) {
        this.hakem_adi = hakem_adi;
    }

    public String getMilliyet() {
        return milliyet;
    }

    public void setMilliyet(String milliyet) {
        this.milliyet = milliyet;
    }

    public String getHakem_turu() {
        return hakem_turu;
    }

    public void setHakem_turu(String hakem_turu) {
        this.hakem_turu = hakem_turu;
    }
 

}
