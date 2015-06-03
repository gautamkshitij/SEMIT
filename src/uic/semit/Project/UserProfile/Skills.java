package uic.semit.Project.UserProfile;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Skills
{

	@Expose
	private String comment;
	@Expose
	private String level;
	@Expose
	private Skill skill;

	/**
	 * 
	 * @return The comment
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * 
	 * @param comment
	 *            The comment
	 */
	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public Skills withComment(String comment)
	{
		this.comment = comment;
		return this;
	}

	/**
	 * 
	 * @return The level
	 */
	public String getLevel()
	{
		return level;
	}

	/**
	 * 
	 * @param level
	 *            The level
	 */
	public void setLevel(String level)
	{
		this.level = level;
	}

	public Skills withLevel(String level)
	{
		this.level = level;
		return this;
	}

	/**
	 * 
	 * @return The skill
	 */
	public Skill getSkill()
	{
		return skill;
	}

	/**
	 * 
	 * @param skill
	 *            The skill
	 */
	public void setSkill(Skill skill)
	{
		this.skill = skill;
	}

	public Skills withSkill(Skill skill)
	{
		this.skill = skill;
		return this;
	}

	@Override
	public String toString()
	{
		return "Skills [comment=" + comment + ", level=" + level + ", skill="
				+ skill + "]";
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(comment).append(level)
				.append(skill).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) { return true; }
		if ((other instanceof Skills) == false) { return false; }
		Skills rhs = ((Skills) other);
		return new EqualsBuilder().append(comment, rhs.comment)
				.append(level, rhs.level).append(skill, rhs.skill).isEquals();
	}

}
