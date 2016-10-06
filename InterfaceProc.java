/*
Ana Luiza P Bastos
Caio Azevedo
Guilherme Lanza
*/
import java.rmi.*;
import java.rmi.server.*;

public interface InterfaceProc  {
	public void atribuiMensagem(String _msgm) throws RemoteException {
	System.out.println(_msgm);
	}
}
