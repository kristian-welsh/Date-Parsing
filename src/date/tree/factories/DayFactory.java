package date.tree.factories;

import date.tree.DayNode;
import date.tree.Node;

public class DayFactory extends NodeFactory {
	@Override
	public Node create(int value, Node parent) {
		return new DayNode(value, parent);
	}
}
