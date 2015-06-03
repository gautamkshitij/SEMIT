package uic.semit.Project.ProjectData;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Screenshot
{

	private String caption;
	private String thumbnailUrl;
	private String url;

	public Screenshot(String caption, String thumbnailUrl, String url)
	{

		this.caption = caption;
		this.thumbnailUrl = thumbnailUrl;
		this.url = url;
	}

	/**
	 * 
	 * @return The caption
	 */
	public String getCaption()
	{
		return caption;
	}

	/**
	 * 
	 * @param caption
	 *            The caption
	 */
	public void setCaption(String caption)
	{
		this.caption = caption;
	}

	public Screenshot withCaption(String caption)
	{
		this.caption = caption;
		return this;
	}

	/**
	 * 
	 * @return The thumbnailUrl
	 */
	public String getThumbnailUrl()
	{
		return thumbnailUrl;
	}

	/**
	 * 
	 * @param thumbnailUrl
	 *            The thumbnail_url
	 */
	public void setThumbnailUrl(String thumbnailUrl)
	{
		this.thumbnailUrl = thumbnailUrl;
	}

	public Screenshot withThumbnailUrl(String thumbnailUrl)
	{
		this.thumbnailUrl = thumbnailUrl;
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

	public Screenshot withUrl(String url)
	{
		this.url = url;
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
		return new HashCodeBuilder().append(caption).append(thumbnailUrl)
				.append(url).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) { return true; }
		if ((other instanceof Screenshot) == false) { return false; }
		Screenshot rhs = ((Screenshot) other);
		return new EqualsBuilder().append(caption, rhs.caption)
				.append(thumbnailUrl, rhs.thumbnailUrl).append(url, rhs.url)

				.isEquals();
	}

}
