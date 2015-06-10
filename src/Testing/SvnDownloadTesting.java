//package Testing;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//public class SvnDownloadTesting
//{
//	public static void main(String arg[]) throws IOException
//	{
//
//		ProcessBuilder pb = new ProcessBuilder("svn", "checkout",
//				"http://svn.code.sf.net/p/masterale/svn/ masterale-svn");
//		File f = new File("./DATA/CODE/JAVA/discrialign");
//		
//		f.mkdir();
//		pb.directory(f);
//		pb.redirectErrorStream(true);
//		Process p = pb.start();
//
//		// better way to download files
//		try (InputStream stream = p.getInputStream())
//		{
//			Files.copy(stream,
//					Paths.get("./DATA/CODE/JAVA/discrialign/"));
//		}
//		// FileOutputStream outputStream = new FileOutputStream(
//		// "/Users/kshitijgautam/Pictures/DiscriAlign.zip");
//		//
//		// BufferedInputStream bis = new BufferedInputStream(is);
//		// byte[] bytes = new byte[100];
//		// int numberByteReaded;
//		// while ((numberByteReaded = bis.read(bytes, 0, 100)) != -1)
//		// {
//		//
//		// outputStream.write(bytes, 0, numberByteReaded);
//		// Arrays.fill(bytes, (byte) 0);
//		//
//		// }
//		//
//		// outputStream.flush();
//		// outputStream.close();
//		//
//	}
//}
