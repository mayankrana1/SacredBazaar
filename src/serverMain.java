
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mayank
 */
public class serverMain
{
    
    static Vector<ClientHandler> ar = new Vector<>(); 

    static int activeClients = 0; 
  
    public serverMain() throws IOException  
    {
        ServerSocket ss = new ServerSocket(3001); 
          
        Socket s; 
        while (true)  
        { 
            s = ss.accept(); 
  
            System.out.println("New client request received : " + s); 
             
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
              
            System.out.println("Creating a new handler for this client..."); 
  
            ClientHandler mtch = new ClientHandler(s,"client " + activeClients, dis, dos);  
            Thread t = new Thread(mtch); 
             new ClientHandler(s,"client " + activeClients, dis, dos).start(); 
            System.out.println("Adding this client to active client list"); 
           // ar.add(mtch); 
            //t.start(); 
            
            activeClients++; 
  
        } 
    } 
    
    public static void main(String[] args) throws IOException
    {
        serverMain obj=new serverMain();
    }
    
}
