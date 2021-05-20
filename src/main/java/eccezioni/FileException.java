/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

/**
 *
 * @author cotti
 */
public class FileException extends Exception 
{
    private String message;
    
    public FileException(String m) 
    {
        message=m;
    }
    
    public String toString()
    {
        return message;
    }
    
}
