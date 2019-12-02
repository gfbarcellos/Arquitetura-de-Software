/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Dados;
import model.Torneio;
import view.Classificacao;
import view.NovoTorneio;
import view.Confrontos;
import view.Menu;
import view.Menu_CMD;
import static view.Menu_CMD.exibe_menu;

public class Controller_CMD {
    
    public void Sair() {
        System.exit(0);
    }

    /*
    public void Menu() {
        Menu principal = new Menu();
        principal.setVisible(true);
    }
    */
    
    public void NovoTorneio(String data) throws IOException, FileNotFoundException, ClassNotFoundException
    {   
        //String vazia para verificação
        String vazio = new String();

        //Verifica se a data está no formato correto
        if (!data.equals(vazio) ) 
        {   
            
            Torneio torneio = new Torneio();
            torneio.CriaTorneioCMD(data);
        }
        else
        {
            TelaData();
        }

    }

    public void Classificacao() throws IOException, FileNotFoundException, ClassNotFoundException
    {   
        Dados dados = new Dados();
        
        if (dados.VerificaDados("confrontos")) 
        {
            Classificacao classificacao = new Classificacao();
            //classificacao.setVisible(true);
            model.Classificacao mClassificacao = new model.Classificacao();
           classificacao.CarregaDados( mClassificacao.OrdenaClassificacao(mClassificacao.MontaTabClassificacao(dados.BuscaDadosConfrontos())));
        }
        else
        {
             exibe_menu();
        }
 
    }
    
    public void Confrontos() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        Dados dados = new Dados();
        Torneio torneio = new Torneio();
        
        if (dados.VerificaDados("confrontos")) 
        {
            Confrontos confrontos = new Confrontos();
            //confrontos.setVisible(true);
            
            ArrayList<model.Confrontos> listaConfrontos = torneio.EliminaBye(dados.BuscaDadosConfrontos());
            
            //System.out.println(listaConfrontos);
            
            //confrontos.AdicionaComboBox(torneio.NumeroDeRodadas(listaConfrontos));
            //confrontos.CarregaRodada(torneio.BuscaConfrontosDaRodada(1, listaConfrontos));
        }
        else
        {
            //JOptionPane.showMessageDialog(null, "Lista de confrontos está vazia", "Erro", JOptionPane.ERROR_MESSAGE);
             exibe_menu();
        }
    }
    
    public void TelaData() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        Dados dados = new Dados();
        
        if (dados.VerificaDados("times")) 
        {
            NovoTorneio torneio = new NovoTorneio();
            torneio.setVisible(true);
        }
        else
        {
            //JOptionPane.showMessageDialog(null, "Lista de times está vazia", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println("ERRO: Lista de times vazia");
            exibe_menu();
        }
 
    }
    
    public void Pesquisar(int rodada) throws IOException
    {
        Dados dados = new Dados();
        Torneio torneio = new Torneio();
        Confrontos confrontos = new Confrontos();
        
        ArrayList<model.Confrontos> listaConfrontos = torneio.EliminaBye(dados.BuscaDadosConfrontos());
        confrontos.AdicionaComboBox(torneio.NumeroDeRodadas(listaConfrontos));
        confrontos.CarregaRodada(torneio.BuscaConfrontosDaRodada(rodada, listaConfrontos));
        confrontos.SetComboBox(rodada);
        confrontos.setVisible(true);
    }
    
    public void ConfirmaRodada( DefaultTableModel linha, int rodada ) throws IOException
    {
        Torneio torneio = new Torneio();
        torneio.MontaResultadosDaRodada(linha, rodada);
    }
         
}
