package uic.semit.Project.ProjectData;

import javax.annotation.Generated;

import uic.semit.Project.UserProfile.UserProfile;

@Generated("org.jsonschema2pojo")
public class Developer
{

	private String name;
	private String url;
	private String username;
	UserProfile userprofile;

	public Developer(String name, String url, String username,
			UserProfile userprofile)
	{

		this.name = name;
		this.url = url;
		this.username = username;
		this.userprofile = userprofile;
	}

	public UserProfile getUserprofile()
	{
		return userprofile;
	}

	public void setUserprofile(UserProfile userprofile)
	{
		this.userprofile = userprofile;
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
		return "Developer [name=" + name + ", url=" + url + ", username="
				+ username + ", userprofile=" + userprofile + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		result = prime * result
				+ ((userprofile == null) ? 0 : userprofile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Developer other = (Developer) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		if (url == null)
		{
			if (other.url != null)
				return false;
		}
		else if (!url.equals(other.url))
			return false;
		if (username == null)
		{
			if (other.username != null)
				return false;
		}
		else if (!username.equals(other.username))
			return false;
		if (userprofile == null)
		{
			if (other.userprofile != null)
				return false;
		}
		else if (!userprofile.equals(other.userprofile))
			return false;
		return true;
	}

}
