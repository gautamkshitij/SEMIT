package uic.semit.Project.UserProfile;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Availability
{

	@SerializedName("week_day")
	@Expose
	private String weekDay;
	@SerializedName("start_time")
	@Expose
	private Long startTime;
	@SerializedName("end_time")
	@Expose
	private Long endTime;

	/**
	 * 
	 * @return The weekDay
	 */
	public String getWeekDay()
	{
		return weekDay;
	}

	/**
	 * 
	 * @param weekDay
	 *            The week_day
	 */
	public void setWeekDay(String weekDay)
	{
		this.weekDay = weekDay;
	}

	public Availability withWeekDay(String weekDay)
	{
		this.weekDay = weekDay;
		return this;
	}

	/**
	 * 
	 * @return The startTime
	 */
	public Long getStartTime()
	{
		return startTime;
	}

	/**
	 * 
	 * @param startTime
	 *            The start_time
	 */
	public void setStartTime(Long startTime)
	{
		this.startTime = startTime;
	}

	public Availability withStartTime(Long startTime)
	{
		this.startTime = startTime;
		return this;
	}

	/**
	 * 
	 * @return The endTime
	 */
	public Long getEndTime()
	{
		return endTime;
	}

	/**
	 * 
	 * @param endTime
	 *            The end_time
	 */
	public void setEndTime(Long endTime)
	{
		this.endTime = endTime;
	}

	public Availability withEndTime(Long endTime)
	{
		this.endTime = endTime;
		return this;
	}

	@Override
	public String toString()
	{
		return "Availability [weekDay=" + weekDay + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(weekDay).append(startTime)
				.append(endTime).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) { return true; }
		if ((other instanceof Availability) == false) { return false; }
		Availability rhs = ((Availability) other);
		return new EqualsBuilder().append(weekDay, rhs.weekDay)
				.append(startTime, rhs.startTime).append(endTime, rhs.endTime)
				.isEquals();
	}

}
