package parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DataAnalyser {
	
	public static void sortSearchQueryMap(Map<SearchParam,Integer> searchCountMap)
	{
		Set<Entry<SearchParam, Integer>> entries=searchCountMap.entrySet();
		List<SearchParamCount> listEntries=new ArrayList<SearchParamCount>();
		SearchParamCount countObj;
		for(Entry<SearchParam, Integer> entry:entries)
		{
			countObj=new SearchParamCount(entry.getKey(), entry.getValue());
			listEntries.add(countObj);
		}
		Collections.sort(listEntries, new SearchParamCount());
		System.out.println("---------------------------------------------");
		if(listEntries.size() <= Constants.TOP_N)
		{
			System.out.println("Top search combinations are - ");
			System.out.println(listEntries);
		}
		else
		{
			System.out.println("Top "+Constants.TOP_N+" search combinations are - ");
			for(int i=0;i<Constants.TOP_N;i++)
				System.out.println(listEntries.get(i));
		}
		
	}
	
	public static <T> void sortCriterionMap(Map<T, Integer> inputMap,String entity)
	{
		Set<Entry<T, Integer>> entries=inputMap.entrySet();
		List<SearchCriterionCount> listEntries=new ArrayList<SearchCriterionCount>();
		SearchCriterionCount countObj;
		for(Entry<T, Integer> entry:entries)
		{
			countObj=new SearchCriterionCount(entry.getKey(),entry.getValue());
			listEntries.add(countObj);
		}
		Collections.sort(listEntries, new SearchCriterionCount());
		System.out.println("---------------------------------------------");
		if(listEntries.size() <= Constants.TOP_N)
		{
			System.out.println("Top searches for "+entity+" are - ");
			System.out.println(listEntries);
		}
		else
		{
			System.out.println("Top "+Constants.TOP_N+" search for "+entity+" are - ");
			for(int i=0;i<Constants.TOP_N;i++)
				System.out.println(listEntries.get(i));
		}
	}


}
