package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class HashedMultigraph<N, L> implements Multigraph<N, L> {

	private Set<N> nodes= new HashSet<N>();
	private Map<N, Map<N, Set<L>>> arcs =  new HashMap<N, Map<N, Set<L>>>();



	public void insNode(N node) {
		if(nodes.add(node)==true)
			arcs.put(node, new HashMap<N, Set<L>>());
	}



	public void delNode(N node) throws GraphException {
		if(!this.contains(node))
			throw new GraphException("Node doesn't exists!");
		nodes.remove(node);
		arcs.remove(node);
		for(N k: arcs.keySet()) {
			arcs.get(k).remove(node);
		}

	}



	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return nodes.isEmpty();
	}



	public Collection<N> getAdjacent(N node) throws GraphException {
		if(!this.contains(node)) {
			throw new GraphException("Node doesn't exist!");
		}
		return arcs.get(node).keySet();
	}



	public Boolean contains(N node) {
		return nodes.contains(node);
	}



	public Boolean containsArc(N node1, N node2) throws GraphException {
		if(!this.contains(node1) || !this.contains(node2)) {
			throw new GraphException("Node doesn't exist!");
		}
		Boolean exists = false;
		Map<N, Set<L>> adjacents=arcs.get(node1);
		if(adjacents.containsKey(node2))
			exists = true;
		return exists;
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



	public abstract Boolean isDirected();



	public Boolean isLabeled() {
		return true;
	}



	public Boolean isMulti() {
		return true;
	}


	public HashedMultigraph() {
		super();
	}


	public abstract void insArc(N node1, N node2, L label);


	public Collection<L> getArcs(N node1, N node2) throws GraphException {
		return arcs.get(node1).get(node2);
	}


	public abstract void removeArc(N node1, N node2, L label) throws GraphException;


}
