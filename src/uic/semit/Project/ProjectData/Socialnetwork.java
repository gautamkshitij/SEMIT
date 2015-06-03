package uic.semit.Project.ProjectData;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Socialnetwork
{

	private String accounturl;
	private String socialnetwork;

	/**
	 * 
	 * @return The accounturl
	 */

	public Socialnetwork(String accounturl, String socialnetwork)
	{
		super();
		this.accounturl = accounturl;
		this.socialnetwork = socialnetwork;
	}

	public String getAccounturl()
	{
		return accounturl;
	}

	/**
	 * 
	 * @param accounturl
	 *            The accounturl
	 */
	public void setAccounturl(String accounturl)
	{
		this.accounturl = accounturl;
	}

	public Socialnetwork withAccounturl(String accounturl)
	{
		this.accounturl = accounturl;
		return this;
	}

	/**
	 * 
	 * @return The socialnetwork
	 */
	public String getSocialnetwork()
	{
		return socialnetwork;
	}

	/**
	 * 
	 * @param socialnetwork
	 *            The socialnetwork
	 */
	public void setSocialnetwork(String socialnetwork)
	{
		this.socialnetwork = socialnetwork;
	}

	public Socialnetwork withSocialnetwork(String socialnetwork)
	{
		this.socialnetwork = socialnetwork;
		return this;
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(accounturl).append(socialnetwork)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) { return true; }
		if ((other instanceof Socialnetwork) == false) { return false; }
		Socialnetwork rhs = ((Socialnetwork) other);
		return new EqualsBuilder().append(accounturl, rhs.accounturl)
				.append(socialnetwork, rhs.socialnetwork)

				.isEquals();
	}

}
