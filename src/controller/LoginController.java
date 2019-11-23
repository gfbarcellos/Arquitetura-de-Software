/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import view.Menu;

public class LoginController{

    public void Sair() {
        System.exit(0);
    }

    public void Entrar() {
        Menu principal = new Menu();
        principal.setVisible(true);//Chama a próxima tela
    }
    
}
