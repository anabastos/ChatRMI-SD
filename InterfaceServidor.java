/*
Ana Luiza P Bastos
Caio Azevedo
Guilherme Lanza
*/
import java.rmi.*;
import java.rmi.server.*;

public interface InterfaceServidor  {

	public int estabeleceConexao() throws RemoteException{
		idCliente ++;

		try {
			clientesConectados[idCliente] = (InterfaceProc) Naming.lookup("cliente");

		} catch (Exception e) {
			System.out.println (e.toString());
		}

		return idCliente;
	}

	public String liberaConexao(int _idCliente) throws RemoteException {

		for (int i = 0; i < clientesConectados.length; i++){
			if (i == _idCliente) {
				clientesConectados[idCliente] = null;
			}
		}
		idCliente --;

		return "*~Conexao OK!~*";
	}

	public void sendToAll(String _msgm, int _idCliente, String _nome) throws RemoteException{
		for (int i = 0; i < clientesConectados.length; i++){
			if ((clientesConectados[i] != null) && (i != _idCliente)) {
				clientesConectados[i].atribuiMensagem("> " + _nome + ":" + _msgm);
			}
		}
	}

}
