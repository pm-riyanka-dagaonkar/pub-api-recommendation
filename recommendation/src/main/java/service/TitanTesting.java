package service;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Features;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.GraphQuery;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.groovy.Gremlin;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.iterators.SingleIterator;

public class TitanTesting {

	public static void main(String[] args) {
		
		Graph graph = TinkerGraphFactory.createTinkerGraph();
		Pipe pipe = Gremlin.compile("_().out('knows').name");
		pipe.setStarts(new SingleIterator<Vertex>(graph.getVertex(1)));
		for(Object name : pipe) {
		  System.out.println((String) name);
		}
	}

}
