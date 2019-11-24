/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Torneio {
    
    public void CriaTorneio()
    {
 
    }
    
    public boolean VerificaTorneio() throws IOException
    {
        File file_times = new File("times.txt"); 
        Arquivos arquivo = new Arquivos();
        
        //Faz a verificação da situação do arquivo
        int info_arquivo = arquivo.VerificaArquivo(file_times);
        
        //Verifica o status do arquivo de times
        switch (info_arquivo) {
            case 1:
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Arquivo de times não existe", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
             default:
                JOptionPane.showMessageDialog(null, "Arquivo de times está vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
        }
        return true;
    }
    
    private void CriaConfrontos()
    {
        
    }
}
