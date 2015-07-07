package AST_JSON;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import com.habelitz.jsobjectizer.unmarshaller.antlrbridge.generated.JavaLexer;
import com.habelitz.jsobjectizer.unmarshaller.antlrbridge.generated.JavaParser;

public class AST_JSON
{

	public static String getJSON(String filename)
	{

		ANTLRFileStream input;
		JavaLexer lexer;
		CommonTokenStream tokens;
		JavaParser parser = null;
		JavaParser.javaSource_return javascource_return;
		CommonTree commonTree = null;

		try
		{
			input = new ANTLRFileStream(filename);
			lexer = new JavaLexer(input);

			tokens = new CommonTokenStream(lexer);

			parser = new JavaParser(tokens);

			javascource_return = parser.javaSource();

			commonTree = (CommonTree) javascource_return.getTree();

		}
		catch (IOException e)
		{
			System.err.println(filename + " Not Found");

		}
		catch (RecognitionException e)
		{
			// TODO Auto-generated catch block
			System.err.println("Cannot Recognize File" + filename);
		}

		return toJson(parser, commonTree, " ");

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

}
