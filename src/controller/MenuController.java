/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Arquivos;


public class MenuController {
    
    public void CriaTorneio() throws IOException
    {   
        Arquivos arquivo = new Arquivos();
        
        boolean vl_arqexiste = arquivo.VerificaArqTimes();
        
        if (vl_arqexiste) 
        {
            
        }
        /*
        FileWriter writer;
	writer = new FileWriter("arquivo_torneio.txt", true);
	BufferedWriter buffWriter = new BufferedWriter(writer);
	
	writer.write("Torneio");
	

	writer.flush();
	buffWriter.close();
	writer.close();*/

    }
    
    public void Classificacao()
    {
        
    }
    
    public void Confrontos()
    {
        
    }
}
