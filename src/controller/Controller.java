/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import model.Torneio;
import view.Menu;
import view.NovoTorneio;

public class Controller {
    
    public void Sair() {
        System.exit(0);
    }

    public void Menu() {
        Menu principal = new Menu();
        principal.setVisible(true);
    }
    
    public void NovoTorneio(String data) throws IOException
    {   
        //String vazia para verificação
        String vazio = new String();
        
        //Verifica se a data está no formato correto
        if (!data.equals(vazio)) 
        {   
            //Chama o menu novamente
            Menu();
            
            Torneio torneio = new Torneio();
            
            //Verifica se possui os times
            if (torneio.VerificaTorneio("times")) 
            {   
                //Chama a criação do torneio
                torneio.CriaTorneio(data);
            }
        }
        else
        {
            TelaData();
        }

    }

    public void Classificacao()
    {
        
    }
    
    public void Confrontos()
    {
        
    }
    
    public void TelaData()
    {
        NovoTorneio torneio = new NovoTorneio();
        torneio.setVisible(true);
        
    }
}
