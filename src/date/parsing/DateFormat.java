package date.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class DateFormat {
	final protected static String YEAR = "(\\d{4})";
	final protected static String MONTH = "(?i)(January|Febuary|March|April|May|June|July|August|September|October|November|December|\\d{2})(?-i)";
	final protected static String DAY = "(\\d{1,2})";
	
	// returns the java regex matcher that finds dates of this format
	public Matcher getMatcher(String input) {
		Pattern pattern = Pattern.compile(getRegex(), 0);
		return pattern.matcher(input);
	}
	
	protected abstract String getRegex();
	
	// returns a list of sub-group indices in the order day month year
	public abstract int[] getGroupOrder();
}
