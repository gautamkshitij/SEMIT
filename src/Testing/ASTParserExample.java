package Testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.ChildPropertyDescriptor;
import org.eclipse.jdt.core.dom.SimplePropertyDescriptor;
import org.eclipse.jdt.core.dom.StructuralPropertyDescriptor;
import org.eclipse.jdt.internal.core.JavaProject;

public class ASTParserExample
{
	public static void main(String args[]) throws IOException
	{
		JavaProject jp = new JavaProject();

		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(readFileToString(
				"/Users/kshitijgautam/Google Drive/Coding/workspace/SourceForge_ProjectData/src/Testing/tester.java")
				.toCharArray());
		// parser.setProject(jp.getJavaProject());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node = parser.createAST(null);

		// System.out.println(node.getLength() + "-" + node.getNodeType() + "-"
		// + node.getFlags());
		print(node);
		// final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		// System.out.println(cu.toString());

	}

	private static void print(ASTNode node)
	{
		List properties = node.structuralPropertiesForType();
		for (ASTNode o : (ASTNode[]) getChildren(node))
		{
			// System.out.println(o.);
		}
		// System.err.println(node.toString().toString());
		// System.err.println(properties.toString().toString());
		for (Iterator iterator = properties.iterator(); iterator.hasNext();)
		{
			Object desciptor = iterator.next();

			if (desciptor instanceof SimplePropertyDescriptor)
			{
				SimplePropertyDescriptor simple = (SimplePropertyDescriptor) desciptor;

				Object value = node.getStructuralProperty(simple);

				// System.out.println(simple.getId() + " (" + value.toString()
				// + ")");
			}
			else if (desciptor instanceof ChildPropertyDescriptor)
			{
				ChildPropertyDescriptor child = (ChildPropertyDescriptor) desciptor;
				ASTNode childNode = (ASTNode) node.getStructuralProperty(child);
				if (childNode != null)
				{

					// System.out.println("Child (" + child.getId() + ") {");
					print(childNode);

					// System.out.println("}");
				}
			}
			else
			{
				ChildListPropertyDescriptor list = (ChildListPropertyDescriptor) desciptor;
				System.out.println("List (" + list.getId() + "){");

				PrintList((List) node.getStructuralProperty(list));
				System.out.println("}");
			}
		}
	}

	// read file content into a string
	public static String readFileToString(String filePath) throws IOException
	{
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));

		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1)
		{
			System.out.println(numRead);
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}

		reader.close();

		return fileData.toString();
	}

	public static Object[] getChildren(ASTNode node)
	{
		List list = node.structuralPropertiesForType();
		for (int i = 0; i < list.size(); i++)
		{
			StructuralPropertyDescriptor curr = (StructuralPropertyDescriptor) list
					.get(i);
			Object child = node.getStructuralProperty(curr);
			if (child instanceof List)
			{
				return ((List) child).toArray();
			}
			else if (child instanceof ASTNode) { return new Object[]
			{ child }; }
			return new Object[0];
		}
		return null;
	}

	// loop directory to get file list
	private static void PrintList(List nodes)
	{
		for (Iterator iterator = nodes.iterator(); iterator.hasNext();)
		{
			ASTNode node = (ASTNode) iterator.next();
			print(node);
		}
	}

}
