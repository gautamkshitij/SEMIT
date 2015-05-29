package uic.semit.Project.ProjectData;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Tool
{

	private String label;
	private String mountPoint;
	private String name;
	private long sourceforgeGroupId;

	public Tool(String label, String mountPoint, String name,
			long sourceforgeGroupId)
	{

		this.label = label;
		this.mountPoint = mountPoint;
		this.name = name;
		this.sourceforgeGroupId = sourceforgeGroupId;
	}

	/**
	 * 
	 * @return The label
	 */
	public String getLabel()
	{
		return label;
	}

	/**
	 * 
	 * @param label
	 *            The label
	 */
	public void setLabel(String label)
	{
		this.label = label;
	}

	public Tool withLabel(String label)
	{
		this.label = label;
		return this;
	}

	/**
	 * 
	 * @return The mountPoint
	 */
	public String getMountPoint()
	{
		return mountPoint;
	}

	/**
	 * 
	 * @param mountPoint
	 *            The mount_point
	 */
	public void setMountPoint(String mountPoint)
	{
		this.mountPoint = mountPoint;
	}

	public Tool withMountPoint(String mountPoint)
	{
		this.mountPoint = mountPoint;
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

	public Tool withName(String name)
	{
		this.name = name;
		return this;
	}

	/**
	 * 
	 * @return The sourceforgeGroupId
	 */
	public long getSourceforgeGroupId()
	{
		return sourceforgeGroupId;
	}

	/**
	 * 
	 * @param sourceforgeGroupId
	 *            The sourceforge_group_id
	 */
	public void setSourceforgeGroupId(long sourceforgeGroupId)
	{
		this.sourceforgeGroupId = sourceforgeGroupId;
	}

	public Tool withSourceforgeGroupId(long sourceforgeGroupId)
	{
		this.sourceforgeGroupId = sourceforgeGroupId;
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
		return new HashCodeBuilder().append(label).append(mountPoint)
				.append(name).append(sourceforgeGroupId).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) { return true; }
		if ((other instanceof Tool) == false) { return false; }
		Tool rhs = ((Tool) other);
		return new EqualsBuilder().append(label, rhs.label)
				.append(mountPoint, rhs.mountPoint).append(name, rhs.name)
				.append(sourceforgeGroupId, rhs.sourceforgeGroupId)

				.isEquals();
	}

}
