package com.pubmatic.beanCollection;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pubmatic.bean.Geo;
import com.pubmatic.interfaces.Similar;

public class GeoList implements Similar{
	
	List<Geo> geos;

	public List<Geo> getGeos() {
		return geos;
	}

	public void setGeos(List<Geo> geos) {
		this.geos = geos;
	}

	@Override
	public long getSimilarPercent(Object o) {
		if(null == o || !(o instanceof GeoList) || geos == null)
			return 0;
		int similarityPercentage=0;
		int sizeBase = this.geos.size();
		int equalCount = 0;
		GeoList list2 = (GeoList) o;
		if(list2.getGeos() == null)
			return 0;
		Set<Geo> list2Geos = new HashSet<Geo>();
		list2Geos.addAll((Collection<? extends Geo>) list2.getGeos());
				
		for(Geo geo : this.geos)
		{
			if(list2Geos.contains(geo))
			{
				equalCount++;
			}
		}
		
		similarityPercentage=((sizeBase-equalCount)/sizeBase)*100;
		return similarityPercentage;
	}

}
