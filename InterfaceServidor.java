/*
Ana Luiza P Bastos
Caio Azevedo
Guilherme Lanza
*/
import java.rmi.*;
import java.rmi.server.*;

public interface InterfaceServidor extends Remote {
	
	public int estabeleceConexao() throws RemoteException;
	public String liberaConexao(int _idCliente) throws RemoteException;
	public void sendToAll(String _msgm, int _idCliente, String _nome) throws RemoteException;

}
