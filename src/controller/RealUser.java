/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entities.User;
/**
 *
 * @author irem
 */
public class RealUser extends User implements IUser {

    public RealUser(String username, String password) {
        super(username, password);
        System.out.println("RealUser oluşturuldu: " + username);
    }

    @Override
    public void login() {
        System.out.println("Real user girişi yapıldı");
    }

}
