package graph;

public class UndirLabeledHGraph<N, L> extends HashedLabeledGraph<N, L> {

	public Boolean isDirected() {
		return false;
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
			getArcs(node2).put(node1, label);
		} catch (Exception e) {
			// nothing to do
		}
	}

	@Override
	public void removeArc(N node1, N node2) throws GraphException {
		getArcs(node1).remove(node2);
		getArcs(node2).remove(node1);
	}

	@Override
	public L readArc(N node1, N node2) throws GraphException {
		return getArcs(node1).get(node2);
	}

}
