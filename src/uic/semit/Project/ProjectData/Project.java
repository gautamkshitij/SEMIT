package uic.semit.Project.ProjectData;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import uic.semit.Project.SourceCode.CodeFile;

@Generated("org.jsonschema2pojo")
public class Project
{

	private String projectName; // project name from input file
	private String projectURL; // http://sourceforge.net/projects/[project-name]/
	private String projectrestAPIURL; // http://sourceforge.net/rest/p/[project-name]/
	private String Id;
	private String creationDate;
	private String externalHomepage;
	private String iconUrl;
	private String movedToUrl;
	private String name;
	private String preferredSupportTool;
	private String preferredSupportUrl;
	private boolean _private;
	private String shortDescription;
	private String shortname;
	private String status;
	private String summary;
	private String url;
	private String videoUrl;

	private List<CodeFile> codeFiles = new ArrayList<CodeFile>();

	private List<Developer> developers = new ArrayList<Developer>();
	private List<Tool> tools = new ArrayList<Tool>();
	private List<Screenshot> screenshots = new ArrayList<Screenshot>();
	private List<Socialnetwork> socialnetworks = new ArrayList<Socialnetwork>();
	private List<String> labels = new ArrayList<String>();
	private Categories categories;

	public Project(String projectName)
	{
		this.projectName = projectName;
		this.projectURL = "http://sourceforge.net/projects/" + projectName;
		this.projectrestAPIURL = "ttp://sourceforge.net/rest/p/" + projectName;

	}

	public List<CodeFile> getCodeFiles()
	{
		return codeFiles;
	}

	public void setCodeFiles(List<CodeFile> codeFiles)
	{
		this.codeFiles = codeFiles;
	}

	/**
	 * 
	 * @return The Id
	 */
	public String getId()
	{
		return Id;
	}

	/**
	 * 
	 * @param Id
	 *            The _id
	 */
	public void setId(String Id)
	{
		this.Id = Id;
	}

	public Project withId(String Id)
	{
		this.Id = Id;
		return this;
	}

	/**
	 * 
	 * @return The categories
	 */
	public Categories getCategories()
	{
		return categories;
	}

	/**
	 * 
	 * @param categories
	 *            The categories
	 */
	public void setCategories(Categories categories)
	{
		this.categories = categories;
	}

	public Project withCategories(Categories categories)
	{
		this.categories = categories;
		return this;
	}

	/**
	 * 
	 * @return The creationDate
	 */
	public String getCreationDate()
	{
		return creationDate;
	}

	/**
	 * 
	 * @param creationDate
	 *            The creation_date
	 */
	public void setCreationDate(String creationDate)
	{
		this.creationDate = creationDate;
	}

	public Project withCreationDate(String creationDate)
	{
		this.creationDate = creationDate;
		return this;
	}

	/**
	 * 
	 * @return The developers
	 */
	public List<Developer> getDevelopers()
	{
		return developers;
	}

	/**
	 * 
	 * @param developers
	 *            The developers
	 */
	public void setDevelopers(List<Developer> developers)
	{
		this.developers = developers;
	}

	public Project withDevelopers(List<Developer> developers)
	{
		this.developers = developers;
		return this;
	}

	/**
	 * 
	 * @return The externalHomepage
	 */
	public String getExternalHomepage()
	{
		return externalHomepage;
	}

	/**
	 * 
	 * @param externalHomepage
	 *            The external_homepage
	 */
	public void setExternalHomepage(String externalHomepage)
	{
		this.externalHomepage = externalHomepage;
	}

	public Project withExternalHomepage(String externalHomepage)
	{
		this.externalHomepage = externalHomepage;
		return this;
	}

	/**
	 * 
	 * @return The iconUrl
	 */
	public String getIconUrl()
	{
		return iconUrl;
	}

	/**
	 * 
	 * @param iconUrl
	 *            The icon_url
	 */
	public void setIconUrl(String iconUrl)
	{
		this.iconUrl = iconUrl;
	}

	public Project withIconUrl(String iconUrl)
	{
		this.iconUrl = iconUrl;
		return this;
	}

	/**
	 * 
	 * @return The labels
	 */
	public List<String> getLabels()
	{
		return labels;
	}

	/**
	 * 
	 * @param labels
	 *            The labels
	 */
	public void setLabels(List<String> labels)
	{
		this.labels = labels;
	}

	public Project withLabels(List<String> labels)
	{
		this.labels = labels;
		return this;
	}

	/**
	 * 
	 * @return The movedToUrl
	 */
	public String getMovedToUrl()
	{
		return movedToUrl;
	}

	/**
	 * 
	 * @param movedToUrl
	 *            The moved_to_url
	 */
	public void setMovedToUrl(String movedToUrl)
	{
		this.movedToUrl = movedToUrl;
	}

