package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.pubmatic.bean.RecoOffer;
import com.pubmatic.bean.SimilarOffer;
import com.pubmatic.bean.User;

@Service
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
		Set<RecoOffer> relevantOffers = null;
		{
//			offerService.search(arg0, arg1);
		}
		
		//API call to get offers data set from graph DB for the input user
		//size should not exceed 100
		Set<RecoOffer> firstLevelOffers = null;
		
		 List<SimilarOffer> result=getSimilarOffers(relevantOffers, firstLevelOffers);
		
		return result;
		
	}
	
	public List<SimilarOffer> getSimilarOffers(Set<RecoOffer> relevantOffers,
			Set<RecoOffer> firstLevelOffers)
	{
		if(relevantOffers.size() ==0 || firstLevelOffers.size() ==0)
		{
			//if the user is new, the relevant offers history may be empty
			//if there is no first level recommendation from the graph
			System.out.println("No relevant offers found for the user");
			//show the top selling offers
			//API call to get the highest transacted upon offers
		}
		if(relevantOffers.size() == 0)
		{
			System.out.println("User is new with no history");
			//logic to get offers from similar users.
			//populate relevantOffers from the user.
		}
		Map<RecoOffer,Long> similarOffers= new HashMap<RecoOffer, Long>();
		for(RecoOffer relevantOffer : relevantOffers)
		{
			long similarityPer;
			for(RecoOffer existing : firstLevelOffers)
			{
				if(!relevantOffer.getId().equals(existing.getId()))
				{
					similarityPer=relevantOffer.getSimilarPercent(existing);
					similarOffers.put(existing,similarityPer);
				}
			}
		}
		List<Entry<RecoOffer,Long>> recommendedList=sortmap(similarOffers);
		List<SimilarOffer> result = new ArrayList<SimilarOffer>();
		for(Entry<RecoOffer,Long> e: recommendedList)
		{
			SimilarOffer s=new SimilarOffer();
			s.setOffer(e.getKey());
			s.setSimilarityPrecentage(e.getValue());
			result.add(s);
		}
		return result;
	}
	
	private List<Entry<RecoOffer,Long>> sortmap(Map<RecoOffer,Long> input)
	{		
		Set<Entry<RecoOffer,Long>> set = input.entrySet();
        List<Entry<RecoOffer,Long>> list = new ArrayList<Entry<RecoOffer,Long>>(set);
        Collections.sort( list, new Comparator<Map.Entry<RecoOffer,Long>>()
        {
			@Override
			public int compare(Entry<RecoOffer, Long> arg0, Entry<RecoOffer, Long> arg1) {
				//sorting in descending order
				return (arg1.getValue()).compareTo( arg0.getValue() );
			}
        } );
        System.out.println("sorted");
        for(Map.Entry<RecoOffer,Long> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }		
		return list;
	}
	
	public String getMessage()
	{
		return "in the get call";
	}
	
	public void createSimilarityMatrix(Set<RecoOffer> input)
	{
		
	}
	  
}
