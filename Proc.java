/*
Ana Luiza P Bastos
CaioA zevedo
Guilherme Lanza
*/
import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.security.*;

public class Proc
{
	public static void main(String arg[]){
		System.setSecurityManager(new RMISecurityManager());
		int idCliente;
		String msgDigitada;
		try {
			InterfaceProcImpl cliente = new InterfaceProcImpl();
			Naming.rebind("rmi://localhost:2000/cliente", cliente);
			
			Remote referenciaRemota = Naming.lookup("rmi://localhost:2000/servidor");
			InterfaceServidorImpl server = (InterfaceServidorImpl) referenciaRemota;
			idCliente = server.estabeleceConexao();

			BufferedReader msg = new BufferedReader (new InputStreamReader(System.in)); 

			System.out.print("Digite seu Nick! :");
			String nome = msg.readLine();
			
			msgDigitada = msg.readLine();
			while (msgDigitada.compareTo("end") != 0) {
				server.sendToAll(msgDigitada, idCliente, nome);
				msgDigitada = msg.readLine();
			}

			System.out.println(server.liberaConexao(idCliente));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}