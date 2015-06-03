package uic.semit.Project.ProjectData;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Categories
{

	private List<Audience> audience = new ArrayList<Audience>();
	private List<Database> database = new ArrayList<Database>();
	private List<Developmentstatu> developmentstatus = new ArrayList<Developmentstatu>();
	private List<Environment> environment = new ArrayList<Environment>();
	private List<Language> language = new ArrayList<Language>();
	private List<License> license = new ArrayList<License>();
	private List<Os> os = new ArrayList<Os>();
	private List<Topic> topic = new ArrayList<Topic>();
	private List<Translation> translation = new ArrayList<Translation>();

	public Categories(List<Audience> audience, List<Database> database,
			List<Developmentstatu> developmentstatus,
			List<Environment> environment, List<Language> language,
			List<License> license, List<Os> os, List<Topic> topic,
			List<Translation> translation)
	{

		this.audience = audience;
		this.database = database;
		this.developmentstatus = developmentstatus;
		this.environment = environment;
		this.language = language;
		this.license = license;
		this.os = os;
		this.topic = topic;
		this.translation = translation;
	}

	/**
	 * 
	 * @return The audience
	 */

	public List<Audience> getAudience()
	{
		return audience;
	}

	/**
	 * 
	 * @param audience
	 *            The audience
	 */
	public void setAudience(List<Audience> audience)
	{
		this.audience = audience;
	}

	public Categories withAudience(List<Audience> audience)
	{
		this.audience = audience;
		return this;
	}

	/**
	 * 
	 * @return The database
	 */
	public List<Database> getDatabase()
	{
		return database;
	}

	/**
	 * 
	 * @param database
	 *            The database
	 */
	public void setDatabase(List<Database> database)
	{
		this.database = database;
	}

	public Categories withDatabase(List<Database> database)
	{
		this.database = database;
		return this;
	}

	/**
	 * 
	 * @return The developmentstatus
	 */
	public List<Developmentstatu> getDevelopmentstatus()
	{
		return developmentstatus;
	}

	/**
	 * 
	 * @param developmentstatus
	 *            The developmentstatus
	 */
	public void setDevelopmentstatus(List<Developmentstatu> developmentstatus)
	{
		this.developmentstatus = developmentstatus;
	}

	public Categories withDevelopmentstatus(
			List<Developmentstatu> developmentstatus)
	{
		this.developmentstatus = developmentstatus;
		return this;
	}

	/**
	 * 
	 * @return The environment
	 */
	public List<Environment> getEnvironment()
	{
		return environment;
	}

	/**
	 * 
	 * @param environment
	 *            The environment
	 */
	public void setEnvironment(List<Environment> environment)
	{
		this.environment = environment;
	}

	public Categories withEnvironment(List<Environment> environment)
	{
		this.environment = environment;
		return this;
	}

	/**
	 * 
	 * @return The language
	 */
	public List<Language> getLanguage()
	{
		return language;
	}

	/**
	 * 
	 * @param language
	 *            The language
	 */
	public void setLanguage(List<Language> language)
	{
		this.language = language;
	}

	public Categories withLanguage(List<Language> language)
	{
		this.language = language;
		return this;
	}

	/**
	 * 
	 * @return The license
	 */
	public List<License> getLicense()
	{
		return license;
	}

	/**
	 * 
	 * @param license
	 *            The license
	 */
	public void setLicense(List<License> license)
	{
		this.license = license;
	}

	public Categories withLicense(List<License> license)
	{
		this.license = license;
		return this;
	}

	/**
	 * 
	 * @return The os
	 */
	public List<Os> getOs()
	{
		return os;
	}

	/**
	 * 
	 * @param os
	 *            The os
	 */
	public void setOs(List<Os> os)
	{
		this.os = os;
	}

	public Categories withOs(List<Os> os)
	{
		this.os = os;
		return this;
	}

	/**
	 * 
	 * @return The topic
	 */
	public List<Topic> getTopic()
	{
		return topic;
	}

	/**
	 * 
	 * @param topic
	 *            The topic
	 */
	public void setTopic(List<Topic> topic)
	{
		this.topic = topic;
	}

	public Categories withTopic(List<Topic> topic)
	{
		this.topic = topic;
		return this;
	}

	/**
	 * 
	 * @return The translation
	 */
	public List<Translation> getTranslation()
	{
		return translation;
	}

	/**
	 * 
	 * @param translation
	 *            The translation
	 */
	public void setTranslation(List<Translation> translation)
	{
		this.translation = translation;
	}

	public Categories withTranslation(List<Translation> translation)
	{
		this.translation = translation;
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
		return new HashCodeBuilder().append(audience).append(database)
				.append(developmentstatus).append(environment).append(language)
				.append(license).append(os).append(topic).append(translation)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) { return true; }
		if ((other instanceof Categories) == false) { return false; }
		Categories rhs = ((Categories) other);
		return new EqualsBuilder().append(audience, rhs.audience)
				.append(database, rhs.database)
				.append(developmentstatus, rhs.developmentstatus)
				.append(environment, rhs.environment)
				.append(language, rhs.language).append(license, rhs.license)
				.append(os, rhs.os).append(topic, rhs.topic)
				.append(translation, rhs.translation)

				.isEquals();
	}

}
