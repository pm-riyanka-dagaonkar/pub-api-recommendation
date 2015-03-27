package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.pubmatic.bean.Offer;
import com.pubmatic.bean.SimilarOffer;
import com.pubmatic.bean.User;

public class RecommendationService {
	
	/**
	 * Method to get recommended offers for a user
	 * @param user
	 * @return
	 */
	public List<SimilarOffer> getRecommendedOffers(User user )
	{
		//API call to get relevant offer objects from graph DB for the input user
		//size should not exceed 10
		Set<Offer> relevantOffers = null;
		
		//API call to get offers data set from graph DB for the input user
		//size should not exceed 100
		Set<Offer> firstLevelOffers = null;
		
		 List<SimilarOffer> result=getSimilarOffers(relevantOffers, firstLevelOffers);
		
		return result;
		
	}
	
	public List<SimilarOffer> getSimilarOffers(Set<Offer> relevantOffers,
			Set<Offer> firstLevelOffers)
	{
		if(relevantOffers.size() ==0 || firstLevelOffers.size() ==0)
		{
			//if the user is new, the relevant offers history may be empty
			//if there is no first level recommendation from the graph
			System.out.println("No relevant offers found for the user");
			//show the top selling offers
			//API call to get the highest transacted upon offers
		}
		
		Map<Offer,Long> similarOffers= new HashMap<Offer, Long>();
		for(Offer relevantOffer : relevantOffers)
		{
			long similarityPer;
			for(Offer existing : firstLevelOffers)
			{
				if(!relevantOffer.getId().equals(existing.getId()))
				{
					similarityPer=relevantOffer.getSimilarPercent(existing);
					similarOffers.put(existing,similarityPer);
				}
			}
		}
		List<Entry<Offer,Long>> recommendedList=sortmap(similarOffers);
		List<SimilarOffer> result = new ArrayList<SimilarOffer>();
		for(Entry<Offer,Long> e: recommendedList)
		{
			SimilarOffer s=new SimilarOffer();
			s.setOffer(e.getKey());
			s.setSimilarityPrecentage(e.getValue());
			result.add(s);
		}
		return result;
	}
	
	private List<Entry<Offer,Long>> sortmap(Map<Offer,Long> input)
	{		
		Set<Entry<Offer,Long>> set = input.entrySet();
        List<Entry<Offer,Long>> list = new ArrayList<Entry<Offer,Long>>(set);
        Collections.sort( list, new Comparator<Map.Entry<Offer,Long>>()
        {
			@Override
			public int compare(Entry<Offer, Long> arg0, Entry<Offer, Long> arg1) {
				return (arg1.getValue()).compareTo( arg0.getValue() );
			}
        } );
        System.out.println("sorted");
        for(Map.Entry<Offer,Long> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }		
		return list;
	}
	
	public static void main(String[] args) {
		RecommendationService service = new RecommendationService();
		
	}
	
		
	      
	  
}
