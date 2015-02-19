package com.pubmatic.bean;

import parser.Constants;

import com.pubmatic.interfaces.Similar;

public class Cpm implements Similar{
	
	long cpm;

	@Override
	public long getSimilarPercent(Object o) {
		if(null == o || !(o instanceof Cpm))
			return 0;
		Cpm obj2=(Cpm) o;
		long similarityPercentage=0;
		long diff=Math.abs(this.cpm-obj2.cpm);
		if(diff <= Constants.CPM_THRESHOLD)
		{
			similarityPercentage=100;
		}
		
		return similarityPercentage;
	}

}
