package calculation;

import java.math.BigDecimal;

/**
 * Interface welches Methoden zur Berechnung und zum erhalten eines Ergebnisses zur�ckgibt
 * @author Gabriel
 *
 */
public interface Calculation {

	public void calculate();
	public BigDecimal getResult();
}
