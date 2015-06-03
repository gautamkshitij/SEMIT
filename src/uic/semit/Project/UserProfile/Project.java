package uic.semit.Project.UserProfile;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Project
{

	@SerializedName("last_updated")
	@Expose
	private String lastUpdated;
	@Expose
	private String name;
	@Expose
	private String summary;
	@Expose
	private String url;

	/**
	 * 
	 * @return The lastUpdated
	 */
	public String getLastUpdated()
	{
		return lastUpdated;
	}

	/**
	 * 
	 * @param lastUpdated
	 *            The last_updated
	 */
	public void setLastUpdated(String lastUpdated)
	{
		this.lastUpdated = lastUpdated;
	}

	public Project withLastUpdated(String lastUpdated)
	{
		this.lastUpdated = lastUpdated;
		return this;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	public Project withName(String name)
	{
		this.name = name;
		return this;
	}

	/**
	 * 
	 * @return The summary
	 */
	public String getSummary()
	{
		return summary;
	}

	/**
	 * 
	 * @param summary
	 *            The summary
	 */
	public void setSummary(String summary)
	{
		this.summary = summary;
	}

	public Project withSummary(String summary)
	{
		this.summary = summary;
		return this;
	}

	/**
	 * 
	 * @return The url
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * 
	 * @param url
	 *            The url
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}

	public Project withUrl(String url)
	{
		this.url = url;
		return this;
	}

	@Override
	public String toString()
	{
		return "Project [lastUpdated=" + lastUpdated + ", name=" + name
				+ ", summary=" + summary + ", url=" + url + "]";
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(lastUpdated).append(name)
				.append(summary).append(url).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) { return true; }
		if ((other instanceof Project) == false) { return false; }
		Project rhs = ((Project) other);
		return new EqualsBuilder().append(lastUpdated, rhs.lastUpdated)
				.append(name, rhs.name).append(summary, rhs.summary)
				.append(url, rhs.url).isEquals();
	}

}
