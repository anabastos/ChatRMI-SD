/*
Ana Luiza P Bastos
Caio Azevedo
Guilherme Lanza
*/
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class Servidor
{
	public static void main (String[] argv) throws RemoteException{
        Servidor servidor = new Servidor();
		try {
			System.setSecurityManager(new RMISecurityManager());
			
			Naming.rebind("servidor", new Servidor());
			System.out.println("Servidor Iniciado!");

		} catch (Exception e){
			e.printStackTrace();
		}
	} 
}