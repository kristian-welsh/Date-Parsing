package date.parsing;

import date.tree.DayNode;
import date.tree.Node;
import java.util.ArrayList;
import java.util.Iterator;

public class DateParser {
	public String parse(String input) {
		final ArrayList<Date> dates = findDates(input);
		sort(dates);
		final Node tree = createDateTree(dates);
		System.out.println(tree.toString());
		return tree.toString();
	}
	
	private ArrayList<Date> findDates(String input) {
		DateFinder finder = new DateFinder(new Format1(), new Format2(), new Format3());
		return finder.findDates(input);
	}
	
	private void sort(ArrayList<Date> dates) {
		dates.sort((d1,d2) -> d1.sortString().compareTo(d2.sortString()));
	}
	
	private Node createDateTree(ArrayList<Date> dates) {
		final Node tree = new Node(0, null);
		Iterator<Date> itt = dates.iterator();
		itt.forEachRemaining( (date) -> addDate(tree, date) );
		return tree;
	}
	
	private void addDate(Node tree, Date date) {
		Node year = tree.findOrAddNode(date.year);
		Node month = year.findOrAddNode(date.month);
		DayNode day = (DayNode)month.findOrAddNode(date.day);
		Node quantity = day.findOrAddNode();
		quantity.increment();
	}
}
