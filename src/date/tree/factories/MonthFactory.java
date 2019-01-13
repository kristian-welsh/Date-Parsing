package date.tree.factories;

import date.tree.MonthNode;
import date.tree.Node;

public class MonthFactory extends NodeFactory {
	@Override
	public Node create(int value, Node parent) {
		return new MonthNode(value, parent);
	}
}
