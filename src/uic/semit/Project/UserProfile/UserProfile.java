package uic.semit.Project.UserProfile;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class UserProfile
{

	@Expose
	private List<Availability> availability = new ArrayList<Availability>();
	@Expose
	private String joined;
	@Expose
	private Localization localization;
	@Expose
	private String name;
	@Expose
	private List<Project> projects = new ArrayList<Project>();
	@Expose
	private String sex;
	@Expose
	private List<Skills> skills = new ArrayList<Skills>();
	@Expose
	private String skypeaccount;
	@Expose
	private List<String> telnumbers = new ArrayList<String>();
	@Expose
	private String username;
	@Expose
	private List<String> webpages = new ArrayList<String>();

	/**
	 * 
	 * @return The availability
	 */
	public List<Availability> getAvailability()
	{
		return availability;
	}

	/**
	 * 
	 * @param availability
	 *            The availability
	 */
	public void setAvailability(List<Availability> availability)
	{
		this.availability = availability;
	}

	public UserProfile withAvailability(List<Availability> availability)
	{
		this.availability = availability;
		return this;
	}

	/**
	 * 
	 * @return The joined
	 */
	public String getJoined()
	{
		return joined;
	}

	/**
	 * 
	 * @param joined
	 *            The joined
	 */
	public void setJoined(String joined)
	{
		this.joined = joined;
	}

	public UserProfile withJoined(String joined)
	{
		this.joined = joined;
		return this;
	}

	/**
	 * 
	 * @return The localization
	 */
	public Localization getLocalization()
	{
		return localization;
	}

	/**
	 * 
	 * @param localization
	 *            The localization
	 */
	public void setLocalization(Localization localization)
	{
		this.localization = localization;
	}

	public UserProfile withLocalization(Localization localization)
	{
		this.localization = localization;
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

	public UserProfile withName(String name)
	{
		this.name = name;
		return this;
	}

	/**
	 * 
	 * @return The projects
	 */
	public List<Project> getProjects()
	{
		return projects;
	}

	/**
	 * 
	 * @param projects
	 *            The projects
	 */
	public void setProjects(List<Project> projects)
	{
		this.projects = projects;
	}

	public UserProfile withProjects(List<Project> projects)
	{
		this.projects = projects;
		return this;
	}

	/**
	 * 
	 * @return The sex
	 */
	public String getSex()
	{
		return sex;
	}

	/**
	 * 
	 * @param sex
	 *            The sex
	 */
	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public UserProfile withSex(String sex)
	{
		this.sex = sex;
		return this;
	}

	/**
	 * 
	 * @return The skills
	 */
	public List<Skills> getSkills()
	{
		return skills;
	}

	/**
	 * 
	 * @param skills
	 *            The skills
	 */
	public void setSkills(List<Skills> skills)
	{
		this.skills = skills;
	}

	public UserProfile withSkills(List<Skills> skills)
	{
		this.skills = skills;
		return this;
	}

	/**
	 * 
	 * @return The skypeaccount
	 */
	public String getSkypeaccount()
	{
		return skypeaccount;
	}

	/**
	 * 
	 * @param skypeaccount
	 *            The skypeaccount
	 */
	public void setSkypeaccount(String skypeaccount)
	{
		this.skypeaccount = skypeaccount;
	}

	public UserProfile withSkypeaccount(String skypeaccount)
	{
		this.skypeaccount = skypeaccount;
		return this;
	}

	/**
	 * 
	 * @return The telnumbers
	 */
	public List<String> getTelnumbers()
	{
		return telnumbers;
	}

	/**
	 * 
	 * @param telnumbers
	 *            The telnumbers
	 */
	public void setTelnumbers(List<String> telnumbers)
	{
		this.telnumbers = telnumbers;
	}

	public UserProfile withTelnumbers(List<String> telnumbers)
	{
		this.telnumbers = telnumbers;
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

	public UserProfile withUsername(String username)
	{
		this.username = username;
		return this;
	}

	/**
	 * 
	 * @return The webpages
	 */
	public List<String> getWebpages()
	{
		return webpages;
	}

	/**
	 * 
	 * @param webpages
	 *            The webpages
	 */
	public void setWebpages(List<String> webpages)
	{
		this.webpages = webpages;
	}

	public UserProfile withWebpages(List<String> webpages)
	{
		this.webpages = webpages;
		return this;
	}

	@Override
	public String toString()
	{
		return "UserProfile [availability=" + availability + ", joined="
				+ joined + ", localization=" + localization + ", name=" + name
				+ ", projects=" + projects + ", sex=" + sex + ", skills="
				+ skills + ", skypeaccount=" + skypeaccount + ", telnumbers="
				+ telnumbers + ", username=" + username + ", webpages="
				+ webpages + "]";
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(availability).append(joined)
				.append(localization).append(name).append(projects).append(sex)
				.append(skills).append(skypeaccount).append(telnumbers)
				.append(username).append(webpages).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) { return true; }
		if ((other instanceof UserProfile) == false) { return false; }
		UserProfile rhs = ((UserProfile) other);
		return new EqualsBuilder().append(availability, rhs.availability)
				.append(joined, rhs.joined)
				.append(localization, rhs.localization).append(name, rhs.name)
				.append(projects, rhs.projects).append(sex, rhs.sex)
				.append(skills, rhs.skills)
				.append(skypeaccount, rhs.skypeaccount)
				.append(telnumbers, rhs.telnumbers)
				.append(username, rhs.username).append(webpages, rhs.webpages)
				.isEquals();
	}

}
