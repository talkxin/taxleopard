package com.org.entity;

/**
 * PeoPersonalPage entity. @author MyEclipse Persistence Tools
 */

public class PeoPersonalPage implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String moduleName;
	private String imageUrl;
	private String smallImages;
	private Integer isOpen;
	private String openUrl;
	private String closeUrl;
    private String introduce;
	// Constructors

	/** default constructor */
	public PeoPersonalPage() {
	}

	/** minimal constructor */
	public PeoPersonalPage(Integer pid) {
		this.pid = pid;
	}

	/** full constructor */
	public PeoPersonalPage(Integer pid, String moduleName, String imageUrl,
			String smallImages, Integer isOpen, String openUrl, String closeUrl,String intrdoce) {
		this.pid = pid;
		this.moduleName = moduleName;
		this.imageUrl = imageUrl;
		this.smallImages = smallImages;
		this.isOpen = isOpen;
		this.openUrl = openUrl;
		this.closeUrl = closeUrl;
		this.introduce=intrdoce;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSmallImages() {
		return this.smallImages;
	}

	public void setSmallImages(String smallImages) {
		this.smallImages = smallImages;
	}

	public Integer getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}

	public String getOpenUrl() {
		return this.openUrl;
	}

	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}

	public String getCloseUrl() {
		return this.closeUrl;
	}

	public void setCloseUrl(String closeUrl) {
		this.closeUrl = closeUrl;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
    
}