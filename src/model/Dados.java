/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Arquivos;


public class Dados {
    
    private final String FormaDados = "A";
    
    public boolean VerificaDados( ) throws FileNotFoundException, IOException, ClassNotFoundException
    {   
        
        if( this.FormaDados.equals("A") )
        {
            Arquivos arquivo = new Arquivos();
            return arquivo.VerificaTorneio();
        }
        else
        {
            BancoDeDados banco = new BancoDeDados();
            return banco.VerificaTorneio();
        }
    }
    
    public ArrayList<String> BuscaTimes() throws FileNotFoundException, IOException
    {
        
        if( this.FormaDados.equals("A") )
        {
            Arquivos arquivo = new Arquivos();
            return arquivo.MontaListaTimes();
        }
        else
        {
            BancoDeDados banco = new BancoDeDados();
            return banco.MontaListaTimes();
        }
        
    }
    
    public void Armazena(List<Confrontos> listaConfrontos) throws IOException
    {
        if( this.FormaDados.equals("A") )
        {
            Arquivos arquivo = new Arquivos();
            arquivo.ArmazenaConfrontos(listaConfrontos);
        }
        else
        {
            BancoDeDados banco = new BancoDeDados();
            banco.ArmazenaConfrontos(listaConfrontos);
        }
        
        
    }

}
