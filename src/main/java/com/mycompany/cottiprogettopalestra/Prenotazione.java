/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cottiprogettopalestra;

import java.time.*;

/**
 *
 * @author cotti
 */
public class Prenotazione 
{
    int codice;
    String nome;
    String cognome;
    LocalDateTime dataOra;
    LocalTime tempoOccupazione;
    boolean docce;
    
    public Prenotazione(int codice,String nome,String cognome, int anno,int mese,int giorno,int ora,int minuto,int oraOccupazione,int minutoOccupazione,boolean docce)
    {
        this.codice=codice;
        this.nome=nome;
        this.cognome=cognome;
        this.dataOra=LocalDateTime.of(anno, mese , giorno, ora, minuto);
        this.tempoOccupazione=LocalTime.of(oraOccupazione, minutoOccupazione);
        this.docce=docce;
    }
    
    public Prenotazione(Prenotazione p)
    {
        p.codice=getCodice();
        p.nome=getNome();
        p.dataOra=dataOra;
        p.tempoOccupazione=tempoOccupazione;
        p.docce=getDocce();
    }

    public int getCodice() 
    {
        return codice;
    }

    public String getNome() 
    {
        return nome;
    }

    public String getCognome() 
    {
        return cognome;
    }

    public int getGiorno()
    {
        return dataOra.getDayOfMonth();
    }
    
    public int getMese()
    {
        return dataOra.getMonthValue();
    }
    
    public int getAnno()
    {
        return dataOra.getYear();
    }
    
    public int getOra()
    {
        return dataOra.getHour();
    }
    
    public int getMinuto()
    {
        return dataOra.getMinute();
    }

    public int getOraOccupazione()
    {
        return tempoOccupazione.getHour();
    }
    
    public int getMinutoOccupazione()
    {
        return tempoOccupazione.getMinute();
    }

    public boolean getDocce() 
    {
        return docce;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDocce(boolean docce) {
        this.docce = docce;
    }
    
    public void setGiorno(boolean docce) {
        this.docce = docce;
    }
    

    @Override
    public String toString()
    {
        return "Prenotazione{" + "codice=" + codice + ", nome=" + nome + ", cognome=" + cognome + ", dataOra=" + dataOra + ", tempoOccupazione=" + tempoOccupazione + ", docce=" + docce + '}';
    }


    
    
    
    
}
