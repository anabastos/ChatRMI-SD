/*
Ana Luiza P Bastos
CaioA zevedo
Guilherme Lanza
*/
import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
//import java.util.*;

public class Proc
{
	public static void main(String[] argv) throws RemoteException{

		int idCliente;
		String msgDigitada;
		Proc cliente = new Proc();
		try {
			
			Naming.rebind("cliente", cliente);
			System.setSecurityManager(new RMISecurityManager());
			InterfaceServidor a = (InterfaceServidor) Naming.lookup("servidor");
			System.out.println(a);
			idCliente = a.estabeleConexao();
			System.out.println("Id Cliente:" + idCliente);

			BufferedReader msg = new BufferedReader (new InputStreamReader(System.in)); 

			System.out.print("Digite seu Nick! :");
			String nome = msg.readLine();
			msgDigitada = msg.readLine();
			while (msgDigitada.compareTo("end") != 0) {
				a.sendToAll(msgDigitada, idCliente, nome);
				msgDigitada = msg.readLine();
			}

			System.out.println(a.liberaConexao(idCliente));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}