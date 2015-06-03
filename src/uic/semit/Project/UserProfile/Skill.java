package uic.semit.Project.UserProfile;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Skill
{

	@Expose
	private String fullpath;
	@Expose
	private String fullname;
	@Expose
	private String shortname;
	@Expose
	private Long id;

	/**
	 * 
	 * @return The fullpath
	 */
	public String getFullpath()
	{
		return fullpath;
	}

	/**
	 * 
	 * @param fullpath
	 *            The fullpath
	 */
	public void setFullpath(String fullpath)
	{
		this.fullpath = fullpath;
	}

	public Skill withFullpath(String fullpath)
	{
		this.fullpath = fullpath;
		return this;
	}

	/**
	 * 
	 * @return The fullname
	 */
	public String getFullname()
	{
		return fullname;
	}

	/**
	 * 
	 * @param fullname
	 *            The fullname
	 */
	public void setFullname(String fullname)
	{
		this.fullname = fullname;
	}

	public Skill withFullname(String fullname)
	{
		this.fullname = fullname;
		return this;
	}

	/**
	 * 
	 * @return The shortname
	 */
	public String getShortname()
	{
		return shortname;
	}

	/**
	 * 
	 * @param shortname
	 *            The shortname
	 */
	public void setShortname(String shortname)
	{
		this.shortname = shortname;
	}

	public Skill withShortname(String shortname)
	{
		this.shortname = shortname;
		return this;
	}

	/**
	 * 
	 * @return The id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	public Skill withId(Long id)
	{
		this.id = id;
		return this;
	}

	@Override
	public String toString()
	{
		return "Skill [fullpath=" + fullpath + ", fullname=" + fullname
				+ ", shortname=" + shortname + ", id=" + id + "]";
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(fullpath).append(fullname)
				.append(shortname).append(id).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) { return true; }
		if ((other instanceof Skill) == false) { return false; }
		Skill rhs = ((Skill) other);
		return new EqualsBuilder().append(fullpath, rhs.fullpath)
				.append(fullname, rhs.fullname)
				.append(shortname, rhs.shortname).append(id, rhs.id).isEquals();
	}

}
