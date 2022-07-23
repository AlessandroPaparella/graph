package graph;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class DirectedHashMultigraphTest {

	GenericGraph<Integer> graph;

	@Test
	void testNew() {
		graph = new DirectedHashMultigraph<Integer, Character>();
		assertTrue(graph.isEmpty() && graph.isNull() && graph.isLabeled() && graph.isDirected());
	}

	@Test
	void testInsNode() {
		graph = new DirectedHashMultigraph<Integer, Integer>();
		graph.insNode(1);
		assertTrue(graph.contains(1) && !graph.isEmpty() && graph.isNull());
	}

	@Test
	void testInsArcNewNodes() throws GraphException {
		graph = new DirectedHashMultigraph<Integer, Character>();
		((DirectedHashMultigraph<Integer, Character>)graph).insArc(1, 2, 'A');
		((DirectedHashMultigraph<Integer, Character>)graph).insArc(1, 2, 'B');
		assertTrue(graph.containsArc(1, 2) && !graph.containsArc(2, 1) && !graph.isNull());
		assertTrue(((DirectedHashMultigraph<Integer, Character>)graph).getArcs(1,2).contains('A') && ((DirectedHashMultigraph<Integer, Character>)graph).getArcs(1,2).contains('B'));
	}

	@Test
	void testRemoveNodeError() {
		graph = new DirectedHashMultigraph<Integer, Character>();
		graph.insNode(1);
		assertThrows(GraphException.class, new Executable() {

			public void execute() throws Throwable {
				graph.delNode(2);
			}
		});
	}

	@Test
	void testRemoveArc() throws GraphException {
		graph = new DirectedHashMultigraph<Integer, Character>();
		((DirectedHashMultigraph<Integer, Character>)graph).insArc(1, 2, 'C');
		((DirectedHashMultigraph<Integer, Character>)graph).removeArc(1, 2, 'C');
		assertTrue(!graph.containsArc(1, 2));
	}

	@Test
	void testRemoveNode() throws GraphException{
		graph = new DirectedHashMultigraph<Integer, Character>();
		graph.insNode(1);
		graph.delNode(1);
		assertTrue(!graph.contains(1));
	}

	@Test
	void testRemoveNodeArc() throws GraphException{
		graph = new DirectedHashMultigraph<Integer, Character>();
		((DirectedHashMultigraph<Integer, Character>)graph).insArc(1, 2, 'D');
		((DirectedHashMultigraph<Integer, Character>)graph).insArc(1, 2, 'C');
		((DirectedHashMultigraph<Integer, Character>)graph).delNode(2);
		assertTrue(!graph.contains(2));
		assertThrows(GraphException.class, new Executable() {

			public void execute() throws Throwable {
				((DirectedHashMultigraph<Integer, Character>)graph).containsArc(1, 2);
			}
		});
	}

	@Test
	void testLoop() throws GraphException{
		graph = new DirectedHashMultigraph<Integer, Character>();
		((DirectedHashMultigraph<Integer, Character>)graph).insArc(1, 1, 'C');
		assertTrue(graph.containsArc(1, 1));
	}

}
