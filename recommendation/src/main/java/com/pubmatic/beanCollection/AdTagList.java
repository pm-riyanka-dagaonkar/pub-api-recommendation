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
	
	@Override
	public long getSimilarPercent(Object o) {
		if(null == o || !(o instanceof AdTagList))
			return 0;
		int similarityPercentage=0;
		int sizeBase = this.adTags.size();
		int equalCount = 0;
		AdTagList list2 = (AdTagList) o;
		Set<AdTag> list2AdTags = new HashSet<AdTag>();
		list2AdTags.addAll((Collection<? extends AdTag>) list2);
				
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