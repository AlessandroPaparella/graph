package graph;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class DirectedHashedGraphTest {

	GenericGraph<Integer> graph;

	@Test
	void testNew() {
		graph = new DirectedHashedGraph<Integer>();
		assertTrue(graph.isEmpty() && graph.isNull() && !graph.isLabeled() && graph.isDirected());
	}

	@Test
	void testInsNode() {
		graph = new DirectedHashedGraph<Integer>();
		graph.insNode(1);
		assertTrue(graph.contains(1) && !graph.isEmpty() && graph.isNull());
	}

	@Test
	void testInsArcNewNodes() throws GraphException {
		graph = new DirectedHashedGraph<Integer>();
		((DirectedHashedGraph<Integer>)graph).insArc(1, 2);
		assertTrue(graph.containsArc(1, 2) && !graph.containsArc(2, 1));
	}

	@Test
	void testRemoveNodeError() {
		graph = new DirectedHashedGraph<Integer>();
		graph.insNode(1);
		assertThrows(GraphException.class, new Executable() {

			public void execute() throws Throwable {
				// TODO Auto-generated method stub
				graph.delNode(2);
			}
		});
	}

	@Test
	void testRemoveArc() throws GraphException {
		graph = new DirectedHashedGraph<Integer>();
		((DirectedHashedGraph<Integer>)graph).insArc(1, 2);
		((DirectedHashedGraph<Integer>)graph).removeArc(1, 2);
		assertTrue(!graph.containsArc(1, 2));
	}

	@Test
	void testRemoveNode() throws GraphException{
		graph = new DirectedHashedGraph<Integer>();
		graph.insNode(1);
		graph.delNode(1);
		assertTrue(!graph.contains(1));
	}

	@Test
	void testLoop() throws GraphException{
		graph = new DirectedHashedGraph<Integer>();
		((DirectedHashedGraph<Integer>)graph).insArc(1, 1);
		assertTrue(graph.containsArc(1, 1));
	}

}
