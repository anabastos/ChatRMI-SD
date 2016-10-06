/*
Ana Luiza P Bastos
Caio Azevedo
Guilherme Lanza
*/
import java.rmi.*;
import java.rmi.server.*;

public class Proc
{
	public static void main(String args[]) throws RemoteException{
		int num1, num2, idCliente;
		char oper;
		double resultado;
		String msgDigitada;

		try {
			System.setSecurityManager(new RMISecurityManager());
			Proc cliente = new Proc();
			Naming.rebind("cliente", cliente);

			remote referenciaRemota = Naming.lookup("servidor");
			InterfaceServidor a = (InterfaceServidor) referenciaRemota;

			idCliente = a.estabeleConexao();
			System.out.println("Id Cliente:" + idCliente);

			BufferedReader teclado = new BufferedReader (new InputStreamReader(System.in)); 

			System.out.print("Digite seu Nick! :");
			String nome = teclado.readLine();
			msgDigitada = teclado.readLine();
			while (msgDigitada.compareTo("end") != 0) {
				a.sendToAll(msgDigitada, idCliente, nome);
				msgDigitada = teclado.readLine();
			}

			System.out.println(a.liberaConexao(idCliente));
			System.exit(1);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
}