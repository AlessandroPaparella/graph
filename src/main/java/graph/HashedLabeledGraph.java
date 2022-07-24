package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An abstract class implemented with hashmap for edge labeled graph
 * @author Alessandro Paparella
 *
 * @param <N> this is the generic type of object that will represent the nodes without duplicated values
 * @param <L> this is the generic type of object that will represent the labels on edges
 */
public abstract class HashedLabeledGraph<N, L> implements LabeledGraph<N, L> {
	private Map<N, Map<N, L>> arcs = new HashMap<N, Map<N,L>>();
	private Set<N> nodes= new HashSet<N>();

	public HashedLabeledGraph() {
		super();
	}

	@Override
	public void insNode(N node) {
		if(nodes.add(node)==true)
			arcs.put(node, new HashMap<N, L>());
	}

	@Override
	public Boolean contains(N node) {
		// TODO Auto-generated method stub
		return nodes.contains(node);
	}

	@Override
	public Boolean isLabeled() {
		return true;
	}

	@Override
	public void delNode(N node) throws GraphException {
		if(!this.contains(node))
			throw new GraphException("Node doesn't exists!");
		nodes.remove(node);
		arcs.remove(node);
		for(N k: arcs.keySet()) {
			arcs.get(k).remove(node);
		}
	}

	@Override
	public Boolean isEmpty() {
		return nodes.isEmpty();
	}

	@Override
	public Collection<N> getAdjacent(N node) throws GraphException {
		if(!this.contains(node)) {
			throw new GraphException("Node doesn't exist!");
		}
		return arcs.get(node).keySet();
	}

	@Override
	public Boolean containsArc(N node1, N node2) throws GraphException {
		if(!this.contains(node1) || !this.contains(node2)) {
			throw new GraphException("Node doesn't exist!");
		}
		Boolean exists = false;
		Set<N> adjacents=arcs.get(node1).keySet();
		if(adjacents.contains(node2))
			exists = true;
		return exists;
	}

	@Override
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

	@Override
	public abstract void insArc(N node1, N node2, L label);

	@Override
	public abstract void removeArc(N node1, N node2) throws GraphException;

	@Override
	public abstract L readArc(N node1, N node2) throws GraphException;

	protected Map<N,L> getArcs(N node){
		return arcs.get(node);
	}

	@Override
	public Boolean isMulti() {
		return false;
	}




}
