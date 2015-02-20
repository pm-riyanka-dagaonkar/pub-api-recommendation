package com.pubmatic.beanCollection;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pubmatic.bean.Site;
import com.pubmatic.interfaces.Similar;

public class SiteList implements Similar{

	List<Site> sites;
	
	@Override
	public long getSimilarPercent(Object o) {
		if(null == o || !(o instanceof SiteList))
			return 0;
		int similarityPercentage=0;
		int sizeBase = this.sites.size();
		int equalCount = 0;
		SiteList list2 = (SiteList) o;
		Set<Site> list2sites = new HashSet<Site>();
		list2sites.addAll((Collection<? extends Site>) list2);
				
		for(Site site : this.sites)
		{
			if(list2sites.contains(site))
			{
				equalCount++;
			}
		}
		
		similarityPercentage=((sizeBase-equalCount)/sizeBase)*100;
		return similarityPercentage;
	}

}
