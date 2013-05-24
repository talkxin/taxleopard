package com.paychex.entity;

/**
 * IsCityToProvinceToNationId entity. @author MyEclipse Persistence Tools
 */

public class IsCityToProvinceToNation implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String citySortName;
	private String cityLangName;
	private Integer pid;
	private String provinceName;
	private Integer nid;
	private String nationSortName;
	private String nationLangName;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCitySortName() {
		return citySortName;
	}
	public void setCitySortName(String citySortName) {
		this.citySortName = citySortName;
	}
	public String getCityLangName() {
		return cityLangName;
	}
	public void setCityLangName(String cityLangName) {
		this.cityLangName = cityLangName;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getNationSortName() {
		return nationSortName;
	}
	public void setNationSortName(String nationSortName) {
		this.nationSortName = nationSortName;
	}
	public String getNationLangName() {
		return nationLangName;
	}
	public void setNationLangName(String nationLangName) {
		this.nationLangName = nationLangName;
	}

	
}