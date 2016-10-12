import java.rmi.*;
import java.rmi.server.*;

public class InterfaceServidorImpl extends UnicastRemoteObject implements InterfaceServidor
{ 
	public int idCliente = 0;
	InterfaceProc[] clientes = new InterfaceProc[idCliente];

	public int estabeleceConexao() throws RemoteException{
		try {
			idCliente ++;
			clientes[idCliente] = (InterfaceProc) Naming.lookup("cliente");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return idCliente;
	}

	public String liberaConexao(int _idCliente) {
		//exclui cliente inativo
		for (int i = 0; i < clientes.length; i++){
			if (i == _idCliente) {
				clientes[idCliente] = null;
			}
		}
		idCliente --;
		
		return "*~Conexao OK!~*";
	}

	public void sendToAll(String _msgm, int _idCliente, String _nome) {
		for (int i = 0; i < clientes.length; i++){
			if ((clientes[i] != null) && (i != _idCliente)) {
				clientes[i].atribuiMensagem(_nome + ":" + _msgm);
			}
		}
	}
}