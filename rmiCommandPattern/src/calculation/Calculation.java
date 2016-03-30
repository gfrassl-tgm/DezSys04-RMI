package calculation;

import java.math.BigDecimal;

/**
 * Interface welches Methoden zur Berechnung und zum erhalten eines Ergebnisses zurückgibt
 * @author Gabriel
 *
 */
public interface Calculation {

	public void calculate();
	public BigDecimal getResult();
}
