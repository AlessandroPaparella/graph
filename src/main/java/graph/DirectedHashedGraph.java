package graph;

import java.util.Set;

/**
 *
 * @author AlessandroPaparella
 *
 * @param <N>
 */
public class DirectedHashedGraph<N> extends GenericHashedGraph<N> {

	public Boolean isDirected() {
		return true;
	}

	@Override
	public void insArc(N node1, N node2) {
		if(!this.contains(node1)) {
			this.insNode(node1);
		}
		if(!this.contains(node2)) {
			this.insNode(node2);
		}
		try {
			((Set<N>)super.getAdjacent(node1)).add(node2);
		} catch (Exception e) {
			// nothing to do
		}

	}

	@Override
	public void removeArc(N node1, N node2) throws GraphException {
		((Set<N>)this.getAdjacent(node1)).remove(node2);
	}



}
