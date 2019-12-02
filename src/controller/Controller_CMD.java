/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Dados;
import model.Torneio;
import view.Classificacao;
import view.NovoTorneio;
//import view.Confrontos;
import model.Confrontos;
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
        Classificacao classificacao = new Classificacao();
        model.Classificacao mClassificacao = new model.Classificacao();
        ArrayList<model.Classificacao> listaClassificacao = ( mClassificacao.OrdenaClassificacao(mClassificacao.MontaTabClassificacao(dados.BuscaDadosConfrontos())));
        
        System.out.println("TIME                     |    PONTOS    |    JOGOS     |   VITORIAS  |   EMPATES   |   DERROTAS  |   GOLS PRO  | GOLS CONTRA |   SALDO");
        for(model.Classificacao l: listaClassificacao)
        {
            System.out.println(String.format("%-20.20s", l.getTime())+"     |       "+l.getPontos()+"      |       "+l.getJogos()+"      |      "+l.getVitoria()+"      |      "+l.getEmpate()+"      |      "+l.getDerrota()+"      |      "+l.getGolsP()+"      |      "+l.getGolsC()+"      |      "+l.getSaldo());
        }
        
        /*
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
        */
 
    }
    
    public void Confrontos(int n_rodada) throws IOException, FileNotFoundException, ClassNotFoundException
    {
        Dados dados = new Dados();
        Torneio torneio = new Torneio();
        Scanner sc = new Scanner(System.in);
        
        if (dados.VerificaDados("confrontos")) 
        {
                        
            Confrontos confrontos = new Confrontos();
            //confrontos.setVisible(true);
            
            ArrayList<model.Confrontos> listaConfrontos = torneio.EliminaByeCMD(dados.BuscaDadosConfrontos());
            ArrayList<model.Confrontos> novaListaConfrontos = listaConfrontos;
            //Confrontos linha = new Confrontos();
            
            int i, golMandante, golVisitante;
            int indice=0;
            for(Confrontos linha: listaConfrontos)
            {
                if( !linha.getTimeMandante().equals("Bye") && !linha.getTimeVisitante().equals("Bye"))
                {
                    if(n_rodada == linha.getRodada()){
                        System.out.println(linha.getTimeMandante()+" x "+linha.getTimeVisitante());
                        System.out.println("Gols "+linha.getTimeMandante());
                        golMandante=sc.nextInt();
                        linha.setGolMandante(golMandante);
                        System.out.println("Gols "+linha.getTimeVisitante());
                        golVisitante=sc.nextInt();
                        linha.setGolMandante(golVisitante);
                        System.out.println(linha.getTimeMandante()+" "+linha.getGolMandante()+" x "+linha.getGolVisitante()+" "+linha.getTimeVisitante());
                        novaListaConfrontos.set(indice, linha);
                    }
                }
                indice++;
            }
            dados.Armazena(novaListaConfrontos);

        }

    }
    
        public void ExibirResultados(int n_rodada) throws IOException, FileNotFoundException, ClassNotFoundException
    {
        Dados dados = new Dados();
        Torneio torneio = new Torneio();
        Scanner sc = new Scanner(System.in);
        
        if (dados.VerificaDados("confrontos")) 
        {
                        
            Confrontos confrontos = new Confrontos();
            
            ArrayList<model.Confrontos> listaConfrontos = torneio.EliminaByeCMD(dados.BuscaDadosConfrontos());
            
            int i, golMandante, golVisitante;
            
            for(Confrontos linha: listaConfrontos)
            {
                if( !linha.getTimeMandante().equals("Bye") && !linha.getTimeVisitante().equals("Bye"))
                {
                    if(n_rodada == linha.getRodada()){
                        System.out.println(linha.getTimeMandante()+" "+linha.getGolMandante()+" x "+linha.getGolVisitante()+" "+linha.getTimeVisitante());
                    }
                }
            }

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
}