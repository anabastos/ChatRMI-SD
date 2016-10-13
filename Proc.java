/*
Ana Luiza P Bastos
CaioA zevedo
Guilherme Lanza
*/
import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.security.*;
//import java.util.*;

public class Proc
{
	public static void main(String arg[]){
		System.setProperty("java.security.policy", "client.policy");
		System.setSecurityManager(new RMISecurityManager());
		int idCliente;
		String msgDigitada;
		try {
			InterfaceProcImpl cliente = new InterfaceProcImpl();
			Naming.rebind("cliente", cliente);
			
			Remote referenciaRemota = Naming.lookup("servidor");
			InterfaceServidorImpl a = (InterfaceServidorImpl) referenciaRemota;
			idCliente = a.estabeleceConexao();
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