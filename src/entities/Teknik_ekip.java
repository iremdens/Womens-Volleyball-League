/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author irem
 */
public class Teknik_ekip {
int id;
String teleman_alan;
String teleman_adi;
String teleman_milliyet;

    public Teknik_ekip() {
    }

    public Teknik_ekip(int id, String teleman_alan, String teleman_adi, String teleman_milliyet) {
        this.id = id;
        this.teleman_alan = teleman_alan;
        this.teleman_adi = teleman_adi;
        this.teleman_milliyet = teleman_milliyet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeleman_alan() {
        return teleman_alan;
    }

    public void setTeleman_alan(String teleman_alan) {
        this.teleman_alan = teleman_alan;
    }

    public String getTeleman_adi() {
        return teleman_adi;
    }

    public void setTeleman_adi(String teleman_adi) {
        this.teleman_adi = teleman_adi;
    }

    public String getTeleman_milliyet() {
        return teleman_milliyet;
    }

    public void setTeleman_milliyet(String teleman_milliyet) {
        this.teleman_milliyet = teleman_milliyet;
    }

}
