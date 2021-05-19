/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cottiprogettopalestra;

import java.util.Scanner;

/**
 *
 * @author cotti
 */
public class main 
{
    public static void main(String[] args) 
    {
        String[] vociMenu=new String[4];
        int sceltaUtente=-1;
        Scanner tastiera=new Scanner(System.in);
        Prenotazione prenotazione;
        Palestra b=new Palestra();
        
        vociMenu[0]="Esci dal programma.";
        vociMenu[1]="Aggiungi prenotazione.";
        vociMenu[2]="Elimina prenotazione.";
        vociMenu[3]="Verifica se la palestra è libera inserendo una data e un'ora.";
        
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
                    Prenotazione p1=new Prenotazione(12334,"Samuele","Cotti",2021,5,21,16,50,2,0,true);
                    Prenotazione p2=new Prenotazione(13333334,"Samuele","Cotti",2021,5,21,16,50,2,0,true);
                    
                    b.aggiungiPrenotazione(p1);
                    b.aggiungiPrenotazione(p2);
                    
                    System.out.println(b.toString());
                    
                    System.out.println("premi un pulsante...");
                    tastiera.nextLine();
                    break;
                }
                case 2:
                {
                    b.rimuoviPrenotazione(12334);
        
                    

                    System.out.println(b.toString());
                    
                    System.out.println("premi un pulsante...");
                    tastiera.nextLine();
                    break;
                }
                case 3:
                {
                    
                    
                    System.out.println("premi un pulsante...");
                    tastiera.nextLine();
                }
            }
            
        }while(sceltaUtente!=0);

        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