	public Project withMovedToUrl(String movedToUrl)
	{
		this.movedToUrl = movedToUrl;
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

	public Project withName(String name)
	{
		this.name = name;
		return this;
	}

	/**
	 * 
	 * @return The preferredSupportTool
	 */
	public String getPreferredSupportTool()
	{
		return preferredSupportTool;
	}

	/**
	 * 
	 * @param preferredSupportTool
	 *            The preferred_support_tool
	 */
	public void setPreferredSupportTool(String preferredSupportTool)
	{
		this.preferredSupportTool = preferredSupportTool;
	}

	public Project withPreferredSupportTool(String preferredSupportTool)
	{
		this.preferredSupportTool = preferredSupportTool;
		return this;
	}

	/**
	 * 
	 * @return The preferredSupportUrl
	 */
	public String getPreferredSupportUrl()
	{
		return preferredSupportUrl;
	}

	/**
	 * 
	 * @param preferredSupportUrl
	 *            The preferred_support_url
	 */
	public void setPreferredSupportUrl(String preferredSupportUrl)
	{
		this.preferredSupportUrl = preferredSupportUrl;
	}

	public Project withPreferredSupportUrl(String preferredSupportUrl)
	{
		this.preferredSupportUrl = preferredSupportUrl;
		return this;
	}

	/**
	 * 
	 * @return The _private
	 */
	public boolean isPrivate()
	{
		return _private;
	}

	/**
	 * 
	 * @param _private
	 *            The private
	 */
	public void setPrivate(boolean _private)
	{
		this._private = _private;
	}

	public Project withPrivate(boolean _private)
	{
		this._private = _private;
		return this;
	}

	/**
	 * 
	 * @return The screenshots
	 */
	public List<Screenshot> getScreenshots()
	{
		return screenshots;
	}

	/**
	 * 
	 * @param screenshots
	 *            The screenshots
	 */
	public void setScreenshots(List<Screenshot> screenshots)
	{
		this.screenshots = screenshots;
	}

	public Project withScreenshots(List<Screenshot> screenshots)
	{
		this.screenshots = screenshots;
		return this;
	}

	/**
	 * 
	 * @return The shortDescription
	 */
	public String getShortDescription()
	{
		return shortDescription;
	}

	/**
	 * 
	 * @param shortDescription
	 *            The short_description
	 */
	public void setShortDescription(String shortDescription)
	{
		this.shortDescription = shortDescription;
	}

	public Project withShortDescription(String shortDescription)
	{
		this.shortDescription = shortDescription;
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

	public Project withShortname(String shortname)
	{
		this.shortname = shortname;
		return this;
	}

	/**
	 * 
	 * @return The socialnetworks
	 */
	public List<Socialnetwork> getSocialnetworks()
	{
		return socialnetworks;
	}

	/**
	 * 
	 * @param socialnetworks
	 *            The socialnetworks
	 */
	public void setSocialnetworks(List<Socialnetwork> socialnetworks)
	{
		this.socialnetworks = socialnetworks;
	}

	public Project withSocialnetworks(List<Socialnetwork> socialnetworks)
	{
		this.socialnetworks = socialnetworks;
		return this;
	}

	/**
	 * 
	 * @return The status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * 
	 * @param status
	 *            The status
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	public Project withStatus(String status)
	{
		this.status = status;
		return this;
	}

	/**
	 * 
	 * @return The summary
	 */
	public String getSummary()
	{
		return summary;
	}

	/**
	 * 
	 * @param summary
	 *            The summary
	 */
	public void setSummary(String summary)
	{
		this.summary = summary;
	}

	public Project withSummary(String summary)
	{
		this.summary = summary;
		return this;
	}

	/**
	 * 
	 * @return The tools
	 */
	public List<Tool> getTools()
	{
		return tools;
	}

	/**
	 * 
	 * @param tools
	 *            The tools
	 */
	public void setTools(List<Tool> tools)
	{
		this.tools = tools;
	}

	public Project withTools(List<Tool> tools)
	{
		this.tools = tools;
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

	public Project withUrl(String url)
	{
		this.url = url;
		return this;
	}

	/**
	 * 
	 * @return The videoUrl
	 */
	public String getVideoUrl()
	{
		return videoUrl;
	}

	/**
	 * 
	 * @param videoUrl
	 *            The video_url
	 */
	public void setVideoUrl(String videoUrl)
	{
		this.videoUrl = videoUrl;
	}

	public Project withVideoUrl(String videoUrl)
	{
		this.videoUrl = videoUrl;
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
		return new HashCodeBuilder().append(Id).append(categories)
				.append(creationDate).append(developers)
				.append(externalHomepage).append(iconUrl).append(labels)
				.append(movedToUrl).append(name).append(preferredSupportTool)
				.append(preferredSupportUrl).append(_private)
				.append(screenshots).append(shortDescription).append(shortname)
				.append(socialnetworks).append(status).append(summary)
				.append(tools).append(url).append(videoUrl).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) { return true; }
		if ((other instanceof Project) == false) { return false; }
		Project rhs = ((Project) other);
		return new EqualsBuilder().append(Id, rhs.Id)
				.append(categories, rhs.categories)
				.append(creationDate, rhs.creationDate)
				.append(developers, rhs.developers)
				.append(externalHomepage, rhs.externalHomepage)
				.append(iconUrl, rhs.iconUrl).append(labels, rhs.labels)
				.append(movedToUrl, rhs.movedToUrl).append(name, rhs.name)
				.append(preferredSupportTool, rhs.preferredSupportTool)
				.append(preferredSupportUrl, rhs.preferredSupportUrl)
				.append(_private, rhs._private)
				.append(screenshots, rhs.screenshots)
				.append(shortDescription, rhs.shortDescription)
				.append(shortname, rhs.shortname)
				.append(socialnetworks, rhs.socialnetworks)
				.append(status, rhs.status).append(summary, rhs.summary)
				.append(tools, rhs.tools).append(url, rhs.url)
				.append(videoUrl, rhs.videoUrl)

				.isEquals();
	}

}
