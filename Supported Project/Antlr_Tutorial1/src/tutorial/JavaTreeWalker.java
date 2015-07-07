package tutorial;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;

import com.habelitz.jsobjectizer.unmarshaller.antlrbridge.generated.JavaLexer;
import com.habelitz.jsobjectizer.unmarshaller.antlrbridge.generated.JavaParser;

public class JavaTreeWalker
{

	public static void main(String[] args) throws Exception
	{

		ANTLRFileStream input = new ANTLRFileStream(
				"/Users/kshitijgautam/Google Drive/Coding/Antlr_Tutorial1/src/tutorial/HelloWorld.java");

		JavaLexer lexer = new JavaLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		JavaParser parser = new JavaParser(tokens);

		JavaParser.javaSource_return r = parser.javaSource();

		CommonTree t = (CommonTree) r.getTree();

		System.out.println(toJson(parser, t, " "));

		// System.err.println(t.getText() + " --- " + t.getType() + "---- "
		// + t.getToken());
	}

	public static String toJson(JavaParser parser, CommonTree commonTree,
			String indent)
	{
		String json = indent + "{\n" + indent + "\t\"tokenType\":"
				+ commonTree.token.getType() + ",\n" + indent
				+ "\t\"tokenName\":\""
				+ commonTree.token.getText().replaceAll("\"", "\\\\\"") + "\"";

		if (commonTree.getChildren() != null)
		{
			String comma = "";
			json += ",\n" + indent + "\t\"children\":[";
			for (Object child : commonTree.getChildren())
			{
				// assumes child is also CommonTree...
				json += comma + "\n"
						+ toJson(parser, (CommonTree) child, indent + "\t\t");
				comma = ",";
			}
			json += "\n" + indent + "\t]\n";
		}
		else
		{
			json += "\n";
		}

		json = json + indent + "}";

		return json;
	}

	public static void showDiagraph(CommonTree commontree)
	{

		DOTTreeGenerator gen = new DOTTreeGenerator();
		StringTemplate st = gen.toDOT(commontree);
		System.out.println(st);

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

	public static String toJson_2(JavaParser parser, CommonTree commonTree,
			String indent)
	{
		String json = indent
				+ "{\n"
				+ indent
				+ "\t'tokenType'="
				+ commonTree.token.getType()
				+ ",\n"
				+ indent
				+ "\t'tokenName'='"
				+ parser.getTokenNames()[commonTree.token.getType()]
						.replaceAll("'", "\\\\'") + "'";
		if (commonTree.getChildren() != null)
		{
			String comma = "";
			json += ",\n" + indent + "\t\"children\":[";
			for (Object child : commonTree.getChildren())
			{
				// assumes child is also CommonTree...
				json += comma + "\n"
						+ toJson(parser, (CommonTree) child, indent + "\t\t");
				comma = ",";
			}
			json += "\n" + indent + "\t]\n";
		}
		else
		{
			json += "\n";
		}
		return json + indent + "}";
	}

}
