/*
Ana Luiza P Bastos
Caio Azevedo
Guilherme Lanza
*/
import java.rmi.*;
import java.rmi.server.*;

public class Servidor
{
	public static void main (String args[]) throws RemoteException{

		try {
			System.out.println
				("Construindo Implementacoes do Servidor...");
			System.setSecurityManager(new RMISecurityManager());
			Servidor servidor = new Servidor();
			Naming.rebind("servidor", servidor);
			System.out.println("Servidor Iniciado!");

		} catch (Exception e){
			e.printStackTrace();
		}
	} 
}