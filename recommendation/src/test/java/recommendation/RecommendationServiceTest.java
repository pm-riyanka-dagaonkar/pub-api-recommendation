package recommendation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import service.RecommendationService;

import com.pubmatic.bean.Cpm;
import com.pubmatic.bean.Offer;
import com.pubmatic.bean.SimilarOffer;

public class RecommendationServiceTest {
	
	private static String FILEPATH="/home/pubmatic/Documents/work/recommendation/testCases/dummyData"; 

	private static RecommendationService recommendsationService;

	@BeforeClass
	public static void setup(){
		recommendsationService = new RecommendationService();
	}
	@Test
	public void test() {
		Set<Offer> relevantOffers = new HashSet<Offer>();
		Set<Offer> firstLevelOffers = new HashSet<Offer>();
		
		List<SimilarOffer>result=recommendsationService.getSimilarOffers(relevantOffers, firstLevelOffers);
	}
	
	private List<Set<Offer>> generateDataFromFile(){
		try {
			BufferedReader br=new BufferedReader(new FileReader(new File(FILEPATH)));
			String data;
			Set<Offer> relevantOffers = new HashSet<Offer>();
			Set<Offer> firstLevelOffers = new HashSet<Offer>();
			List<Set<Offer>> result=new ArrayList<Set<Offer>>();
			Offer o;
			
			while((data=br.readLine())!=null)
			{
				String[] columns = data.split("\t");
				o = new Offer();
				o.setId(Long.parseLong(columns[1]));
				
				Cpm cpm = new Cpm();
				cpm.setCpm(Long.parseLong(columns[2]));
				
				
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Returns a list of Long by parsing a String of comma separated Ids
	 * @param data = comma separated Ids
	 * @return
	 */
	private List<Long> getIds(String data)
	{
		List<Long> result=new ArrayList<Long>();
		String[] splitted = data.split(",");
		for(int i=0;i<splitted.length;i++)
		{
			result.add(Long.parseLong(splitted[i]));
		}
		
		return result;
	}
	
	
	
}
