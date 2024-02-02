/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.KullaniciDAO;
import entities.User;

/**
 *
 * @author irem
 */
public class ProxyUser extends User implements IUser {

    private RealUser realUser;

    public ProxyUser(String username, String password) {
        super(username, password);
        System.out.println("ProxyUser oluşturuldu: " + username);
    }

    @Override
    public void login() {
        if (realUser == null) {
            authenticate1();
            realUser = new RealUser(getKullanici_adi(), getSifre());
        }
        realUser.login();

    }

    private void authenticate1() {
        if (!KullaniciDAO.authenticate(getKullanici_adi(), getSifre())) {
            System.out.println("Kullanıcı doğrulaması başarısız: " + kullanici_adi);
            throw new SecurityException("Giriş başarısız. Geçersiz kullanıcı adı veya şifre.");
        } else {
            System.out.println("Kullanıcı doğrulandı: " + kullanici_adi);
        }
    }
}
