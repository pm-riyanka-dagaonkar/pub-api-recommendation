package com.pubmatic.bean;

public class SimilarOffer{
	private long similarityPrecentage;
	private Offer offer;
	

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public long getSimilarityPrecentage() {
		return similarityPrecentage;
	}

	public void setSimilarityPrecentage(long similarityPrecentage) {
		this.similarityPrecentage = similarityPrecentage;
	}
	

}
