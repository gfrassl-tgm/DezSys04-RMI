package server.commands;

import java.io.Serializable;
/**
 * Interface für die Commands mit denen der Client die Remoteobjekte startet
 * Dieses Interface muss sowohl auf Client als auch am Server vorhanden sein
 * @author Gabriel
 *
 */
public interface Command extends Serializable {

	public void execute();
}
