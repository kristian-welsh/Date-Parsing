package date.parsing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.regex.Matcher;

public class DateFinder {
	final private static String[] MONTHS = {"january", "febuary", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
	
	final private ArrayList<DateFormat> formats;
	final private HashMap<String, Integer> months = new HashMap<>();;

	public DateFinder(DateFormat... formats) {
		this.formats = new ArrayList<>(Arrays.asList(formats));
		for(int i = 0; i < 12; i++)
			months.put(MONTHS[i], i + 1);
	}

	public ArrayList<Date> findDates(String input) {
		ArrayList<Date> dates = new ArrayList<>();
		formats.forEach((format) -> {
			dates.addAll(findDatesOfFormat(format, input));
		});
		return dates;
	}

	private ArrayList<Date> findDatesOfFormat(DateFormat f, String input) {
		ArrayList<Date> dates = new ArrayList<>();
		Matcher m = f.getMatcher(input);
		while(m.find())
			dates.add(createDate(m, f.getGroupOrder()));
		return dates;
	}
	
	private Date createDate(Matcher m, int[] groupOrder) {
		String dayS = m.group(groupOrder[0]);
		String monthS = m.group(groupOrder[1]);
		String yearS = m.group(groupOrder[2]);

		int day = Integer.parseInt(dayS);
		int month = parseMonth(monthS);
		int year = Integer.parseInt(yearS);

		return new Date(day, month, year);
	}

	private int parseMonth(String monthS) {
		monthS = monthS.toLowerCase();
		if(Character.isDigit(monthS.charAt(0)))
			return Integer.parseInt(monthS);
		if(months.containsKey(monthS))
			return months.get(monthS);
		System.err.println("unexpected case in DateFinder::parseMonth : " + monthS);
		return -1;
	}
}
