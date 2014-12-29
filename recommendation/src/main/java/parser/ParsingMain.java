package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParsingMain {

	public static void main(String[] args) {
		ParsingMain mainObj=new ParsingMain();
		String dirName="/home/pubmatic/Documents/work/IDPhase2/recommendation/logs";
		mainObj.parseDirectory(dirName);

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
				if(data.contains(Constants.OFFER_SEARCH_URL))
				{
					System.out.println("Found search url "+data);
					URL url = new URL(data);
					splitQueryUrl(url);
				}
			}
			reader.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void splitQueryUrl(URL url) throws UnsupportedEncodingException {
	    Map<String, List<String>> queryPairsMap = new HashMap<String, List<String>>();
	    String query = url.getQuery();
	    String filterKey;
	    String filterValue;
	    List<String> tempValueList;
	    String[] pairs = query.split("&");
	    for (String pair : pairs) {
	        int idx = pair.indexOf("=");
	        filterKey=URLDecoder.decode(pair.substring(0, idx), "UTF-8");
	        filterValue=URLDecoder.decode(pair.substring(idx + 1), "UTF-8");
	        if(!(filterKey.equals(Constants.PUBLISHER_IDS) || 
	        		filterKey.equals(Constants.FILTERS)))
	        	continue;
	        if(queryPairsMap.containsKey(filterKey))
	        {
	        	tempValueList=queryPairsMap.get(filterKey);
	        	tempValueList.add(filterValue);
	        	queryPairsMap.put(filterKey, tempValueList);
	        }
	        else
	        {
	        	tempValueList=new ArrayList<String>();
	        	tempValueList.add(filterValue);
	        	queryPairsMap.put(filterKey, tempValueList);
	        }
	    }
	    System.out.println("----------------");
	    System.out.println(queryPairsMap);
	}
	
	private SearchParam createSearchParam(String filterKey, String filterValues)
	{
		SearchParam searchParamObject=new SearchParam();
		return searchParamObject;
	}
	

}
