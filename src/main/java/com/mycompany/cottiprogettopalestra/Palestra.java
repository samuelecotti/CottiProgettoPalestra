/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cottiprogettopalestra;

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
    
    public int aggiungiPrenotazione(Prenotazione prenotazione)
    {
        if (nPrenotazioniPresenti>N_MAX_PRENOTAZIONI)
            return -1;      //LA CLASSE HA RAGGIUNTO IL NUMERO MASSIMO DI 
        elencoPrenotazioni[nPrenotazioniPresenti]=new Prenotazione(prenotazione.getCodice(),prenotazione.getCognome(),prenotazione.getNome(),prenotazione.getAnno(),prenotazione.getMese(),prenotazione.getGiorno(),prenotazione.getOra(),prenotazione.getMinuto(),prenotazione.getOraOccupazione(),prenotazione.getMinutoOccupazione(),prenotazione.getDocce());
        nPrenotazioniPresenti++;
        return 0;
    }
    
    private void aggiornaPosizioniStudenti(int posizione)
    {
        for (int i=posizione;i<nPrenotazioniPresenti-1;i++)
        {
            elencoPrenotazioni[i]=elencoPrenotazioni[i+1];
        }
        elencoPrenotazioni[nPrenotazioniPresenti-1]=null;      //Affinchè se elimino l'ultimo studente, in ultima posizione vi sia null
        nPrenotazioniPresenti--;        
    }
    
    public int rimuoviStudente(long matricola)
    {
        int posizioneStudente;
        for (int i=0;i<nPrenotazioniPresenti;i++)   //cerco lo studente
        {
            if (elencoPrenotazioni[i]!=null)
            {
                if (elencoPrenotazioni[i].getCodice()==matricola)
                {
                    posizioneStudente=i;
                    aggiornaPosizioniStudenti(i);
                    return 0;
                }
                    
            }
        }
        return -1;
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
}
