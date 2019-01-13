package date.tree.factories;

import date.tree.Node;
import date.tree.QuantityNode;

public class QuantityFactory extends NodeFactory {
	@Override
	public Node create(int value, Node parent) {
		return new QuantityNode(value, parent);
	}
}
