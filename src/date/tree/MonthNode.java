package date.tree;

import date.tree.factories.DayFactory;
import date.tree.factories.NodeFactory;

public class MonthNode extends Node {
	private static DayFactory FACTORY = new DayFactory();
	
	public MonthNode(int value, Node parent) {
		super(value, parent);
	}
	
	//example: -08\n
	@Override
	protected String valueString() {
		String string = "";
		string += "-";
		if(value < 10)
			string += "0";
		string += value;
		string += "\n";
		return string;
	}
	
	@Override
	protected NodeFactory getChildFactory() {
		return FACTORY;
	}
}
