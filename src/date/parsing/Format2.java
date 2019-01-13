package date.parsing;

public class Format2 extends DateFormat {
	final private static String PATTERN = "\\b" + MONTH + ",? ?" + DAY + ",? ?" + YEAR + "\\b";
	final private static int[] GROUP_LIST = {2,1,3};
	
	@Override
	protected String getRegex() {
		return PATTERN;
	}

	@Override
	public int[] getGroupOrder() {
		return GROUP_LIST;
	}
}
