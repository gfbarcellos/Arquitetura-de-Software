/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
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


public class BancoDeDados {
    
    public void ArmazenaConfrontos(List<Confrontos> listaConfrontos) throws IOException
    {
        FileWriter writer;
	writer = new FileWriter("confrontos.txt", true);

        for(Confrontos linha: listaConfrontos)
        { 
            writer.write(linha.getData()+";"+linha.getRodada()+";"+linha.getTimeMandante()+";"+linha.getGolMandante()+";"+linha.getTimeVisitante()+";"+linha.getGolVisitante()+";"+linha.getJogoRealizado()+"\n");
        }
        writer.flush();
	writer.close();
    }
    
    public boolean VerificaTorneio( ) throws IOException
    {   
        File file_times = new File("times.txt"); 
        
        //Faz a verificação da situação do arquivo
        int info_arquivo = VerificaTimes(file_times);
        
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
    
    public int VerificaTimes( File file) throws FileNotFoundException, IOException
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
    
    public ArrayList<String> MontaListaTimes() throws FileNotFoundException, IOException
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
    
    public ArrayList<Confrontos> DadosConfrontos()
    {
        ArrayList<Confrontos> retorno = new ArrayList<Confrontos>();
        
        return retorno;
    }
    
}
