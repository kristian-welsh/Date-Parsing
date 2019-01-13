package date.parsing;

public class Format3 extends DateFormat {
	final private static String PATTERN = "\\b" + YEAR + "-?" + MONTH + "-?" + DAY + "\\b";
	final private static int[] GROUP_LIST = {3,2,1};
	
	@Override
	protected String getRegex() {
		return PATTERN;
	}

	@Override
	public int[] getGroupOrder() {
		return GROUP_LIST;
	}
}