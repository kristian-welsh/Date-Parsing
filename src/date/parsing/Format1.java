package date.parsing;

public class Format1 extends DateFormat {
	final private static String PATTERN = "\\b" + DAY + ",? ?" + MONTH + ",? ?" + YEAR + "\\b";
	final private static int[] GROUP_LIST = {1,2,3};
	
	@Override
	protected String getRegex() {
		return PATTERN;
	}

	@Override
	public int[] getGroupOrder() {
		return GROUP_LIST;
	}
}
