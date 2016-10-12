import java.rmi.*;
import java.rmi.server.*;

public class InterfaceProcImpl extends UnicastRemoteObject implements InterfaceProc
{ 
	public void atribuiMensagem(String _msgm) throws RemoteException{
		try {
			System.out.println(_msgm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}