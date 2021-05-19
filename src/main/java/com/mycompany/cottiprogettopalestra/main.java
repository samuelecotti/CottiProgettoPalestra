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
        
        Scanner tastiera=new Scanner(System.in);
        Prenotazione prenotazione;
        
        
        Prenotazione p1=new Prenotazione(12334,"Samuele","Cotti",2021,5,21,16,50,2,0,true);
        Prenotazione p2=new Prenotazione(13333334,"Samuele","Cotti",2021,5,21,16,50,2,0,true);
        
        Palestra b=new Palestra();
        
        b.aggiungiPrenotazione(p1);
        b.aggiungiPrenotazione(p2);
        
        System.out.println(b.toString());
        
        b.rimuoviStudente(12334);
        
        tastiera.nextLine();
        
        System.out.println(b.toString());
        
        
    }
}
