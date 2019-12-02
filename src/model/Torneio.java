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
import javax.swing.table.DefaultTableModel;

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
    
    public void CriaTorneioCMD(String data) throws IOException
    {
         
        Dados dados = new Dados();
        ArrayList<String> listaDeTimes  = dados.BuscaTimes();
        List<Confrontos> listaConfrontos = new ArrayList<>();
        
        listaConfrontos = CriaConfrontos(listaDeTimes, data);
        dados.Armazena(listaConfrontos);
    }
    
    //private void CriaConfrontos(List<String> listaDeTimes, String data)
    private List<Confrontos> CriaConfrontos(ArrayList<String> listaDeTimes, String data)
    {   
        List<Confrontos> retornoConfrontos = new ArrayList<>();
        Data cData = new Data();
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
        LocalDate dataAtual = cData.ConverteData(data);
        
        //Verifica se o dia digitado já uma quarta ou domingo
        dataAtual = cData.VerificaData(dataAtual);
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
            dataAtual = cData.ProxData(dataAtual);
            
        }
        
        return retornoConfrontos;
    }
    
    public int NumeroDeRodadas( ArrayList<Confrontos> listaConfrontos )
    {
        int rodada = 0;
        for(model.Confrontos linha: listaConfrontos)
        { 
            rodada = linha.getRodada();
        }
        
        return rodada;
    }
    
    public ArrayList<Confrontos> BuscaConfrontosDaRodada(int rodada, ArrayList<Confrontos> listaConfrontos)
    {
        ArrayList<Confrontos> retorno = new ArrayList<>();
        
        for(model.Confrontos linha: listaConfrontos)
        { 
            if( linha.getRodada() == rodada ) 
            {
                retorno.add(linha);
            }
        }
        
        return retorno;
    }
    
    public void MontaResultadosDaRodada(DefaultTableModel linha, int rodada) throws IOException
    {
        Dados dados = new Dados();
        
        ArrayList<model.Confrontos> listaConfrontos = dados.BuscaDadosConfrontos();
        ArrayList<model.Confrontos> novaListaConfrontos = new ArrayList<>();

        for(model.Confrontos linhaConfrontos: listaConfrontos)
        { 
            if (linhaConfrontos.getRodada() == rodada)
            {
                if(linhaConfrontos.getTimeMandante().equals("Bye") || linhaConfrontos.getTimeVisitante().equals("Bye"))
                {
                    novaListaConfrontos.add(linhaConfrontos);
                    continue;
                }
                for(int i = 0; i<linha.getRowCount();i++)
                {   
                    if( linha.getValueAt(i, 0).equals(linhaConfrontos.getTimeMandante()) )
                    {

                        int golM = Integer.parseInt(linha.getValueAt(i, 1).toString());
                        int golV = Integer.parseInt(linha.getValueAt(i, 3).toString());
                        Confrontos confrontos = new Confrontos(
                                linhaConfrontos.getData(), 
                                rodada, 
                                linhaConfrontos.getTimeMandante(), 
                                golM, 
                                linhaConfrontos.getTimeVisitante(), 
                                golV, 
                                true
                        );
                        novaListaConfrontos.add(confrontos);
                    }
                }
            }
            else
            {
                novaListaConfrontos.add(linhaConfrontos);
            }
        }
        
        dados.Armazena(novaListaConfrontos);
    }
    
    public ArrayList<Confrontos> EliminaBye(ArrayList<Confrontos> confrontos)
    {
        ArrayList<Confrontos> retorno = new ArrayList<>();
        
        for( Confrontos linha: confrontos )
        {
            if( !linha.getTimeMandante().equals("Bye") && !linha.getTimeVisitante().equals("Bye"))
            {
                retorno.add(linha);
            }
        }
        
        return retorno;
    }
}
