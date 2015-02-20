package com.pubmatic.beanCollection;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pubmatic.bean.Platform;
import com.pubmatic.interfaces.Similar;

public class PlatformList implements Similar{

	List<Platform> platfroms;
	
	@Override
	public long getSimilarPercent(Object o) {
		if(null == o || !(o instanceof PlatformList))
			return 0;
		int similarityPercentage=0;
		int sizeBase = this.platfroms.size();
		int equalCount = 0;
		PlatformList list2 = (PlatformList) o;
		Set<Platform> list2platforms = new HashSet<Platform>();
		list2platforms.addAll((Collection<? extends Platform>) list2);
				
		for(Platform platform : this.platfroms)
		{
			if(list2platforms.contains(platform))
			{
				equalCount++;
			}
		}
		
		similarityPercentage=((sizeBase-equalCount)/sizeBase)*100;
		return similarityPercentage;
	}

}
