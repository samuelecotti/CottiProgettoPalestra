/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cottiprogettopalestra;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneNonVuota;
import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cotti
 */
public class main 
{
    public static void main(String[] args) 
    {
        String[] vociMenu=new String[10];
        int sceltaUtente=-1;
        Scanner tastiera=new Scanner(System.in);
        Prenotazione prenotazione;
        Palestra p=new Palestra();
        
        int codice,giorno,mese,anno,ora,minuto,oraOccupata,minutoOccupata;
        boolean docce;
        String nome;
        String cognome;
        
        String nomeFile="prenotazioni.txt";
        String nomeFileBin="prenotazioni.bin";
        
        
        vociMenu[0]="Esci dal programma.";
        vociMenu[1]="Aggiungi prenotazione.";
        vociMenu[2]="Elimina prenotazione.";
        vociMenu[3]="Visualizzare una prenotazione inserendo data e ora.";
        vociMenu[4]="esportare in  csv";
        
        try
        {
            FileInputStream f1=new FileInputStream(nomeFile);
            ObjectInputStream reader=new ObjectInputStream(f1);
            try
            {
                p=(Palestra)reader.readObject();
                reader.close();
                System.out.println("\nLettura da file avvevuta correttamente");
                        
            }
            catch(ClassNotFoundException ex)
            {
                reader.close();
                System.out.println("\nErrore nella lettura");
            }
        }
        catch(IOException ex)
        {
            System.out.println("\nImpossibile accedere al file");
        }
        
        Menu menu=new Menu(vociMenu);
        
        do{
            
            sceltaUtente=menu.sceltaMenu();
            switch(sceltaUtente)
            {
                case 0:
                {
                    System.out.println("L'applicazione verrà terminata.");
                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                case 1:
                {
                                System.out.println("codice-->");
                                codice=tastiera.nextInt();
                                System.out.println("Nome-->");
                                nome=tastiera.nextLine();
                                System.out.println("Cognome-->");
                                cognome=tastiera.nextLine();
                                System.out.println("Data: ");
                                System.out.println("Giorno --> ");
                                giorno=tastiera.nextInt();
                                System.out.println("Mese --> ");
                                mese=tastiera.nextInt();
                                System.out.println("Anno --> ");
                                anno=tastiera.nextInt();
                                System.out.println("ora-->");
                                ora=tastiera.nextInt();
                                System.out.println("minuto-->");
                                minuto=tastiera.nextInt();
                                System.out.println("ora occupazione-->");
                                oraOccupata=tastiera.nextInt();
                                System.out.println("minuti occupazione-->");
                                minutoOccupata=tastiera.nextInt();
                                //data=LocalDate.of(anno, mese, giorno);
                                System.out.println("docce --> ");
                                docce=tastiera.nextBoolean();
                                
                                
                                prenotazione=new Prenotazione(codice,nome,cognome,anno,mese,giorno,ora,minuto,oraOccupata,minutoOccupata,docce);
                                
                                p.aggiungiPrenotazione(prenotazione);
                                
                                System.out.println(p.toString());

                                break;
                    
                    
                }
                case 2:
                {
                    System.out.println("inserire il codice della prenotazione da eliminare");
                    codice=tastiera.nextInt();
                    
                    p.rimuoviPrenotazione(codice);
        
                    

                    System.out.println(p.toString());
                    
                    System.out.println("premi un pulsante...");
                    tastiera.nextLine();
                    break;
                }
                case 3:
                {
                    Prenotazione[] prenotazioneGiorno;
                                int anno1,mese1,giorno1,ora1,minuto1;
                                LocalDateTime data1;
                                System.out.println("Anno-->");
                                anno1=tastiera.nextInt();
                                System.out.println("Mese-->");
                                mese1=tastiera.nextInt();
                                System.out.println("Giorno-->");
                                giorno1=tastiera.nextInt();
                                System.out.println("ora-->");
                                ora1=tastiera.nextInt();
                                System.out.println("minuto-->");
                                minuto1=tastiera.nextInt();
                                
                                data1=LocalDateTime.of(anno1, mese1, giorno1, ora1, minuto1);

                                prenotazioneGiorno=p.prenotazioniGiorno(data1);
                                
                                if(prenotazioneGiorno==null)
                                        System.out.println("nessuna revisione per il giorno "+data1);
                                else
                                  {
                                       for(int i=0;i<prenotazioneGiorno.length;i++)
                                           if(prenotazioneGiorno[i]!=null)
                                              System.out.println(prenotazioneGiorno[i]);

                                  }

                                
                    
                    System.out.println("premi un pulsante...");
                    tastiera.nextLine();
                    
                    break;
                }
                case 4:
                {
                    
                                
                try 
                {
                    p.salvaRevisione(nomeFile);
                } 
                catch (IOException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (FileException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("salvataggio avvenuto correttamente");
                                
                                


                            break;
                }
            }
            
        }while(sceltaUtente!=0);

        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
