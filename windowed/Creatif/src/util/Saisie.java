package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Saisie
{
    
    public static String lireChaine(String invite)
    {
        String chaineLue = null;
        System.out.print(invite);
        try
	{
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            chaineLue = br.readLine();
        }
	catch (IOException exception)
	{
            exception.printStackTrace();
        }
        
        return chaineLue;
    }
    
}
