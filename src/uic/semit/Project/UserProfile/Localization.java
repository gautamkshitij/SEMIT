package uic.semit.Project.UserProfile;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Localization
{

	@Expose
	private String city;
	@Expose
	private String country;

	/**
	 * 
	 * @return The city
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * 
	 * @param city
	 *            The city
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

	public Localization withCity(String city)
	{
		this.city = city;
		return this;
	}

	/**
	 * 
	 * @return The country
	 */
	public String getCountry()
	{
		return country;
	}

	/**
	 * 
	 * @param country
	 *            The country
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}

	public Localization withCountry(String country)
	{
		this.country = country;
		return this;
	}

	@Override
	public String toString()
	{
		return "Localization [city=" + city + ", country=" + country + "]";
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(city).append(country).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) { return true; }
		if ((other instanceof Localization) == false) { return false; }
		Localization rhs = ((Localization) other);
		return new EqualsBuilder().append(city, rhs.city)
				.append(country, rhs.country).isEquals();
	}

}
