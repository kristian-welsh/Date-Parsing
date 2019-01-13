package date.tree;

public class QuantityNode extends Node {
	
	public QuantityNode(int value, Node parent) {
		super(value, parent);
	}
	
	@Override
	protected String valueString() {
		return " (" + value + ")\n";
	}
}
