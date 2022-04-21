package graph;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class UndirLabeledHGraphTest {

	UndirLabeledHGraph<Integer, String> graph;

	@Test
	void testNew() {
		graph = new UndirLabeledHGraph<Integer, String>();
		assertTrue(graph.isEmpty() && graph.isNull() && graph.isLabeled() && !graph.isDirected());
	}

	@Test
	void testInsNode() {
		graph = new UndirLabeledHGraph<Integer, String>();
		graph.insNode(1);
		assertTrue(graph.contains(1) && !graph.isEmpty() && graph.isNull());
	}

	@Test
	void testInsArcNewNodes() throws GraphException {
		graph = new UndirLabeledHGraph<Integer, String>();
		graph.insArc(1, 2, "A");
		assertTrue(graph.containsArc(1, 2) && graph.containsArc(2, 1) && graph.readArc(1, 2)=="A" && graph.readArc(2, 1)=="A");
	}

	@Test
	void testRemoveArc() throws GraphException {
		graph = new UndirLabeledHGraph<Integer, String>();
		graph.insArc(1, 2, "A");
		graph.removeArc(1, 2);
		assertTrue(!graph.containsArc(1, 2) && !graph.containsArc(2, 1));
	}

	@Test
	void testEditArc() throws GraphException {
		graph = new UndirLabeledHGraph<Integer, String>();
		graph.insArc(1, 2, "A");
		graph.insArc(1, 2, "B");
		assertTrue(graph.containsArc(1, 2) && graph.containsArc(2, 1) && graph.readArc(1, 2)=="B" && graph.readArc(2, 1)=="B");
	}

	@Test
	void testAdjacents() throws GraphException {
		graph = new UndirLabeledHGraph<Integer, String>();
		graph.insArc(1, 2, "A");
		graph.insArc(1, 3, "A");
		assertTrue(graph.getAdjacent(1).containsAll(Arrays.asList(2,3)) && graph.getAdjacent(3).containsAll(Arrays.asList(1)));
	}

	@Test
	void testRemoveNodeError() {
		graph = new UndirLabeledHGraph<Integer, String>();
		graph.insNode(1);
		assertThrows(GraphException.class, new Executable() {

			public void execute() throws Throwable {
				// TODO Auto-generated method stub
				graph.delNode(2);
			}
		});
	}

	@Test
	void testRemoveNode() throws GraphException{
		graph = new UndirLabeledHGraph<Integer, String>();
		graph.insNode(1);
		graph.delNode(1);
		assertTrue(!graph.contains(1));
	}

	@Test
	void testLoop() throws GraphException{
		graph = new UndirLabeledHGraph<Integer, String>();
		graph.insArc(1, 1, "");
		assertTrue(graph.containsArc(1, 1));
	}

}
