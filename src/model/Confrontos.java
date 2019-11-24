/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author gbarc
 */
public class Confrontos {
    
    private LocalDate data;
    private int rodada;
    private String timeMandante;
    private int golMandante;
    private String timeVisitante;
    private int golVisitante;
    private boolean jogoRealizado;

    
    public Confrontos(LocalDate data, int rodada, String timeMandante, int golMandante, String timeVisitante, int golVisitante, boolean jogoRealizado) {
        this.data = data;
        this.rodada = rodada;
        this.timeMandante = timeMandante;
        this.golMandante = golMandante;
        this.timeVisitante = timeVisitante;
        this.golVisitante = golVisitante;
        this.jogoRealizado = jogoRealizado;
    }
    
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public String getTimeMandante() {
        return timeMandante;
    }

    public void setTimeMandante(String timeMandante) {
        this.timeMandante = timeMandante;
    }

    public int getGolMandante() {
        return golMandante;
    }

    public void setGolMandante(int golMandante) {
        this.golMandante = golMandante;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public int getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(int golVisitante) {
        this.golVisitante = golVisitante;
    }
    
    public boolean getJogoRealizado() {
        return jogoRealizado;
    }

    public void setJogoRealizado(boolean jogoRealizado) {
        this.jogoRealizado = jogoRealizado;
    }
}
