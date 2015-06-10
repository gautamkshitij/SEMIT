package Testing;

import java.io.ByteArrayInputStream;

import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.ISVNEditor;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.io.diff.SVNDeltaGenerator;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class SVNExample_Checkout
{

	private static final String SVN_URL = "http://svn.code.sf.net/p/masterale/svn/ masterale-svn";
	private static final long HEAD_REVISION = -1;
	private SVNRepository repository = null;

	public static void main(String[] args)
	{
		String username = args[0];
		String password = args[1];
		SVNExample_Checkout app = new SVNExample_Checkout();
		app.doSvnKitExample("", "");
	}

	private void doSvnKitExample(String username, String password)
	{
		System.out.println("Connecting SVN repository with username '"
				+ username + "' and password '" + password + "'.");
		DAVRepositoryFactory.setup();
		try
		{
			SVNURL url = SVNURL.parseURIDecoded(SVN_URL);
			repository = SVNRepositoryFactory.create(url);
			// ISVNAuthenticationManager authManager = SVNWCUtil
			// .createDefaultAuthenticationManager(username, password);
			//	repository.setAuthenticationManager(authManager);
			byte[] data = "Modified file contents.".getBytes();
			ISVNEditor editor = repository.getCommitEditor("Commit message.",
					null);
			editor.openRoot(HEAD_REVISION);
			String targetFolder = "target-folder-"
					+ java.util.UUID.randomUUID().toString();
			editor.addDir(targetFolder, "source-folder", HEAD_REVISION);
			editor.openDir(targetFolder + "/folder1", HEAD_REVISION);
			editor.openDir(targetFolder + "/folder1/subfolder1", HEAD_REVISION);
			// create file added-file.txt in copied folder structure
			String modifiedFilePath = targetFolder + "/folder1/added-file.txt";
			editor.addFile(modifiedFilePath, null, HEAD_REVISION);
			editor.applyTextDelta(modifiedFilePath, null);
			SVNDeltaGenerator deltaGenerator = new SVNDeltaGenerator();
			String checksum = deltaGenerator.sendDelta(modifiedFilePath,
					new ByteArrayInputStream(data), editor, true);
			editor.closeFile(modifiedFilePath, checksum);
			editor.closeDir(); // targetFolder+"/folder1/subfolder1"
			editor.closeDir(); // targetFolder+"/folder1"

			SVNCommitInfo commitInfo = editor.closeEdit();
			System.out.println(commitInfo.toString());
		}
		catch (SVNException e)
		{
			e.printStackTrace();
		}

	}
}
