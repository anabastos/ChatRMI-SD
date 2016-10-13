/*
Ana Luiza P Bastos
Caio Azevedo
Guilherme Lanza
*/
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.rmi.registry.*;

public class Servidor
{
	public static void main (String[] argv) throws RemoteException{
		System.setProperty("java.security.policy", "client.policy");
        InterfaceServidorImpl servidor = new InterfaceServidorImpl();
		try {
			System.setSecurityManager(new RMISecurityManager());
			Registry reg = LocateRegistry.createRegistry(2000);
		    
			reg.rebind("rmi://localhost:2000/servidor", servidor);
			System.out.println("Servidor Iniciado!");

		} catch (Exception e){
			e.printStackTrace();
		}
	} 
}