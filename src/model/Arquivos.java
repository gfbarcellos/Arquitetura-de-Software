/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import javax.swing.JOptionPane;


public class Arquivos {
    
    //Método para verificar se o arquivo te times existe
    public boolean VerificaArqTimes() throws FileNotFoundException, IOException
    {
        File file = new File("times.txt"); 
        
        //Verifica se o arquivo existe
        if(!file.exists()) 
        { 
            JOptionPane.showMessageDialog(null, "Arquivo de times não existe", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } 
        else //Se existe verifica se possui informações no arquivo
        {
            LineNumberReader linhas = new LineNumberReader(new FileReader(file));
            linhas.skip(file.length()); 
            if( linhas.getLineNumber() == 0 )
            {
                JOptionPane.showMessageDialog(null, "Arquivo de times está vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }        
            
}
