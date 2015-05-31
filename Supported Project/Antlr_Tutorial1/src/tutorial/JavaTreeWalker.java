package tutorial;

import java.io.IOException;

import com.habelitz.jsobjectizer.unmarshaller.antlrbridge.generated.*;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class JavaTreeWalker
{

	public static void main(String[] args) throws Exception
	{

		ANTLRFileStream input = new ANTLRFileStream(
				"/Users/kshitijgautam/Google Drive/Coding/workspace/SourceForge_ProjectData/src/Testing/tester.java");

		JavaLexer lexer = new JavaLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		JavaParser parser = new JavaParser(tokens);

		JavaParser.javaSource_return r = parser.javaSource();

		CommonTree t = (CommonTree) r.getTree();

		System.out.println(t.toStringTree());

		// CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		//
		// nodes.setTokenStream(tokens);
		//
		// JavaTreeParser walker = new JavaTreeParser(nodes);
		//
		// System.out.println("\nWalk tree:\n");
		//
		// walker.javaSource();
		//
		// System.out.println(tokens.toString());
		//
	}

}
