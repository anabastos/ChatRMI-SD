import java.rmi.*;
import java.rmi.server.*;

public class InterfaceServidorImpl extends UnicastRemoteObject implements InterfaceServidor
{ 
	public int idCliente = 0;
	private InterfaceProc[] clientes = new InterfaceProc[idCliente];

	public InterfaceServidorImpl() throws RemoteException {}
	
	public int estabeleceConexao() throws RemoteException{
		try {
			idCliente =+ 1;
			clientes[idCliente] = (InterfaceProc) Naming.lookup("cliente");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return idCliente;
	}

	public String liberaConexao(int _idCliente) throws RemoteException {
		//exclui cliente inativo
		for (int i = 0; i < clientes.length; i++){
			if (i == _idCliente) {
				clientes[idCliente] = null;
			}
		}
		idCliente -= 1;
		
		return "OK";
	}

	public void sendToAll(String _msgm, int _idCliente, String _nome) throws RemoteException {
		for (int i = 0; i < clientes.length; i++){
			if ((i != _idCliente) && (clientes[i] != null) ) {
				clientes[i].atribuiMensagem(_nome + " : " + _msgm);
			}
		}
	}
}