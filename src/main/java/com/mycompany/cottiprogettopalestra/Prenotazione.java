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
    int codice,id;
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
        
        codice=p.getCodice();
        nome=p.getNome();
        cognome=p.getCognome();
        dataOra=p.getDataOra();
        tempoOccupazione=p.getTempoOccupazione();
        docce=p.getDocce();
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
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

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public LocalTime getTempoOccupazione() {
        return tempoOccupazione;
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

    public void setDataOra(int giorno,int mese,int anno,int ora,int minuto) 
    {
        dataOra=LocalDateTime.of(giorno, mese, anno, ora, minuto);
    }

    public void setTempoOccupazione(int ora,int minuto) 
    {
        tempoOccupazione=LocalTime.of(ora, minuto);
    }
    
    

    public void setDocce(boolean docce)
    {
        this.docce = docce;
    }
    
    
    

    @Override
    public String toString()
    {
        return "Prenotazione{" + "codice=" + codice + ", nome=" + nome + ", cognome=" + cognome + ", dataOra=" + dataOra + ", tempoOccupazione=" + tempoOccupazione + ", docce=" + docce + '}';
    }


    
    
    
    
}
