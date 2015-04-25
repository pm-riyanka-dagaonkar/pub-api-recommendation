package com.pubmatic.bean;

import parser.Constants;

import com.pubmatic.beanCollection.AdCodeTypeList;
import com.pubmatic.beanCollection.AdTagList;
import com.pubmatic.beanCollection.CategoryList;
import com.pubmatic.beanCollection.GeoList;
import com.pubmatic.beanCollection.PlatformList;
import com.pubmatic.beanCollection.SiteList;
import com.pubmatic.interfaces.Similar;

/**
 * Bean to hold offer
 * @author Riyanka Dagaonkar
 *
 */
public class RecoOffer implements Similar{

	private Long id;
	private Cpm cpm;
	private CategoryList categories;
	private AdCodeTypeList adCodeTypes;
	private SiteList sites;
	private AdTagList adTags;
	private PlatformList platforms;
	private GeoList geos;
	
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
	/*	return "RecoOffer [id=" + id + ", cpm=" + cpm + ", categories="
				+ categories + ", adCodeTypes=" + adCodeTypes + ", sites="
				+ sites + ", adTags=" + adTags + ", platforms=" + platforms
				+ ", geos=" + geos + "]";
	*/	return "RecoOffer [id=" + id +"]";
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CategoryList getCategories() {
		return categories;
	}
	public void setCategories(CategoryList categories) {
		this.categories = categories;
	}
	public AdCodeTypeList getAdCodeTypes() {
		return adCodeTypes;
	}
	public void setAdCodeTypes(AdCodeTypeList adCodeTypes) {
		this.adCodeTypes = adCodeTypes;
	}
	public SiteList getSites() {
		return sites;
	}
	public void setSites(SiteList sites) {
		this.sites = sites;
	}
	public AdTagList getAdTags() {
		return adTags;
	}
	public void setAdTags(AdTagList adTags) {
		this.adTags = adTags;
	}
	public PlatformList getPlatforms() {
		return platforms;
	}
	public void setPlatforms(PlatformList platforms) {
		this.platforms = platforms;
	}
	public GeoList getGeos() {
		return geos;
	}
	public void setGeos(GeoList geos) {
		this.geos = geos;
	}
	public Cpm getCpm() {
		return cpm;
	}
	public void setCpm(Cpm cpm) {
		this.cpm = cpm;
	}
	
	@Override
	public long getSimilarPercent(Object o) {
		if(null == o || !(o instanceof RecoOffer))
			return 0;
		long similarityPercentage=0;
		RecoOffer offer2 = (RecoOffer) o;
		long cpmSimilarity =0;
		long categorySimilarity=0;
		long adCodeTypeSimilarity=0;
		long sitesSimilarity=0;
		long adTagsSimilarity=0;
		long platformsSimilarity=0;
		long geosSimilarity=0;
		
		
		if(cpm !=null && offer2.getCpm()!= null)
			cpmSimilarity=cpm.getSimilarPercent(offer2.getCpm());
		if(categories !=null && offer2.getCategories()!= null)
			categorySimilarity=categories.getSimilarPercent(offer2.getCategories());
		if(adCodeTypes !=null && offer2.getAdCodeTypes()!= null)
			adCodeTypeSimilarity=adCodeTypes.getSimilarPercent(offer2.getAdCodeTypes());
		if(sites !=null && offer2.getCpm()!= null)
			sitesSimilarity=sites.getSimilarPercent(offer2.getSites());
		if(adTags !=null && offer2.getAdTags()!= null)
			adTagsSimilarity=adTags.getSimilarPercent(offer2.getAdTags());
		if(platforms !=null && offer2.getPlatforms()!= null)
			platformsSimilarity=platforms.getSimilarPercent(offer2.getPlatforms());
		if(geos !=null && offer2.getGeos()!= null)
			geosSimilarity=geos.getSimilarPercent(offer2.getGeos());
		
		long summation = Constants.WEIGHT_CPM * cpmSimilarity + 
				Constants.WEIGHT_CATEGORIES * categorySimilarity +
				Constants.WEIGHT_ADCODETYPES * adCodeTypeSimilarity +
				Constants.WEIGHT_SITES * sitesSimilarity +
				Constants.WEIGHT_ADTAGS * adTagsSimilarity +
				Constants.WEIGHT_PLATFORMS * platformsSimilarity +
				Constants.WEIGHT_GEOS * geosSimilarity ;
		
		long sumOfWeights = Constants.WEIGHT_CPM+
				Constants.WEIGHT_CATEGORIES+
				Constants.WEIGHT_ADCODETYPES+
				Constants.WEIGHT_SITES+
				Constants.WEIGHT_ADTAGS+
				Constants.WEIGHT_PLATFORMS+
				Constants.WEIGHT_GEOS;
		
		long result= summation / sumOfWeights;
		similarityPercentage = result;					
		
		return similarityPercentage;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((adCodeTypes == null) ? 0 : adCodeTypes.hashCode());
		result = prime * result + ((adTags == null) ? 0 : adTags.hashCode());
		result = prime * result
				+ ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((cpm == null) ? 0 : cpm.hashCode());
		result = prime * result + ((geos == null) ? 0 : geos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((platforms == null) ? 0 : platforms.hashCode());
		result = prime * result + ((sites == null) ? 0 : sites.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecoOffer other = (RecoOffer) obj;
		if (adCodeTypes == null) {
			if (other.adCodeTypes != null)
				return false;
		} else if (!adCodeTypes.equals(other.adCodeTypes))
			return false;
		if (adTags == null) {
			if (other.adTags != null)
				return false;
		} else if (!adTags.equals(other.adTags))
			return false;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (cpm == null) {
			if (other.cpm != null)
				return false;
		} else if (!cpm.equals(other.cpm))
			return false;
		if (geos == null) {
			if (other.geos != null)
				return false;
		} else if (!geos.equals(other.geos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (platforms == null) {
			if (other.platforms != null)
				return false;
		} else if (!platforms.equals(other.platforms))
			return false;
		if (sites == null) {
			if (other.sites != null)
				return false;
		} else if (!sites.equals(other.sites))
			return false;
		return true;
	}
}
