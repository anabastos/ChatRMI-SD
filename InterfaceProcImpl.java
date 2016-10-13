import java.rmi.*;
import java.rmi.server.*;

public class InterfaceProcImpl extends UnicastRemoteObject implements InterfaceProc
{ 
	public InterfaceProcImpl() throws RemoteException {
	    super();
	}
	public void atribuiMensagem(String _msgm) throws RemoteException{
		try {
			System.out.println(_msgm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}