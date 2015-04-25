package com.pubmatic.beanCollection;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pubmatic.bean.AdCodeType;
import com.pubmatic.bean.AdTag;
import com.pubmatic.interfaces.Similar;

public class AdCodeTypeList implements Similar{

	private List<AdCodeType> adCodeTypes;
	
	public List<AdCodeType> getAdCodeTypes() {
		return adCodeTypes;
	}

	public void setAdCodeTypes(List<AdCodeType> adCodeTypes) {
		this.adCodeTypes = adCodeTypes;
	}

	@Override
	public long getSimilarPercent(Object o) {
		if(null == o || !(o instanceof AdCodeTypeList))
			return 0;
		AdCodeTypeList list2 = (AdCodeTypeList) o;
		
		if((list2.adCodeTypes == null || list2.adCodeTypes.isEmpty()))
		{
			if(this.adCodeTypes == null|| this.adCodeTypes.isEmpty())
				return 100;
			else
				return 0;
		} 
		else
		{
			if(this.adCodeTypes == null || this.adCodeTypes.isEmpty())
				return 0;
		}
		
		int similarityPercentage=0;
		int sizeBase = this.adCodeTypes.size();
		int equalCount = 0;
		
		Set<AdCodeType> list2AdCodeTypes = new HashSet<AdCodeType>();
		list2AdCodeTypes.addAll((Collection<? extends AdCodeType>) list2.getAdCodeTypes());
				
		for(AdCodeType adCodeType : this.adCodeTypes)
		{
			if(list2AdCodeTypes.contains(adCodeType))
			{
				equalCount++;
			}
		}
		
		similarityPercentage=(equalCount/sizeBase)*100;
		return similarityPercentage;
	}

}
