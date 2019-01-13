package date.tree.factories;

import date.tree.Node;
import date.tree.YearNode;

public class YearFactory extends NodeFactory {
	@Override
	public Node create(int value, Node parent) {
		return new YearNode(value, parent);
	}
}
