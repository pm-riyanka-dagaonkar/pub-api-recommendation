package com.pubmatic.beanCollection;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import parser.Constants;

import com.pubmatic.bean.AdTag;
import com.pubmatic.interfaces.Similar;

public class AdTagList implements Similar{

	private List<AdTag> adTags;
	
	public List<AdTag> getAdTags() {
		return adTags;
	}

	public void setAdTags(List<AdTag> adTags) {
		this.adTags = adTags;
	}

	@Override
	public long getSimilarPercent(Object o) {
		if(null == o || !(o instanceof AdTagList) || adTags == null)
			return 0;
		int similarityPercentage=0;
		int sizeBase = this.adTags.size();
		int equalCount = 0;
		AdTagList list2 = (AdTagList) o;
		if(list2.getAdTags() == null)
			return 0;
		Set<AdTag> list2AdTags = new HashSet<AdTag>();
		list2AdTags.addAll((Collection<? extends AdTag>) list2.getAdTags());
				
		for(AdTag adTag : this.adTags)
		{
			if(list2AdTags.contains(adTag))
			{
				equalCount++;
			}
		}
		
		similarityPercentage=((sizeBase-equalCount)/sizeBase)*100;
		return similarityPercentage;
	}

}
