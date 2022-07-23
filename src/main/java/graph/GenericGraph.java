package graph;

import java.util.Collection;

/**
 * A generic graph interface that provides the common operations between directed/undirected/edge labeled graphs
 * @author AlessandroPaparella
 * @param <N> this is the generic type of object that will represent the nodes without duplicated values
 */
public interface GenericGraph<N> {

	/**
	 * Add a node with no links
	 * @param node, node to insert
	 * @post the graph will have a new node if "node" is not already contained
	 */
	public void insNode(N node);

	/**
	 * Delete a node
	 * @param node to delete
	 * @throws GraphException if node doesn't exist in graph
	 * @post the graph will not have anymore the node "node" and all related link
	 * @precondition node must exists in graph
	 */
	public void delNode(N node) throws GraphException;

	/**
	 * Check if the graph is empty
	 * @return true if the graph has no nodes, false otherwise
	 */
	public Boolean isEmpty();

	/**
	 * Get all nodes connected to "node"
	 * @param node
	 * @return a collection of all adjacent nodes of "node"
	 * @throws GraphException if node doesn't exist in the graph
	 * @precondition node must exists in graph
	 */
	public Collection<N> getAdjacent(N node) throws GraphException;

	/**
	 * Check if node exists in the graph
	 * @param node
	 * @return true if node exists, false otherwise
	 */
	public Boolean contains(N node);

	/**
	 * Check if node1 and node2 are linked at least from node1 to node2
	 * @param node1
	 * @param node2
	 * @return true if isDirected() is true and there is a link from node1 to node2 or isDirected() is false there is a link between node1 and node2, false otherwise
	 * @throws GraphException if node1 and/or node2 not exist in the graph
	 * @precondition node1 and node2 must exist in the graph
	 */
	public Boolean containsArc(N node1, N node2) throws GraphException;

	/**
	 * Check if the graph as no arcs
	 * @return true if there are no arcs in the graphs
	 */
	public Boolean isNull();

	/**
	 * check if the graph is directed
	 * @return true if the graph is directed, false id the graph is undirected
	 */
	public Boolean isDirected();

	/**
	 * Check if the graph has labels on the arcs
	 * @return true if the graph as label on the arcs
	 */
	public Boolean isLabeled();

	/**
	 * Check if the graph can have more than one edge between the same nodes in the same direction
	 * @return true if the graph as label on the arcs
	 */
	public Boolean isMulti();
}
