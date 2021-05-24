/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cottiprogettopalestra;

import eccezioni.*;
import file.TextFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

/**
 *
 * @author cotti
 */
public class Palestra  implements Serializable
{
    private Prenotazione[] elencoPrenotazioni;
    private final int N_MAX_PRENOTAZIONI=100;
    private int nPrenotazioniPresenti;

    /**
     *costruttore classe palestra
     * permette di istanziare un array di prenotazioni
     */
    public Palestra()
    {
        elencoPrenotazioni=new Prenotazione[N_MAX_PRENOTAZIONI];
    }
    
    /**
     *permette di visualizzare il valore della variabile docce
     * @return
     */
    public int getNumPrenotazioni()
    {
        int contatore=0;
   
        for(int i=0;i<N_MAX_PRENOTAZIONI;i++)
        {
            if(elencoPrenotazioni[i]!=null)
                contatore++;
        }
        return contatore;
    }
    
    /**
     *permette di visualizzare il valore della variabile N_MAX_PRENOTAZIONI
     * @return
     */
    public int getN_MAX_PRENOTAZIONI() 
    {
        return N_MAX_PRENOTAZIONI;
    }
    
    /**
     *permette di visualizzare il valore della variabile nPrenotazioniPresenti
     * @return
     */
    public int getnPrenotazioniPresenti() 
    {
        return nPrenotazioniPresenti;
    }
        
    /**
     *permette di visualizzare una prenotazione nella posizione inserita
     * @param posizione
     * @return
     */
    public Prenotazione getPrenotazionePosizione(int posizione)
    {
        return elencoPrenotazioni[posizione];
    }
    
    /**
     *permette di visualizzare il valore della variabile codice nella posizione inserita
     * @param posizione
     * @return
     */
    public int getCodice(int posizione)
    {
         return elencoPrenotazioni[posizione].getCodice();  
    }
    
    /**
     *permette di aggiungere una prenotazione all'array palestra
     * @param prenotazione
     * @return
     */
    public int aggiungiPrenotazione(Prenotazione prenotazione)
    {
        elencoPrenotazioni[nPrenotazioniPresenti]=new Prenotazione(prenotazione);
            nPrenotazioniPresenti++;
            return 0;
    }
    
    
    private void aggiornaPosizioniprenotazioni(int posizione)
    {
        for (int i=posizione;i<nPrenotazioniPresenti-1;i++)
        {
            elencoPrenotazioni[i]=elencoPrenotazioni[i+1];
        }
        elencoPrenotazioni[nPrenotazioniPresenti-1]=null;      
        nPrenotazioniPresenti--;        
    }
    
    /**
     *permette di eliminare una prenotazione dall'array palestra
     * inserendo il codice
     * @param matricola
     * @return
     */
    public int rimuoviPrenotazione(long matricola)
    {
        int posizionePrenotazione;
        for (int i=0;i<nPrenotazioniPresenti;i++)   //cerco lo studente
        {
            if (elencoPrenotazioni[i]!=null)
            {
                if (elencoPrenotazioni[i].getCodice()==matricola)
                {
                    posizionePrenotazione=i;
                    aggiornaPosizioniprenotazioni(i);
                    return 0;
                }
                    
            }
        }
        return -1;
    }
    
    /**
     *permette di visualizzare tutte le prenotazioni di un giorno
     * @param data
     * @return
     */
    public Prenotazione[] prenotazioniGiorno(LocalDate data)  throws DateTimeException, InputMismatchException
    {
        Prenotazione[] prenotazioniGiorno=new Prenotazione[getNumPrenotazioni()];
        Prenotazione p;
        int x=0;
        int c=0;
        
        for(int i=0;i<getNumPrenotazioni();i++)
        {
            if(elencoPrenotazioni[i].getData().isEqual(data)==true)
            {
                p=elencoPrenotazioni[i];
                prenotazioniGiorno[x]=p;
                x++;
            }
            else if(elencoPrenotazioni[i].getData().isEqual(data)==false)
            {
                c++; 
            }
        }
        
        return prenotazioniGiorno;
          
    }
    
    /**
     *permette di visualizzare tutte le prenotazioni di una persona
     * in ordine cronologico
     * @param nome
     * @param cognome
     * @return
     */
    public Prenotazione[] PrenotazioniOrdineCronologico (String nome,String cognome) throws ArrayIndexOutOfBoundsException,InputMismatchException
    {
        Prenotazione[] prenotazioniPersona=new Prenotazione[getnPrenotazioniPresenti()];
        Prenotazione prenotazione;
        int x=0;
        int c=0;
        
        for(int i=0;i<getnPrenotazioniPresenti();i++)
        {
            if(elencoPrenotazioni[i].getNome().compareToIgnoreCase(nome)==0 && elencoPrenotazioni[i].getCognome().compareToIgnoreCase(cognome)==0)
            {
                prenotazione=elencoPrenotazioni[i];
                prenotazioniPersona[x]=prenotazione;
                x++;
            }
            else if(elencoPrenotazioni[i].getNome().compareToIgnoreCase(nome)!=0 && elencoPrenotazioni[i].getCognome().compareToIgnoreCase(cognome)!=0)
            {
                c++;
            }
        }
        
        
        prenotazioniPersona=Ordinatore.selectionSortPrenotazioniPersonaCronologico(prenotazioniPersona);
        return prenotazioniPersona;
    }
    
    
    
    public String toString()
    {
        Prenotazione p;
        String s="";
        
        for(int i=0;i<N_MAX_PRENOTAZIONI;i++)
        {
            if(elencoPrenotazioni[i]!=null)
            {
                p=elencoPrenotazioni[i];
                s=s+"Posizione: "+ i + " " + p.toString() + "\n";
            }
            
        }
        return s;
    }
    
    /**
     *permette di salvare le informazioni su un file txt
     * @param nomeFile
     * @throws IOException
     * @throws FileException
     */
    public void salvaRevisione(String nomeFile) throws IOException, FileException
    {
        TextFile f1=new TextFile(nomeFile,'W');
        Prenotazione p;
        for(int i=0;i<nPrenotazioniPresenti;i++)
            {
               p=getPrenotazionePosizione(i);
                if(p!=null)
                {
                    f1.toFile(p.getCodice()+";"+p.getNome()+";"+p.getCognome()+";"+p.getData()+";"+p.getOra()+";"+p.getTempoOccupazione()+";"+p.getDocce()+";");
                }
            }
        f1.close();
    }
    
    /**
     *permette di salvare le informazioni su un file binario
     * @param nomeFile
     * @throws IOException
     * @throws FileException
     */
    public void salvaRevisioneBin(String nomeFile) throws IOException, FileException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
}
