package server.commands;

import java.io.Serializable;

import calculation.Calculation;
import calculation.PICalc;
/**
 * implementiert Command und hat als Attribut eine Instanz von Calculation zu berechnung von Pi
 * @author Gabriel
 *
 */
public class CalculationCommand implements Command, Serializable {

	private static final long serialVersionUID = 3202369269194172790L;
	private PICalc calc;

	/**
	 * ruft die berechnungsmethoden von Calculation auf
	 */
	@Override
	public void execute() {
		System.out.println("CalculationCommand called!");
		calc = new PICalc();
		calc.calculate();
		calc.getResult();
	}
}
