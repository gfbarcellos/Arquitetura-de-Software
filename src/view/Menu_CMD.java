/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import controller.Controller_CMD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            System.out.println(" |     4 - Exibir resultados |");
            System.out.println(" |     0 - Sair              |");
            System.out.println("     =========================\n");

            opcao = sc.nextInt();
            System.out.print("\n");
            switch (opcao) {
                case 1: 
                    System.out.println("Data inicial: \n");
                    data=sc.next();
                    
                    //Cria objeto no controlador que chama o método
                    Controller_CMD torneio = new Controller_CMD();
                    {
                        try {
                            //Chama o método que cria o torneio no controlador
                            torneio.NovoTorneio(data);
                        } catch (IOException ex) {
                            Logger.getLogger(Menu_CMD.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Menu_CMD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    System.out.println("Novo torneio criado com sucesso! \n");
                    break;
                case 2:
                    
                    //Cria objeto no controlador que chama o método
                    Controller_CMD classificacao = new Controller_CMD();    
                    {
                        try {
                            //Chama o método classificação no controlador
                            classificacao.Classificacao();
                        } catch (IOException ex) {
                            Logger.getLogger(Menu_CMD.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Menu_CMD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case 3:
                    int n_rodada;
                    System.out.println("Informe o número da rodada\n");
                    n_rodada=sc.nextInt();
                    
                    Controller_CMD confrontos = new Controller_CMD();
                    {
                        try {
                            confrontos.Confrontos(n_rodada);
                        } catch (IOException ex) {
                            Logger.getLogger(Menu_CMD.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Menu_CMD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;                                        
                    case 4:
                    System.out.println("Informe o número da rodada\n");
                    n_rodada=sc.nextInt();
                    
                    Controller_CMD resultados = new Controller_CMD();
                    {
                        try {
                            resultados.ExibirResultados(n_rodada);
                        } catch (IOException ex) {
                            Logger.getLogger(Menu_CMD.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Menu_CMD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
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
    