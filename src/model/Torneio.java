/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static java.time.temporal.TemporalAdjusters.next;
import java.util.List;
import javax.swing.JOptionPane;

public class Torneio {
    
    public void CriaTorneio(String data) throws IOException
    {
         
        Dados dados = new Dados();
        ArrayList<String> listaDeTimes  = dados.BuscaTimes();
        List<Confrontos> listaConfrontos = new ArrayList<>();
        
        listaConfrontos = CriaConfrontos(listaDeTimes, data);
        dados.Armazena(listaConfrontos);
        JOptionPane.showMessageDialog(null, "Arquivo confrontos criado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    
       
    private LocalDate ConverteData(String data)
    {
        String vetorData[] = data.split("/");
        int dia = Integer.parseInt(vetorData[0]);
        int mes = Integer.parseInt(vetorData[1]);
        int ano = Integer.parseInt(vetorData[2]);
        LocalDate dataAtual   = LocalDate.of(ano, mes, dia);
        return dataAtual;
    }
    private LocalDate VerificaData(LocalDate dataAtual)
    {
        if(dataAtual.getDayOfWeek().equals("SUNDAY") || dataAtual.getDayOfWeek().equals("WEDNESDAY"))
        {
             return dataAtual;
        }
        else
        {
            return ProxData(dataAtual);
        }
         
    }
    
    private LocalDate ProxData(LocalDate dataAtual)
    {

        LocalDate proxQuarta  = dataAtual.with(next(WEDNESDAY));
        LocalDate proxDomingo = dataAtual.with(next(SUNDAY));
        
        //Se a próxima quarta for depois do próximo domingo
        if (proxQuarta.isAfter(proxDomingo)) 
        {   
           return proxDomingo;
        }
        else
        {
            return proxQuarta;
        }
    }
    
    //private void CriaConfrontos(List<String> listaDeTimes, String data)
    private List<Confrontos> CriaConfrontos(ArrayList<String> listaDeTimes, String data)
    {   
        List<Confrontos> retornoConfrontos = new ArrayList<>();
        int metade = listaDeTimes.size() / 2;
        int num_time =  listaDeTimes.size();
        //Caso tenha número ímpar de times
        if (listaDeTimes.size() % 2 != 0) 
        {
            //Adiciona um time auxiliar
            listaDeTimes.add("Bye");
            metade++;
            num_time++;
        }
        
        //Lista auxiliar sem o primeiro time da principal
        ArrayList<String> timesAux = new ArrayList();
         for(int i = 1; i< listaDeTimes.size();i++)
        {
            timesAux.add(listaDeTimes.get(i));

        }
        int timesAuxQuant = timesAux.size();
        
        //Converte a data de ínicio para o formato
        LocalDate dataAtual = ConverteData(data);
        
        //Verifica se o dia digitado já uma quarta ou domingo
        dataAtual = VerificaData(dataAtual);
        for( int i = 0; i < ( num_time - 1 ); i++ )
        {

            int timeIndice = i % timesAuxQuant;
            String timeM, timeV;
            //Jogos com o primeiro da lista como visitante
            if(i%2 == 0) 
            {
                timeM = listaDeTimes.get(0); 
                timeV = timesAux.get(timeIndice);
            }
            else
            {
                timeM = timesAux.get(timeIndice); 
                timeV = listaDeTimes.get(0);
            }
            
            Confrontos confrontos = new Confrontos( dataAtual , i+1 , timeM, 0, timeV, 0, false);
            retornoConfrontos.add(confrontos);
            
            
            for(int j=1; j < metade; j++)
            {
                int primeiroTime = ( i + j  ) % timesAuxQuant;
                int segundoTime  = ( i + timesAuxQuant - j ) % timesAuxQuant;
                confrontos = new Confrontos( dataAtual , i+1 , timesAux.get(primeiroTime), 0, timesAux.get(segundoTime) , 0, false);
                retornoConfrontos.add(confrontos);
            }
            dataAtual = ProxData(dataAtual);
            
        }
        
        return retornoConfrontos;
    }
}
