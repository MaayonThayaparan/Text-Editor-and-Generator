/**
 * 
 */
package spelling;

import java.util.List;

/**
 * @author Maayon Thayaparan
 *
 */
public interface AutoComplete {
	public List<String> predictCompletions(String prefix, int numCompletions);
}
