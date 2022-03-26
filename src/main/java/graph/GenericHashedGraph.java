package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author AlessandroPaparella
 *
 * @param <N> this is the generic type of object that will represent the nodes (there mustn't be duplicated values) i.e. Character, Integer... and must implement an hashing method
 */
public abstract class GenericHashedGraph<N> implements GenericGraph<N> {

	private Set<N> nodes= new HashSet<N>();
	private Map<N, Set<N>> arcs = new HashMap<N, Set<N>>();

	public GenericHashedGraph() {
		super();
	}

	public void insNode(N node) {
		if(nodes.add(node)==true)
			arcs.put(node, new HashSet<N>());
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
		return nodes.isEmpty();
	}

	public Collection<N> getAdjacent(N node) throws GraphException {
		if(!this.contains(node)) {
			throw new GraphException("Node doesn't exist!");
		}
		return arcs.get(node);
	}

	public Boolean contains(N node) {
		// TODO Auto-generated method stub
		return nodes.contains(node);
	}

	public Boolean containsArc(N node1, N node2) throws GraphException {
		if(!this.contains(node1) || !this.contains(node2)) {
			throw new GraphException("Node doesn't exist!");
		}
		Boolean exists = false;
		Set<N> adjacents=arcs.get(node1);
		if(adjacents.contains(node2))
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

	public Boolean isLabeled() {
		return false;
	}

	/**
	 * To be implemented depending on the type of the graph
	 * @param node1
	 * @param node2
	 * @post graph will have an arc from node1 to node2 if directed, and also in the opposite direction if undirected, if one or both nodes not exist in the arc will be also inserted
	 */
	public abstract void insArc(N node1, N node2);

	/**
	 * To be implemented depending on the type of the graph
	 * @param node1
	 * @param node2
	 * @throws GraphException if one or both nodes not exist in the graph, or the arc doesn't exist
	 * @precondition the arc between node1 and node2 must exists
	 */
	public abstract void removeArc(N node1, N node2) throws GraphException;



}
