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
public class Offer implements Similar{

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
		if(null == o || !(o instanceof Offer))
			return 0;
		long similarityPercentage=0;
		Offer offer2 = (Offer) o;
		long cpmSimilarity=cpm.getSimilarPercent(offer2.getCpm());
		long categorySimilarity=categories.getSimilarPercent(offer2.getCategories());
		long adCodeTypeSimilarity=adCodeTypes.getSimilarPercent(offer2.getAdCodeTypes());
		long sitesSimilarity=sites.getSimilarPercent(offer2.getSites());
		long adTagsSimilarity=adTags.getSimilarPercent(offer2.getAdTags());
		long platformsSimilarity=platforms.getSimilarPercent(offer2.getPlatforms());
		long geosSimilarity=geos.getSimilarPercent(offer2.getGeos());
		
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
	
	
}
