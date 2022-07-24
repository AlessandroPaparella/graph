package graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Alessandro Paparella
 * @param <N> this is the generic type of object that will represent the nodes
 *            without duplicated values
 * @param <L> this is the generic type of object that will represent the labels
 *            without duplicated values between the same nodes
 */
public class UndirHashMultigraph<N, L> extends HashedMultigraph<N, L> {

	@Override
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
			Map<N, Set<L>> arcs_node1 = super.getAllArcs(node1);
			Map<N, Set<L>> arcs_node2 = super.getAllArcs(node2);
			if(arcs_node1.containsKey(node2)) {
				arcs_node1.get(node2).add(label);
				arcs_node2.get(node1).add(label);
			}else {
				Set<L> labels = new HashSet<L>();
				labels.add(label);
				arcs_node1.put(node2, labels);
				arcs_node2.put(node1, labels);
			}
		} catch (Exception e) {
			// nothing to do
		}

	}

	@Override
	public void removeArc(N node1, N node2, L label) {
		Map<N, Set<L>> arcs_node1 = super.getAllArcs(node1);
		Map<N, Set<L>> arcs_node2 = super.getAllArcs(node2);
		arcs_node1.get(node2).remove(label);
		arcs_node2.get(node1).remove(label);
		if(arcs_node1.get(node2).isEmpty()) {
			arcs_node1.remove(node2);
			arcs_node2.remove(node1);
		}

	}

}
