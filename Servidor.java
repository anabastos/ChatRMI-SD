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
        InterfaceServidorImpl servidor = new InterfaceServidorImpl();
		try {
			System.setSecurityManager(new RMISecurityManager());
			
			Naming.rebind("servidor", servidor);
			System.out.println("Servidor Iniciado!");

		} catch (Exception e){
			e.printStackTrace();
		}
	} 
}