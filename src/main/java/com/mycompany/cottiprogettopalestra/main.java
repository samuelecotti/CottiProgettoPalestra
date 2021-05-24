/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cottiprogettopalestra;

import eccezioni.*;
import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cotti
 */
public class main  implements Serializable
{
    public static void main(String[] args) 
    {
        String[] vociMenu=new String[7];
        int sceltaUtente=-1;
        Scanner tastiera=new Scanner(System.in);
        Prenotazione prenotazione;
        Palestra p=new Palestra();
        
        int codice,giorno,mese,anno,ora,minuto,oraOccupata,minutoOccupata;
        String docce;
        String nome;
        String cognome;
        
        String nomeFile="prenotazioni.txt";
        String nomeFileBin="prenotazioni.bin";
        
        
        vociMenu[0]="Esci dal programma.";
        vociMenu[1]="Aggiungi prenotazione.";
        vociMenu[2]="Elimina prenotazione.";
        vociMenu[3]="Visualizzare una prenotazione inserendo data e ora.";
        vociMenu[4]="Visulizzare prenotazioni di una persona in ordine cronologico.";
        vociMenu[5]="esportare in  csv";
        vociMenu[6]="salvare dati su un file binario.";
        
        try
        {
            FileInputStream f1=new FileInputStream(nomeFileBin);
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
            try
            {
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
                        try
                        {
                            System.out.println("codice-->");
                            codice=tastiera.nextInt();
                            System.out.println("Nome-->");
                            nome=tastiera.nextLine();
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
                            System.out.println("docce --> ");
                            docce=tastiera.nextLine();


                            prenotazione=new Prenotazione(codice,nome,cognome,anno,mese,giorno,ora,minuto,oraOccupata,minutoOccupata,docce);

                            p.aggiungiPrenotazione(prenotazione);

                            System.out.println(p.toString());

                            break;
                        }
                        catch(InputMismatchException e1)
                        {
                            System.out.println("il valore che è stato inserito non è corretto");
                            tastiera.nextLine();
                                
                            break;
                        }
                        
                        


                    }
                    case 2:
                    {
                        try
                        {
                            int x;
                            
                            System.out.println("inserire il codice della prenotazione da eliminare");
                            codice=tastiera.nextInt();

                            x=p.rimuoviPrenotazione(codice);

                            if(x==0)
                                System.out.println("eliminazione avvenuta correttamente");
                            else
                                System.out.println("eliminazione non avvenuta");
                            
                            System.out.println(p.toString());

                            
                            System.out.println("premi un pulsante...");
                            tastiera.nextLine();
                            break;
                        }
                        catch(InputMismatchException ex)
                        {
                            System.out.println("l'inserimento non è valido");
                            System.out.println("Premi un tasto per continuare...");
                            tastiera.nextLine();
                            break;
                        } 
                        
                    }
                    case 3:
                    {
                        try
                        {
                            Prenotazione[] prenotazioneGiorno;
                            int anno1,mese1,giorno1;
                            LocalDate data1;
                            System.out.println("Anno-->");
                            anno1=tastiera.nextInt();
                            System.out.println("Mese-->");
                            mese1=tastiera.nextInt();
                            System.out.println("Giorno-->");
                            giorno1=tastiera.nextInt();


                            data1=LocalDate.of(anno1, mese1, giorno1);

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
                        catch(DateTimeException e1)
                        {
                            System.out.println("errore nell'inserimento della data");
                            System.out.println("Premi un tasto per continuare...");
                            tastiera.nextLine();
                            break;
                        }
                        catch(InputMismatchException ex)
                        {
                            System.out.println("l'inserimento non è valido");
                            System.out.println("Premi un tasto per continuare...");
                            tastiera.nextLine();
                            break;
                        }
                    }
                    case 4:
                    {
                        try
                        {
                            Prenotazione[] elencoPrenotazioniPersonaCronologico;
                            String nome1,cognome1;

                            System.out.println("Nome-->");
                            nome1=tastiera.nextLine();

                            System.out.println("Cognome-->");
                            cognome1=tastiera.nextLine();


                            elencoPrenotazioniPersonaCronologico=p.PrenotazioniOrdineCronologico(nome1, cognome1);
                            for(int i=0;i<elencoPrenotazioniPersonaCronologico.length;i++)
                            {
                                System.out.println("Codice--> "+elencoPrenotazioniPersonaCronologico[i].getCodice()+" Nome--> "+elencoPrenotazioniPersonaCronologico[i].getNome()+" Cognome--> "+elencoPrenotazioniPersonaCronologico[i].getCognome()+" Data--> "+elencoPrenotazioniPersonaCronologico[i].getData()+" Ora--> "+elencoPrenotazioniPersonaCronologico[i].getOra()+" Tempo occupazione--> "+elencoPrenotazioniPersonaCronologico[i].getTempoOccupazione()+" Docce--> "+elencoPrenotazioniPersonaCronologico[i].getDocce());
                            }
                            System.out.println("premi un pulsante per continuare");
                            tastiera.nextLine();

                        }
                        catch(NullPointerException e1)
                        {
                            System.out.println("si è verificato un problema");
                        }
                        catch(ArrayIndexOutOfBoundsException e2)
                        {
                        System.out.println("la persona inserita non è presente");
                        break;
                        }
                        
                        
                        break;

                    }
                    case 5:
                    {


                        try 
                        {
                            p.salvaRevisione(nomeFile);
                            System.out.println("salvataggio avvenuto correttamente");
                        } 
                        catch (IOException ex) 
                        {
                            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                        catch (FileException ex) 
                        {
                            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        break;
                    }
                    case 6:
                    {
                        try 
                        {
                            p.salvaRevisioneBin(nomeFileBin);
                            System.out.println("salvataggio avvenuto correttamente");
                        } 
                        catch (IOException ex) 
                        {
                            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                        catch (FileException ex) 
                        {
                            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                    }



                }

            }
            catch(InputMismatchException | NumberFormatException e1)
            {
                tastiera.nextLine();
                System.out.println("l'input non è corretto");
            }
            
        }while(sceltaUtente!=0);
        
    }
    }

