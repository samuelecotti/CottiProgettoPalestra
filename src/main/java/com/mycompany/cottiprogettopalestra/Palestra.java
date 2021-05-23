/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cottiprogettopalestra;

import eccezioni.FileException;
import file.TextFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author STUDENTE
 */
public class Palestra 
{
    private Prenotazione[] elencoPrenotazioni;
    private final int N_MAX_PRENOTAZIONI=100;
    private int nPrenotazioniPresenti;

    public Palestra()
    {
        elencoPrenotazioni=new Prenotazione[N_MAX_PRENOTAZIONI];
    }
    
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

    public int getN_MAX_PRENOTAZIONI() 
    {
        return N_MAX_PRENOTAZIONI;
    }

    public int getnPrenotazioniPresenti() 
    {
        return nPrenotazioniPresenti;
    }
    
    public Prenotazione getPrenotazionePosizione(int posizione)
    {
        return elencoPrenotazioni[posizione];
    }
    
    public int getCodice(int posizione)
    {
         return elencoPrenotazioni[posizione].getCodice();  
    }
    
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
    
    
    public Prenotazione[] prenotazioniGiorno(LocalDateTime data)
    {
        Prenotazione[] prenotazioniGiorno=new Prenotazione[getNumPrenotazioni()];
        Prenotazione p;
        int x=0;
        int c=0;
        
        for(int i=0;i<getNumPrenotazioni();i++)
        {
            if(elencoPrenotazioni[i].getDataOra().isEqual(data)==true)
            {
                p=elencoPrenotazioni[i];
                prenotazioniGiorno[x]=p;
                x++;
            }
            else if(elencoPrenotazioni[i].getDataOra().isEqual(data)==false)
            {
                c++; 
            }
        }
        
        return prenotazioniGiorno;
          
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
    
    
    public void salvaRevisione(String nomeFile) throws IOException, FileException
    {
        TextFile f1=new TextFile(nomeFile,'W');
        Prenotazione p;
        for(int i=0;i<nPrenotazioniPresenti;i++)
            {
               p=getPrenotazionePosizione(i);
                if(p!=null)
                {
                    f1.toFile(p.getCodice()+";"+p.getNome()+";"+p.getCognome()+";"+p.getDataOra()+";"+p.getTempoOccupazione()+";"+p.getDocce()+";");
                }
            }
        f1.close();
    }
    
    public void salvaRevisioneBin(String nomeFile) throws IOException, FileException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
}
