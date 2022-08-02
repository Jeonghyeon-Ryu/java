package prac2;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Module {
	private String name;
	private String description;
	private String url;
	private List<String> keywords = null;
	private String license;
	private String dateCreated;
	private String dateModified;
	private String datePublished;
	private Creator creator;
	private List<Distribution> distribution = null;
	private String context;
	private String type;

	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public String getDescription() {
	return description;
	}

	public void setDescription(String description) {
	this.description = description;
	}

	public String getUrl() {
	return url;
	}

	public void setUrl(String url) {
	this.url = url;
	}

	public List<String> getKeywords() {
	return keywords;
	}

	public void setKeywords(List<String> keywords) {
	this.keywords = keywords;
	}

	public String getLicense() {
	return license;
	}

	public void setLicense(String license) {
	this.license = license;
	}

	public String getDateCreated() {
	return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
	this.dateCreated = dateCreated;
	}

	public String getDateModified() {
	return dateModified;
	}

	public void setDateModified(String dateModified) {
	this.dateModified = dateModified;
	}

	public String getDatePublished() {
	return datePublished;
	}

	public void setDatePublished(String datePublished) {
	this.datePublished = datePublished;
	}

	public Creator getCreator() {
	return creator;
	}

	public void setCreator(Creator creator) {
	this.creator = creator;
	}

	public List<Distribution> getDistribution() {
	return distribution;
	}

	public void setDistribution(List<Distribution> distribution) {
	this.distribution = distribution;
	}

	public String getContext() {
	return context;
	}

	public void setContext(String context) {
	this.context = context;
	}

	public String getType() {
	return type;
	}

	public void setType(String type) {
	this.type = type;
	}
}

@Generated("jsonschema2pojo")
class ContactPoint {

	private String contactType;
	private String telephone;
	private String type;

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

@Generated("jsonschema2pojo")
class Creator {

	private String name;
	private ContactPoint contactPoint;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ContactPoint getContactPoint() {
		return contactPoint;
	}

	public void setContactPoint(ContactPoint contactPoint) {
		this.contactPoint = contactPoint;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

@Generated("jsonschema2pojo")
class Distribution {

	private String encodingFormat;
	private String contentUrl;
	private String type;

	public String getEncodingFormat() {
		return encodingFormat;
	}

	public void setEncodingFormat(String encodingFormat) {
		this.encodingFormat = encodingFormat;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

