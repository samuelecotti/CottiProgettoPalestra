/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;
import eccezioni.*;
import java.io.*;

/**
 *
 * @author cotti
 */
public class TextFile
{
    private char mode;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public TextFile(String nomeFile, char mode) throws IOException
    {
        this.mode='R';
        if(mode=='w' || mode=='W')
            this.mode='W';
        if(this.mode=='R')
            reader=new BufferedReader(new FileReader(nomeFile));
        else
            writer=new BufferedWriter(new FileWriter(nomeFile));
    }
    
    public TextFile(String nomeFile, char mode, boolean append) throws IOException
    {
        this.mode='R';
        if(mode=='w' || mode=='W')
            this.mode='W';
        if(this.mode=='R')
            reader=new BufferedReader(new FileReader(nomeFile));
        else
            writer=new BufferedWriter(new FileWriter(nomeFile,append));
    }
    
    public void toFile(String line) throws IOException, FileException
    {
        if(mode=='R')
            throw new FileException("Can't write on the file. File is only readable");
        writer.write(line);
        writer.newLine();
    }
    
    public String fromFile() throws FileException, IOException
    {
        String s;
        if(mode=='W')
            throw new FileException("Can't read on the file. File is only writable");
        s=reader.readLine();
        if(s==null)
            throw new FileException("End of file reached");
        
        return s;
    }
    
    public void close() throws IOException
    {
        if(mode=='R')
            reader.close();
        else
            writer.close();
    }
}
