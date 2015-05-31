//package Testing;
//
//import japa.parser.JavaParser;
//import japa.parser.ast.CompilationUnit;
//
//import java.io.FileInputStream;
//
//public class GoogleJavaParser
//{
//	public static void main(String[] args) throws Exception
//	{
//		// creates an input stream for the file to be parsed
//		FileInputStream in = new FileInputStream(
//				"/Users/kshitijgautam/Google Drive/Coding/workspace/SourceForge_ProjectData/src/Testing/tester.java");
//
//		CompilationUnit cu;
//		try
//		{
//			// parse the file
//			cu = JavaParser.parse(in);
//		}
//		finally
//		{
//			in.close();
//		}
//
//		// prints the resulting compilation unit to default system output
//		System.out.println(cu.toString());
//	}
//}
