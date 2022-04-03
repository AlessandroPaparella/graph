package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class HashedLabeledGraph<N, L> implements LabeledGraph<N, L> {
	private Map<N, Map<N, L>> arcs = new HashMap<N, Map<N,L>>();
	private Set<N> nodes= new HashSet<N>();

	public HashedLabeledGraph() {
		super();
	}

	public void insNode(N node) {
		if(nodes.add(node)==true)
			arcs.put(node, new HashMap<N, L>());
	}

	public Boolean contains(N node) {
		// TODO Auto-generated method stub
		return nodes.contains(node);
	}

	public Boolean isLabeled() {
		return true;
	}

	public void delNode(N node) throws GraphException {
		// TODO Auto-generated method stub

	}

	public Boolean isEmpty() {
		return nodes.isEmpty();
	}

	public Collection<N> getAdjacent(N node) throws GraphException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean containsArc(N node1, N node2) throws GraphException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isNull() {
		Boolean isNull = true;
		for(N n : arcs.keySet()) {
			if(!arcs.get(n).isEmpty()) {
				isNull = false;
				break;
			}
		}
		return isNull;
	}

	public Boolean isDirected() {
		// TODO Auto-generated method stub
		return null;
	}

	public abstract void insArc(N node1, N node2, L label);

	public abstract void removeArc(N node1, N node2) throws GraphException;

	public abstract L readArc(N node1, N node2) throws GraphException;


}
