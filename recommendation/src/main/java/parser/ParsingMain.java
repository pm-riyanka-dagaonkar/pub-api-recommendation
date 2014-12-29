package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;


public class ParsingMain {
	
	private Map<SearchParam,Integer> searchCountMap = new HashMap<SearchParam, Integer>();

	public static void main(String[] args) {
		ParsingMain mainObj=new ParsingMain();
		String dirName="/home/pubmatic/Documents/work/IDPhase2/recommendation/logs";
		mainObj.parseDirectory(dirName);
		
		/*String value=getValueFromCriteria("productCategoryId eq 1", "eq");
		System.out.println(value);*/
		
	}
	
	private void parseDirectory(String dirName)
	{
		File dir=new File(dirName);
		if(dir.isDirectory())
		{
			String[] files=dir.list();
			for(String fileName : files)
			{
				if(!(fileName.startsWith("catalina") && fileName.endsWith("log")))
					continue;
				parseFile(dir.getAbsolutePath()+File.separator+fileName);
			}
		}
		System.out.println(searchCountMap);
	}
	private void parseFile(String fileName)
	{
		File fileObj=new File(fileName);
		if(!fileObj.isFile())
			return;
		
		System.out.println("Reading file "+fileName);
		try {
			BufferedReader reader=new BufferedReader(new FileReader(fileObj));
			String data=null;
			while((data=reader.readLine())!=null)
			{
				if(data.contains(Constants.OFFER_SEARCH_URL)
						|| data.contains(Constants.OFFER_SEARCH_URL_2))
				{
					if(data.startsWith(Constants.ADDRESS))
					{
						data=data.substring(9).trim();
					}
					System.out.println("Found search url "+data);
					URL url = new URL(data);
					splitQueryUrl(url);
				}
			}
			reader.close();
			System.out.println("----------------");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void splitQueryUrl(URL url) throws UnsupportedEncodingException {
	    
	    String query = url.getQuery();
	    String filterKey;
	    String filterValue;
	    String[] pairs = query.split("&");
	    SearchParam object=new SearchParam();
	    for (String pair : pairs) {
	        int idx = pair.indexOf("=");
	        filterKey=URLDecoder.decode(pair.substring(0, idx), "UTF-8");
	        filterValue=URLDecoder.decode(pair.substring(idx + 1), "UTF-8");
	       
	        if(filterKey.equals(Constants.PUBLISHER_IDS))
	        {
	        	updateSearchParamWithPublisherId(filterKey, filterValue, object);
	        	/*System.out.println("key "+filterKey);
		        System.out.println("values "+filterValue);*/
	        }
	        else if(filterKey.equals(Constants.FILTERS))
	        {
	        	/*System.out.println("key "+filterKey);
		        System.out.println("values "+filterValue);*/
		        updateSearchParamWithFilters(filterKey, filterValue, object);
	        }
	        
	    }
	    if(searchCountMap.containsKey(object))
	    {
	    	int count=searchCountMap.get(object);
	    	searchCountMap.put(object, count+1);
	    }
	    else
	    	searchCountMap.put(object, 1);

	    
	}
	
	private void updateSearchParamWithPublisherId(String filterKey, String filterValues,
			SearchParam searchParamObject)
	{
		if(!filterKey.equals(Constants.PUBLISHER_IDS))
			return;
		String pubs=searchParamObject.getPublishers();
		if(pubs!=null)
			searchParamObject.setPublishers(pubs+","+filterValues);
		else
			searchParamObject.setPublishers(filterValues);
	}
	
	private void updateSearchParamWithFilters(String filterKey, String filterValues,
			SearchParam searchParamObject)
	{
		if(!filterKey.equals(Constants.FILTERS))
			return;
		
		String value;
		//string like "name like *test*,description like *test*,tags like *test*"
		if(filterValues.startsWith(Constants.NAME))
		{
			String[] params=filterValues.split(",");
			for(String param : params)
			{
				if(param.startsWith(Constants.NAME))
				{
					value=getValueFromCriteria(param, Constants.LIKE);
					searchParamObject.setName(value);
				}
				else if(param.startsWith(Constants.DESCRIPTION))
				{
					value=getValueFromCriteria(param, Constants.LIKE);
					searchParamObject.setDescription(value);
				}
				else if(param.startsWith(Constants.TAGS))
				{
					value=getValueFromCriteria(param, Constants.LIKE);
					searchParamObject.setTags(value);
				}
			}
		}
		//string like "productCategoryId eq 1,productCategoryId eq 2"
		else if(filterValues.startsWith(Constants.PRODUCT_CATEGORY))
		{
			String[] params=filterValues.split(",");
			for(String param : params)
			{
				value=getValueFromCriteria(param, Constants.EQ);
				String temp=searchParamObject.getCategories();
				if(temp!=null)
					searchParamObject.setCategories(temp+","+value);
				else
					searchParamObject.setCategories(value);
			}
		}
		//string like "platFormIds eq 1"
		else if(filterValues.startsWith(Constants.PLATFORMS))
		{
			String[] params=filterValues.split(",");
			for(String param : params)
			{
				value=getValueFromCriteria(param, Constants.EQ);
				String temp=searchParamObject.getPlatforms();
				if(temp!=null)
					searchParamObject.setPlatforms(temp+","+value);
				else
					searchParamObject.setPlatforms(value);
			}
		}
	}
	private static String getValueFromCriteria(String criteria,String operator)
	{
		String value="";
		int index=criteria.indexOf(operator);
		if(index != -1)
		{
			if(operator.equals(Constants.LIKE))
			{
				value=criteria.substring(index+4, criteria.length()).trim();
			}
			else if(operator.equals(Constants.EQ))
			{
				value=criteria.substring(index+2, criteria.length()).trim();
			}
		}
		return value;
	}

}
