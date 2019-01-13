package date.tree.factories;

import date.tree.Node;

public abstract class NodeFactory {
	public abstract Node create(int value, Node parent);
}
