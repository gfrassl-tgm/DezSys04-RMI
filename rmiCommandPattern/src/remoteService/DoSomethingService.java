package remoteService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.commands.Command;

/**
 * Interfaceklasse für das serverseitige Objekt
 * muss sowohl auf Client als auch auf Server vorhanden sein.
 * @author Gabriel
 *
 */
public interface DoSomethingService extends Remote {

	public void doSomething(Command c) throws RemoteException;
	
}
