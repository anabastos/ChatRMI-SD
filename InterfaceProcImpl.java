import java.rmi.*;
import java.rmi.server.*;

public class InterfaceProcImpl extends UnicastRemoteObject implements InterfaceProc
{ 
	public void atribuiMensagem(String _msgm) throws RemoteException{
		System.out.println(_msgm);
	}
}