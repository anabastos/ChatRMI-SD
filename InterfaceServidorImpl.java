import java.rmi.*;
import java.rmi.server.*;

public class InterfaceServidorImpl extends UnicastRemoteObject implements InterfaceServidor
{ 
	public int estabeleceConexao() throws RemoteException{
		idCliente ++;

		try {
			clientesConectados[idCliente] = (InterfaceProc) Naming.lookup("cliente");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return idCliente;
	}

	public String liberaConexao(int _idCliente) {

		for (int i = 0; i < clientesConectados.length; i++){
			if (i == _idCliente) {
				clientesConectados[idCliente] = null;
			}
		}
		idCliente --;
		//exclui cliente inativo
		return "*~Conexao OK!~*";
	}

	public void sendToAll(String _msgm, int _idCliente, String _nome) {
		for (int i = 0; i < clientesConectados.length; i++){
			if ((clientesConectados[i] != null) && (i != _idCliente)) {
				clientesConectados[i].atribuiMensagem(_nome + ":" + _msgm);
			}
		}
	}
}