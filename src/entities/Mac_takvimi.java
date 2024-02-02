/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author irem
 */
public class Mac_takvimi {
int id;
String takim_adi1;
String takim_adi2;
int skor1;
int skor2;

    public Mac_takvimi() {
    }

    public Mac_takvimi(int id, String takim_adi1, String takim_adi2, int skor1, int skor2) {
        this.id = id;
        this.takim_adi1 = takim_adi1;
        this.takim_adi2 = takim_adi2;
        this.skor1 = skor1;
        this.skor2 = skor2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTakim_adi1() {
        return takim_adi1;
    }

    public void setTakim_adi1(String takim_adi1) {
        this.takim_adi1 = takim_adi1;
    }

    public String getTakim_adi2() {
        return takim_adi2;
    }

    public void setTakim_adi2(String takim_adi2) {
        this.takim_adi2 = takim_adi2;
    }

    public int getSkor1() {
        return skor1;
    }

    public void setSkor1(int skor1) {
        this.skor1 = skor1;
    }

    public int getSkor2() {
        return skor2;
    }

    public void setSkor2(int skor2) {
        this.skor2 = skor2;
    }
    
}
