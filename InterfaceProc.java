/*
Ana Luiza P Bastos
Caio Azevedo
Guilherme Lanza
*/
import java.rmi.*;
import java.rmi.server.*;

public interface InterfaceProc extends Remote {
	void atribuiMensagem(String _msgm) throws RemoteException;
}
