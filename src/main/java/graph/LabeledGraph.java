package graph;

/**
 * A generic interface for edge labeled graphs
 * @author AlessandroPaparella
 *
 * @param <N> this is the generic type of object that will represent the nodes without duplicated values
 * @param <L> this is the generic type of object that will represent the labels on edges
 */
public interface LabeledGraph<N, L> extends GenericGraph<N> {

	/**
	 * Add a labeled edge between two nodes
	 * @param node1
	 * @param node2
	 * @param label
	 * @post graph will have a labeled arc from node1 to node2 if directed, and also in the opposite direction if undirected, if one or both nodes not exist in the arc will be also inserted
	 */
	public void insArc(N node1, N node2, L label);

	/**
	 * Remove the edge between two given nodes
	 * @param node1
	 * @param node2
	 * @throws GraphException if node1 and/or node2 not exist in the graph
	 */
	public void removeArc(N node1, N node2) throws GraphException;

	/**
	 * Read the label on the edge between two given nodes
	 * @param node1
	 * @param node2
	 * @return label between node1 and node2
	 * @precondition the arc between node1 and node2 must exists
	 * @throws GraphException if node1 and/or node2 not exist in the graph
	 */
	public L readArc(N node1, N node2) throws GraphException;

}
