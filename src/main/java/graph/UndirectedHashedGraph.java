package graph;

import java.util.Set;


/**
 *
 * @author Alessandro Paparella
 *
 * @param <N>
 */
public class UndirectedHashedGraph<N> extends GenericHashedGraph<N> {

	@Override
	public Boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
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
			((Set<N>)super.getAdjacent(node2)).add(node1);  //add an arc in both directions
		} catch (Exception e) {
			// nothing to do
		}

	}

	@Override
	public void removeArc(N node1, N node2) throws GraphException {
		((Set<N>)this.getAdjacent(node1)).remove(node2);
		((Set<N>)this.getAdjacent(node2)).remove(node1);
	}



}
