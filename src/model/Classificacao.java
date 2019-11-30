/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


public class Classificacao {

    private String time;
    private int pontos;
    private int jogos;
    private int vitoria;
    private int empate;
    private int derrota;
    private int golsP;
    private int golsC;
    private int saldo;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getVitoria() {
        return vitoria;
    }

    public void setVitoria(int vitoria) {
        this.vitoria = vitoria;
    }

    public int getEmpate() {
        return empate;
    }

    public void setEmpate(int empate) {
        this.empate = empate;
    }

    public int getDerrota() {
        return derrota;
    }

    public void setDerrota(int derrota) {
        this.derrota = derrota;
    }

    public int getGolsP() {
        return golsP;
    }

    public void setGolsP(int golsP) {
        this.golsP = golsP;
    }

    public int getGolsC() {
        return golsC;
    }

    public void setGolsC(int golsC) {
        this.golsC = golsC;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    private Classificacao MontaInfoClassificacao ( Confrontos confronto, boolean mandante, int rodada )
    {
        Classificacao retorno = new Classificacao();
           
        
        //Time inicial como visitante
        String time = confronto.getTimeVisitante();
        if (mandante) 
        {
            //Se for para verificar o mandate, troca o time
            time =  confronto.getTimeMandante();
        }
        
        
        if( confronto.getJogoRealizado())
        {
            retorno.setTime(time);
            retorno.setJogos(1);
            
            if (mandante) 
            {
                retorno.setGolsP(confronto.getGolMandante());
                retorno.setGolsC(confronto.getGolVisitante());
            }
            else
            {
                retorno.setGolsP(confronto.getGolVisitante());
                retorno.setGolsC(confronto.getGolMandante());
                
            }
            retorno.setSaldo(retorno.getGolsP() - retorno.getGolsC());
            
            if (retorno.getSaldo() > 0) 
            {
                 retorno.setVitoria(1);
                 retorno.setPontos(3);
            }
            else if(retorno.getSaldo() < 0)
            {
                retorno.setDerrota(1);
                retorno.setPontos(0);
            }
            else
            {
                retorno.setEmpate(1);
                retorno.setPontos(1);
            }

            
        }
        else
        {
            retorno.setTime(time);
            retorno.setPontos(0);
            retorno.setJogos(0);
            retorno.setVitoria(0);
            retorno.setEmpate(0);
            retorno.setDerrota(0);
            retorno.setGolsP(0);
            retorno.setGolsC(0);
            retorno.setSaldo(0);
        }
        
        return retorno;
    }
    
    public ArrayList<Classificacao> MontaTabClassificacao( ArrayList<Confrontos> confrontos )
    {
        ArrayList<Classificacao> retorno = new ArrayList<>();
        Classificacao classificacao = new Classificacao();
        Classificacao classificacaoAux = new Classificacao();
        
        //Iteração na lista de confrontos
        for(model.Confrontos linha: confrontos)
        { 
            //Na primeira rodada os times seram inseridos na lista da tabela
            if (linha.getRodada() == 1)
            {
                retorno.add(classificacao.MontaInfoClassificacao(linha, true, linha.getRodada()));
                retorno.add(classificacao.MontaInfoClassificacao(linha, false, linha.getRodada()));
            }
            else 
            {   
                int indice = 0;
                for(Classificacao linhaRet: retorno)
                {

                    if( linhaRet.getTime().equals(linha.getTimeVisitante()) )
                    {
                        classificacaoAux = classificacao.MontaInfoClassificacao(linha, false, linha.getRodada());
                        classificacaoAux.setJogos(classificacaoAux.getJogos() + linhaRet.getJogos());
                        classificacaoAux.setPontos(classificacaoAux.getPontos() + linhaRet.getPontos());
                        classificacaoAux.setVitoria(classificacaoAux.getVitoria() + linhaRet.getVitoria());
                        classificacaoAux.setEmpate(classificacaoAux.getEmpate() + linhaRet.getEmpate());
                        classificacaoAux.setDerrota(classificacaoAux.getDerrota() + linhaRet.getDerrota());
                        classificacaoAux.setGolsP(classificacaoAux.getGolsP() + linhaRet.getGolsP());
                        classificacaoAux.setGolsC(classificacaoAux.getGolsC() + linhaRet.getGolsC());
                        classificacaoAux.setSaldo(classificacaoAux.getSaldo() + linhaRet.getSaldo());
                        retorno.set(indice, classificacaoAux);
                    }
                    
                    if( linhaRet.getTime().equals(linha.getTimeMandante()) )
                    {
                        
                        classificacaoAux = classificacao.MontaInfoClassificacao(linha, true, linha.getRodada());
                        classificacaoAux.setJogos(classificacaoAux.getJogos() + linhaRet.getJogos());
                        classificacaoAux.setPontos(classificacaoAux.getPontos() + linhaRet.getPontos());
                        classificacaoAux.setVitoria(classificacaoAux.getVitoria() + linhaRet.getVitoria());
                        classificacaoAux.setEmpate(classificacaoAux.getEmpate() + linhaRet.getEmpate());
                        classificacaoAux.setDerrota(classificacaoAux.getDerrota() + linhaRet.getDerrota());
                        classificacaoAux.setGolsP(classificacaoAux.getGolsP() + linhaRet.getGolsP());
                        classificacaoAux.setGolsC(classificacaoAux.getGolsC() + linhaRet.getGolsC());
                        classificacaoAux.setSaldo(classificacaoAux.getSaldo() + linhaRet.getSaldo());
                        retorno.set(indice, classificacaoAux);
                    }

                    indice++;
                }
            }
            
        }
        
        return retorno;
    }
}
