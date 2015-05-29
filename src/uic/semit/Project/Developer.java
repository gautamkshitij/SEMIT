package uic.semit.Project;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Developer
{

	private String name;
	private String url;
	private String username;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Developer(String name, String url, String username)
	{

		this.name = name;
		this.url = url;
		this.username = username;
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

	public Developer withName(String name)
	{
		this.name = name;
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

	public Developer withUrl(String url)
	{
		this.url = url;
		return this;
	}

	/**
	 * 
	 * @return The username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * 
	 * @param username
	 *            The username
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	public Developer withUsername(String username)
	{
		this.username = username;
		return this;
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}

	public Map<String, Object> getAdditionalProperties()
	{
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value)
	{
		this.additionalProperties.put(name, value);
	}

	public Developer withAdditionalProperty(String name, Object value)
	{
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(name).append(url).append(username)
				.append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) { return true; }
		if ((other instanceof Developer) == false) { return false; }
		Developer rhs = ((Developer) other);
		return new EqualsBuilder().append(name, rhs.name).append(url, rhs.url)
				.append(username, rhs.username)
				.append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

}
