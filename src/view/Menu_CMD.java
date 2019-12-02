/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Confrontos;
import model.Torneio;

/**
 *
 * @author mauricio
 */

public class Menu_CMD {
    
    static Scanner sc = new Scanner(System.in);
    static int opcao = 0;
    static boolean jogoRealizado;
    static int golVisitante;
    static String timeVisitante;
    static int golMandante;
    static String timeMandante;
    static int rodada;
    static String data;
    
    /**
     *
     */
    public static void exibe_menu() {
        
        do{
            System.out.println("\n\n### CALCULADORA DO BRASILEIR�O ###");
            System.out.println("\n     =========================");
            System.out.println(" |     1 - Iniciar torneio   |");
            System.out.println(" |     2 - Classifica��o     |");
            System.out.println(" |     3 - Confrontos        |");            
            System.out.println(" |     0 - Sair              |");
            System.out.println("     =========================\n");

            opcao = sc.nextInt();
            System.out.print("\n");
            switch (opcao) {
                case 1: 
                    System.out.println("Data inicial: \n");
                    data=sc.next();
                    
                    System.out.println("Gravou a data \n");//depurador
                    
                    Torneio torneio = new Torneio();
            {
                try {
                    torneio.CriaTorneio(data);
                } catch (IOException ex) {
                    Logger.getLogger(Menu_CMD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    System.out.println("Invocou m�todo CriaTorneio \n");
                    
                    System.out.println("Sai do Exception \n");
                    System.out.println("Escreve abaixo a data \n");
                    System.out.println(data);
                    System.out.println(torneio);
                    break;
                case 2:
                    
                    System.out.println("Classifica��o");
                    break;
                case 3:
                    
                    System.out.println("Confrontos");
                    break;                    
                case 0:
                    break;
                default:
                    System.out.println("OP��O INV�LIDA");
                    break;
            }            
                
        } while (opcao != 0);
        
    }
    
}
    