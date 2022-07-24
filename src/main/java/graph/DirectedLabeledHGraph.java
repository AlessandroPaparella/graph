package graph;

/**
 *
 * @author Alessandro Paparella
 *
 * @param <N> this is the generic type of object that will represent the nodes without duplicated values
 * @param <L> this is the generic type of object that will represent the labels on edges
 */
public class DirectedLabeledHGraph<N, L> extends HashedLabeledGraph<N, L> {

	@Override
	public Boolean isDirected() {
		return true;
	}

	@Override
	public void insArc(N node1, N node2, L label) {
		if(!this.contains(node1)) {
			this.insNode(node1);
		}
		if(!this.contains(node2)) {
			this.insNode(node2);
		}
		try {
			getArcs(node1).put(node2, label);
		} catch (Exception e) {
			// nothing to do
		}
	}

	@Override
	public void removeArc(N node1, N node2) throws GraphException {
		getArcs(node1).remove(node2);
	}

	@Override
	public L readArc(N node1, N node2) throws GraphException {
		if(!containsArc(node1, node2)) {
			throw new GraphException("Arc"+node1.toString()+"->"+node2.toString()+" does not exists!");
		}
		return getArcs(node1).get(node2);
	}

}
