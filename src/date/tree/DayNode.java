package date.tree;

import date.tree.factories.NodeFactory;
import date.tree.factories.QuantityFactory;

public class DayNode extends Node {
	private static NodeFactory FACTORY = new QuantityFactory();
	
	public DayNode(int value, Node parent) {
		super(value, parent);
	}
	
	//example: -08
	@Override
	protected String valueString() {
		String string = "";
		string += "-";
		if(value < 10)
			string += "0";
		string += value;
		return string;
	}
	
	//violates liskov substitution principle, but is neater than the alternative
	@Override
	protected Node getChild(int value) {
		return getQuantityChild();
	}

	private Node getQuantityChild() {
		if(children.isEmpty())
			return null;
		return children.get(0);
	}
	
	@Override
	protected NodeFactory getChildFactory() {
		return FACTORY;
	}
	
	public Node findOrAddNode() {
		return super.findOrAddNode(0);
	}
}
