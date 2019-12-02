/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Torneio;
import model.Confrontos;

/**
 *
 * @author mauricio
 */

public class Menu_CMD {
    
    static Scanner sc = new Scanner(System.in);
    static int opcao = 0;
    static String data;
    
    /**
     *
     */
    public static void exibe_menu() {
        
        do{
            System.out.println("\n\n### CALCULADORA DO BRASILEIR�O ###");
            System.out.println("\n     =========================");
            System.out.println(" |     1 - Iniciar torneio   |");
            System.out.println(" |     2 - Classificação     |");
            System.out.println(" |     3 - Confrontos        |");            
            System.out.println(" |     0 - Sair              |");
            System.out.println("     =========================\n");

            opcao = sc.nextInt();
            System.out.print("\n");
            switch (opcao) {
                case 1: 
                    System.out.println("Data inicial: \n");
                    data=sc.next();
                    
                    Torneio torneio = new Torneio();
                    {
                        try {
                            torneio.CriaTorneioCMD(data);
                        } catch (IOException ex) {
                            Logger.getLogger(Menu_CMD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    System.out.println("Novo torneio criado com sucesso! \n");
                    break;
                case 2:
                    
                    System.out.println("Classificação");
                    break;
                case 3:
                    
                    List<Confrontos> listaConfrontos = new ArrayList<>();
                    listaConfrontos = CriaConfrontos(listaDeTimes, data);
                    
                    //Torneio retorno = new Torneio();
                    //retorno = Torneio.BuscaConfrontosDaRodada();
                    
                    /*
                    int rodada = 0;
                    LocalDate dataRodada = LocalDate.now();
                    String timeMandante = "0";
                    int golMandante = 0;
                    String timeVisitante = "0";
                    int golVisitante = 0;
                    boolean jogoRealizado = false;
                    */                  
                    
                    //Confrontos confronto = new Confrontos(dataRodada, rodada, timeMandante, golMandante, timeVisitante, golVisitante, jogoRealizado);
                    //confronto.Confrontos(dataRodada, rodada, timeMandante, golMandante, timeVisitante, golVisitante, jogoRealizado);
                    //confronto.getRodada();
                    
                    /*
                     public Confrontos(LocalDate data, int rodada, String timeMandante, 
                    int golMandante, String timeVisitante, int golVisitante, boolean jogoRealizado) {
                        this.data = data;
                        this.rodada = rodada;
                        this.timeMandante = timeMandante;
                        this.golMandante = golMandante;
                        this.timeVisitante = timeVisitante;
                        this.golVisitante = golVisitante;
                        this.jogoRealizado = jogoRealizado;
                    }*/
                    
                    System.out.println("Confrontos");
                    break;                    
                case 0:
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
                    break;
            }            
                
        } while (opcao != 0);
        
    }
    
}
    