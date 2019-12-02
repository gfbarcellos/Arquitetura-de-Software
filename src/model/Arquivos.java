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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Arquivos implements interfaces.IArmazenamento {
    
    @Override
    public boolean VerificaTorneio( String valor ) throws IOException
    {   
        //Faz a verificação da situação do arquivo
        int info_arquivo = VerificaDado(valor);
        //Verifica o status do arquivo de times
        switch (info_arquivo) {
            case 1:
                break;
             default:
                return false;
        }
        return true;
    }
    
    @Override
    public int VerificaDado(String valor) throws FileNotFoundException, IOException
    {
         
        File file = new File( valor + ".txt");
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
    
    @Override
    public ArrayList<String> MontaListaTimes() throws FileNotFoundException, IOException
    {
        
        ArrayList<String> retorno = new ArrayList<String>();
        
        InputStream file = new FileInputStream("times.txt");
	InputStreamReader file_reader = new InputStreamReader(file);
	BufferedReader buffer = new BufferedReader(file_reader);

        String line = "";
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
    
    @Override
    public void ArmazenaConfrontos(List<Confrontos> listaConfrontos) throws IOException
    {
        FileWriter writer;
	writer = new FileWriter("confrontos.txt", false);

        for(Confrontos linha: listaConfrontos)
        { 
            writer.write(linha.getData()+";"+linha.getRodada()+";"+linha.getTimeMandante()+";"+linha.getGolMandante()+";"+linha.getTimeVisitante()+";"+linha.getGolVisitante()+";"+linha.getJogoRealizado()+"\n");
        }
        writer.flush();
	writer.close();
    }
    
    @Override
    public ArrayList<Confrontos> DadosConfrontos() throws FileNotFoundException, IOException
    {
        ArrayList<Confrontos> retorno = new ArrayList<>();
        
        InputStream file = new FileInputStream("confrontos.txt");
	InputStreamReader file_reader = new InputStreamReader(file);
	BufferedReader buffer = new BufferedReader(file_reader);

        String line = "";
        //Iteração no arquivo de times
        while(line != null)
        {   
            //Busca a linha
            line = buffer.readLine();
            if (line != null)        
            {
                String[] dados = line.split(";");
                
                LocalDate data = LocalDate.parse(dados[0]); 
                int rodada = Integer.parseInt(dados[1]);
                int golsM  = Integer.parseInt(dados[3]);
                int golsV  = Integer.parseInt(dados[5]);
                boolean jogo = Boolean.parseBoolean(dados[6]);
                
                Confrontos confrontos = new Confrontos(data, rodada, dados[2], golsM, dados[4], golsV, jogo);
                //Adiciona o time no vetor
                retorno.add(confrontos); 
            }
        }
        
        return retorno;
    }
}
