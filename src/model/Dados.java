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


public class Dados {
    //Método para verificar se o arquivo existe
    //0 - Existe e está vazio
    //1 - Existe e está preenchido
    //2 - Arquivo não existe
    public int VerificaDados( File file ) throws FileNotFoundException, IOException
    {
      
        //Verifica se o arquivo existe
        if(!file.exists()) 
        { 
            return 2;
        } 
        else //Se existe verifica se possui informações no arquivo
        {
            LineNumberReader linhas = new LineNumberReader(new FileReader(file));
            linhas.skip(file.length()); 
            
            //Contador de quabras de linhas, por isso, soma-se 1 a última linha
            if( ( linhas.getLineNumber() + 1 ) == 0 )
            {
                 return 0;
            }
        }
        return 1;
    }
    
    public ArrayList<String> BuscaTimes() throws FileNotFoundException, IOException
    {
        
        ArrayList<String> retorno = new ArrayList<String>();
        
        InputStream file = new FileInputStream("times.txt");
	InputStreamReader file_reader = new InputStreamReader(file);
	BufferedReader buffer = new BufferedReader(file_reader);

        String line = "";
        int indice = 0;
        
        //Iteração no arquivo de times
        while(line != null)
        {   
            //Busca a linha
            line = buffer.readLine();
            if (line != null) {
                //Adiciona o time no vetor
                retorno.add(line);
                
            }
        }
        
        return retorno;
        
    }
    
    public void CriaConfrontos() throws IOException
    {
        FileWriter writerIndc = new FileWriter("confrontos.txt", true);
	BufferedWriter buffWriterIndc = new BufferedWriter(writerIndc);
    }
}
