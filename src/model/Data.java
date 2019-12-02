/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.next;

/**
 *
 * @author gbarc
 */
public class Data {
    
    public LocalDate ConverteData(String data)
    {
        String vetorData[] = data.split("/");
        int dia = Integer.parseInt(vetorData[0]);
        int mes = Integer.parseInt(vetorData[1]);
        int ano = Integer.parseInt(vetorData[2]);
        LocalDate dataAtual   = LocalDate.of(ano, mes, dia);
        return dataAtual;
    }
    public LocalDate VerificaData(LocalDate dataAtual)
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
    
    public LocalDate ProxData(LocalDate dataAtual)
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
    
}
