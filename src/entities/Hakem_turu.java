/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author irem
 */
public class Hakem_turu {
 int hakem_tur_id;
 String hakem_turu;

    public Hakem_turu() {
    }

    public Hakem_turu(int hakem_tur_id, String hakem_turu) {
        this.hakem_tur_id = hakem_tur_id;
        this.hakem_turu = hakem_turu;
    }

    public int getHakem_tur_id() {
        return hakem_tur_id;
    }

    public void setHakem_tur_id(int hakem_tur_id) {
        this.hakem_tur_id = hakem_tur_id;
    }

    public String getHakem_turu() {
        return hakem_turu;
    }

    public void setHakem_turu(String hakem_turu) {
        this.hakem_turu = hakem_turu;
    }
 
}
