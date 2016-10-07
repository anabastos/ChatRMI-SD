/*
Ana Luiza P Bastos
Caio Azevedo
Guilherme Lanza
*/
import java.rmi.*;
import java.rmi.server.*;

public interface InterfaceServidor extends Remote {

	int estabeleceConexao() throws RemoteException;

	String liberaConexao(int _idCliente);

	void sendToAll(String _msgm, int _idCliente, String _nome);

}
