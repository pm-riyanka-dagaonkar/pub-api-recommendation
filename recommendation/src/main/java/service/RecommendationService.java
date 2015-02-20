package service;

import java.util.List;
import java.util.Set;

import com.pubmatic.bean.Offer;
import com.pubmatic.bean.User;

public class RecommendationService {
	
	/**
	 * Method to get recommended offers for a user
	 * @param user
	 * @return
	 */
	public List<Offer> getRecommendedOffers(User user )
	{
		//API call to get relevant offer objects from graph DB for the input user
		Set<Offer> relevantOffers = null;
		
		//API call to get offers data set from graph DB for the input user
		Set<Offer> firstLevelOffers = null;
		
		getSimilarOffers(relevantOffers, firstLevelOffers);
		
		return null;
		
	}
	
	public void getSimilarOffers(Set<Offer> relevantOffers,
			Set<Offer> firstLevelOffers)
	{
		//if the user is new, the relevant offers history may be empty
		
	}

}
