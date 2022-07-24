package graph;

import java.util.Collection;

/**
 * A multigraph interface that provides the common operators between directed/undirected multigraph
 * @author AlessandroPaparella
 * @param <N> this is the generic type of object that will represent the nodes without duplicated values
 * @param <L> this is the generic type of object that will represent the labels without duplicated values between the same nodes with the same direction
 */
public interface Multigraph<N, L> extends GenericGraph<N> {

	/**
	 * Add a labeled edge between two nodes
	 * @param node1
	 * @param node2
	 * @param label
	 * @post graph will have a labeled arc from node1 to node2 if directed, and also in the opposite direction if undirected, if one or both nodes not exist in the arc will be also inserted
	 */
	public void insArc(N node1, N node2, L label);

	/**
	 * Given two nodes, get all the edges between them
	 * @param node1
	 * @param node2
	 * @return collection of the labels between node1 and node2
	 * @throws GraphException if node1 and/or node2 not exist in the graph
	 */
	public Collection<L> getArcs(N node1, N node2) throws GraphException;

	/**
	 * Remove the specified edge between two given nodes
	 * @param node1
	 * @param node2
	 */
	public void removeArc(N node1, N node2, L label);
}
