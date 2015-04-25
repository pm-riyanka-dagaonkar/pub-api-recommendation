package com.pubmatic.bean;

import parser.Constants;

import com.pubmatic.interfaces.Similar;

public class Cpm implements Similar{
	
	Double cpm;

	public Double getCpm() {
		return cpm;
	}

	public void setCpm(Double cpm) {
		this.cpm = cpm;
	}

	@Override
	public long getSimilarPercent(Object o) {
		if(null == o || !(o instanceof Cpm))
			return 0;
		Cpm obj2=(Cpm) o;
		long similarityPercentage=0;
		Double diff=Math.abs(this.cpm-obj2.cpm);
		if(diff <= Constants.CPM_THRESHOLD)
		{
			similarityPercentage=100;
		}
		
		return similarityPercentage;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpm == null) ? 0 : cpm.hashCode());
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
		Cpm other = (Cpm) obj;
		if (cpm == null) {
			if (other.cpm != null)
				return false;
		} else if (!cpm.equals(other.cpm))
			return false;
		return true;
	}

}
