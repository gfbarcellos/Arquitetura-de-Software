/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.Confrontos;
import model.Dados;
import model.Torneio;
import view.Classificacao;
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
    
    public void NovoTorneio(String data) throws IOException, FileNotFoundException, ClassNotFoundException
    {   
        //String vazia para verificação
        String vazio = new String();
        
        //Verifica se a data está no formato correto
        if (!data.equals(vazio)) 
        {   
            //Chama o menu novamente
            Menu();
            
            Torneio torneio = new Torneio();
            Dados dados = new Dados();
            
            //Verifica se possui os times
            if (dados.VerificaDados())    
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

    public void Classificacao() throws IOException
    {
        Classificacao classificacao = new Classificacao();
        classificacao.setVisible(true);
        
        Dados dados = new Dados();
        model.Classificacao mClassificacao = new model.Classificacao();
        //lassificacao tabClassificacao = new Classificacao();
        ArrayList<model.Classificacao> listaClas = mClassificacao.MontaTabClassificacao(dados.BuscaDadosConfrontos());
        classificacao.CarregaDados(listaClas);
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
