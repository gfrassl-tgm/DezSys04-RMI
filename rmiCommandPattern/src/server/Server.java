package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import remoteService.DoSomethingService;
/**Klasse die ein Objekt von ServerService remote solange zur Verfügung stellt bis dis manuell abgebrochen wird
 * 
 * 
 */
public class Server {

	/**
	 * erstellt registry und stellt darin den Stub zur verfügung 
	 * @param args CLI- Arguments - no impact
	 */
	public static void main(String[] args) {

		//if (System.getSecurityManager() == null) {
			//System.setSecurityManager(new SecurityManager());
		//}
		try {
			ServerService uRemoteObject = new ServerService();
			DoSomethingService stub = (DoSomethingService) UnicastRemoteObject.exportObject(uRemoteObject, 0);
			Registry registry = LocateRegistry.createRegistry(1233);
			registry.rebind("Service", stub);
			System.out.println("Service bound! Press Enter to terminate ...");

			while ( System.in.read() != '\n' );
			UnicastRemoteObject.unexportObject(uRemoteObject, true);

			System.out.println("Service unbound, System goes down ...");

		} catch (RemoteException re) {
			System.err.println("Service already bound?" + " Check your RMI-Registry settings!");
			re.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}

	}

}
