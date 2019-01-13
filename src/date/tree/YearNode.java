package date.tree;

import date.tree.factories.MonthFactory;
import date.tree.factories.NodeFactory;

public class YearNode extends Node {
	private static MonthFactory FACTORY = new MonthFactory();
	
	public YearNode(int value, Node parent) {
		super(value, parent);
	}
	
	@Override
	protected String valueString() {
		return value + ":\n";
	}
	
	@Override
	protected NodeFactory getChildFactory() {
		return FACTORY;
	}
}
