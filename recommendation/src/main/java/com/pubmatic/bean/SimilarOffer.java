package com.pubmatic.bean;

public class SimilarOffer{
	private long similarityPrecentage;
	private RecoOffer offer;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offer == null) ? 0 : offer.hashCode());
		result = prime * result
				+ (int) (similarityPrecentage ^ (similarityPrecentage >>> 32));
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
		SimilarOffer other = (SimilarOffer) obj;
		if (offer == null) {
			if (other.offer != null)
				return false;
		} else if (!offer.equals(other.offer))
			return false;
		if (similarityPrecentage != other.similarityPrecentage)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimilarOffer [similarityPrecentage=" + similarityPrecentage
				+ ", offer=" + offer.getId() + "]";
	}

	public RecoOffer getOffer() {
		return offer;
	}

	public void setOffer(RecoOffer offer) {
		this.offer = offer;
	}

	public long getSimilarityPrecentage() {
		return similarityPrecentage;
	}

	public void setSimilarityPrecentage(long similarityPrecentage) {
		this.similarityPrecentage = similarityPrecentage;
	}
	

}
