package Testing;

public class Space
{

	public static void main(String[] args)
	{
		String webhook = "git clone git://git.code.sf.net/p/jibx/code jibx-code";

		String finalString = webhook.substring(webhook.lastIndexOf(" ") + 1,
				webhook.length());
		finalString = webhook.replace(finalString, "/Users/kshitijgautam/JAVA/"
				+ finalString);
		System.err.println(finalString);
	}
}
