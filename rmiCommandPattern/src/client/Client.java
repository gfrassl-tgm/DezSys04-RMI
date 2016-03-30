package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import remoteService.DoSomethingService;
import server.commands.CalculationCommand;
import server.commands.Command;
import server.commands.RegisterCommand;
import server.commands.LoginCommand;


/**
 * Clientklasse die auf ein Remoteobjekt zugreifft und mehrere Commands mit diesem remoteobjekt ausführt.
 * @author Gabriel
 *
 */
public class Client {

	/**
	 * anfragen der Registry, erstellen einer "Verbindung" zum Remote Objekt und ausführen verschiedener Commands
	 * @param args cli argumente - anzahl der Stellen von Pi
	 */
	public static void main(String[] args) {
		 //if(System.getSecurityManager() == null) {
			//System.setSecurityManager(new SecurityManager());
		 //}
		try {
			Registry registry = LocateRegistry.getRegistry(1233);

			DoSomethingService uRemoteObject = (DoSomethingService) registry.lookup("Service");
			System.out.println("Service found");

			Command rc = new RegisterCommand();
			Command lc = new LoginCommand();
			Command cc = new CalculationCommand();
			uRemoteObject.doSomething(rc);
			uRemoteObject.doSomething(lc);
			uRemoteObject.doSomething(cc);

		} catch (RemoteException re) {
			System.err.println("Service not found?" + " Check your RMI-Registry!");
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
