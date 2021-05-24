/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cottiprogettopalestra;

import java.io.Serializable;
import java.time.*;

/**
 *
 * @author cotti
 */
public class Prenotazione  implements Serializable
{
    int codice;
    String nome;
    String cognome;
    LocalDate data;
    LocalTime ora;
    LocalTime tempoOccupazione;
    String docce;
    
    /**
     * costruttore della classe prenotazione
     * consente di istanziare una prenotazione
     * @param codice
     * @param nome
     * @param cognome
     * @param anno
     * @param mese
     * @param giorno
     * @param ora
     * @param minuto
     * @param oraOccupazione
     * @param minutoOccupazione
     * @param docce
     */
    public Prenotazione(int codice,String nome,String cognome, int anno,int mese,int giorno,int ora,int minuto,int oraOccupazione,int minutoOccupazione,String docce)
    {
        
        this.codice=codice;
        this.nome=nome;
        this.cognome=cognome;
        this.data=LocalDate.of(anno, mese , giorno);
        this.ora=LocalTime.of(ora, minuto);
        this.tempoOccupazione=LocalTime.of(oraOccupazione, minutoOccupazione);
        this.docce=docce;
    }
    
    /**
     *costruttore di copia prenotazione
     * @param p
     */
    public Prenotazione(Prenotazione p)
    {
        
        codice=p.getCodice();
        nome=p.getNome();
        cognome=p.getCognome();
        data=p.getData();
        ora=p.getOra();
        tempoOccupazione=p.getTempoOccupazione();
        docce=p.getDocce();
    }
    
    public Prenotazione()
    {
        codice=0;
        docce=null;
        nome=null;
        cognome=null;
        ora=null;
        data=null;
        tempoOccupazione=null;
    }

    /**
     *permette di visualizzare il valore della variabile codice
     * @return
     */
    public int getCodice() 
    {
        return codice;
    }

    /**
     *permette di visualizzare il valore della variabile nome
     * @return
     */
    public String getNome() 
    {
        return nome;
    }

    /**
     *permette di visualizzare il valore della variabile cognome
     * @return
     */
    public String getCognome() 
    {
        return cognome;
    }
    
    /**
     *permette di visualizzare il valore della variabile data
     * @return
     */
    public LocalDate getData() {
        return data;
    }

    /**
     *permette di visualizzare il valore della variabile ora
     * @return
     */
    public LocalTime getOra() 
    {
        return ora;
    }

    /**
     *permette di visualizzare il valore della variabile tempoOccupazione
     * @return
     */
    public LocalTime getTempoOccupazione() {
        return tempoOccupazione;
    }
    
    /**
     *permette di visualizzare il valore della variabile docce
     * @return
     */
    public String getDocce() 
    {
        return docce;
    }

    /**
     *permette di assegnare un valore alla variabile codice
     * @param codice
     */
    public void setCodice(int codice) {
        this.codice = codice;
    }

    /**
     *permette di assegnare un valore alla variabile nome
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *permette di assegnare un valore alla variabile cognome
     * @param cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     *permette di assegnare un valore alla variabile data
     * @param giorno
     * @param mese
     * @param anno
     */
    public void setData(int giorno,int mese,int anno) 
    {
        data=LocalDate.of(giorno, mese, anno);
    }

    /**
     *permette di assegnare un valore alla variabile ora
     * @param oraP
     * @param minutoP
     */
    public void setOra(int oraP,int minutoP) 
    {
        ora=LocalTime.of(oraP, minutoP);
    }
    
    /**
     *permette di assegnare un valore alla variabile tempoOccupazione
     * @param ora
     * @param minuto
     */
    public void setTempoOccupazione(int ora,int minuto) 
    {
        tempoOccupazione=LocalTime.of(ora, minuto);
    }
    
    /**
     *permette di assegnare un valore alla variabile docce
     * @param docce
     */
    public void setDocce(String docce)
    {
        this.docce = docce;
    }

    @Override
    public String toString() {
        return "Prenotazione{" + "codice=" + codice + ", nome=" + nome + ", cognome=" + cognome + ", data=" + data + ", ora=" + ora + ", tempoOccupazione=" + tempoOccupazione + ", docce=" + docce + '}';
    }


    
    

    


    
    
    
    
}
