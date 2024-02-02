/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.List;

/**
 *
 * @author irem
 */
public class Lig {

    int lig_id;
    String lig_adi;
    String lig_ulke;
    int takim_sayisi;

    private List<Oyuncu> oyuncular;

    public Lig(List<Oyuncu> oyuncular) {
        this.oyuncular = oyuncular;
    }

    public void addPlayer(Oyuncu oyuncu) {
        oyuncular.add(oyuncu);
    }

    public List<Oyuncu> getPlayers() {
        return oyuncular;
    }

    public Lig() {
    }

    public Lig(int lig_id, String lig_adi, String lig_ulke, int takim_sayisi) {
        this.lig_id = lig_id;
        this.lig_adi = lig_adi;
        this.lig_ulke = lig_ulke;
        this.takim_sayisi = takim_sayisi;
    }

    public int getLig_id() {
        return lig_id;
    }

    public void setLig_id(int lig_id) {
        this.lig_id = lig_id;
    }

    public String getLig_adi() {
        return lig_adi;
    }

    public void setLig_adi(String lig_adi) {
        this.lig_adi = lig_adi;
    }

    public String getLig_ulke() {
        return lig_ulke;
    }

    public void setLig_ulke(String lig_ulke) {
        this.lig_ulke = lig_ulke;
    }

    public int getTakim_sayisi() {
        return takim_sayisi;
    }

    public void setTakim_sayisi(int takim_sayisi) {
        this.takim_sayisi = takim_sayisi;
    }

}
