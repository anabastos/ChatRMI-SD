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
			System.setSecurityManager(new RMISecurityManager());
			System.out.println("Construindo Implementacoes do Servidor...");
			Servidor servidor = new Servidor();
			System.out.println("Registrando as Implementacoes do Servidor...");
			Naming.rebind("servidor", servidor);
			System.out.println("Servidor Iniciado!");

		} catch (Exception e){
			System.out.println(e);
		}
	} 
}