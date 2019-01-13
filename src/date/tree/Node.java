package date.tree;

import date.tree.factories.NodeFactory;
import date.tree.factories.YearFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//todo: need year month and day nodes with their own toString functionality
public class Node {
	final private static NodeFactory FACTORY = new YearFactory();
	
	protected int value;
	final protected List<Node> children = new ArrayList<>();
	
	public Node(Integer value, Node parent) {
		this.value = value;
		if(parent != null)
			parent.addChild(this);
	}
	
	public void addChild(Node node) {
		children.add(node);
	}
	
	public void increment() {
		value++;
	}
	
	public int getValue() {
		return value;
	}
	
	// create node if needed
	public Node findOrAddNode(int value) {
		Node child = getChild(value);
		if(child == null)
			child = getChildFactory().create(value, this);
		return child;
	}
	
	protected Node getChild(int value) {
		Predicate<Node> matchesValue = (node) -> node.getValue() == value;
		Optional<Node> maybeChild = children.stream().filter(matchesValue).findFirst();
		return maybeChild.orElse(null);
	}
	
	public String toString() {
		StringBuilder sb  = new StringBuilder();
		sb.append(valueString());
		children.iterator().forEachRemaining(sb::append);
		return sb.toString();
	}
	
	protected String valueString() {
		return "";
	}
	
	protected NodeFactory getChildFactory() {
		return FACTORY;
	}
}
