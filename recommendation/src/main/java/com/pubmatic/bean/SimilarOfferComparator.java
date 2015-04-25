package com.pubmatic.bean;

import java.util.Comparator;

public class SimilarOfferComparator implements Comparator<SimilarOffer>{

	@Override
	public int compare(SimilarOffer o1, SimilarOffer o2) {
		if(o1.getSimilarityPrecentage() > o2.getSimilarityPrecentage())
			return -1;
		if(o1.getSimilarityPrecentage() < o2.getSimilarityPrecentage())
			return 1;
		return 0;
	}

}
