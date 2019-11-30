/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



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
    
    public ArrayList<Confrontos> BuscaDadosConfrontos() throws IOException
    {
        if( this.FormaDados.equals("A") )
        {
            Arquivos arquivo = new Arquivos();
            return arquivo.DadosConfrontos();
        }
        else
        {
            BancoDeDados banco = new BancoDeDados();
           return banco.DadosConfrontos();
        }
    }

}
