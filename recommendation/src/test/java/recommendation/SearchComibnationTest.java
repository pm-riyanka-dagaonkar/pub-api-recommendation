package recommendation;

import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import parser.SearchParam;
import parser.SearchParamCount;
import service.SearchCombinationService;

/**
 * Unit test for simple App.
 */
public class SearchComibnationTest
{
	private static SearchCombinationService searchCombinationService;

	@BeforeClass
	public static void setup(){
		searchCombinationService = new SearchCombinationService();
	}

	/*@AfterClass
	public void tearDown()
	{
		searchCombinationService=null;
	}*/
	
	@Test
	public void testGetAllSearches() 
	{
		List<SearchParamCount> records = searchCombinationService.getAllSearches();
		Assert.assertNotNull(records);
		for (SearchParamCount record : records) 
		{
			System.out.println(record);
		}
	}

	@Test
	public void testInsertSearchCombination() 
	{
		Calendar cal = Calendar.getInstance();
        Long milliSeconds = cal.getTimeInMillis();
		SearchParamCount insertObject = new SearchParamCount();
		SearchParam obj=new SearchParam();
		obj.setCategories("1,2,3");
		obj.setPlatforms("4,5,6");
		obj.setPublishers("7,8,9");
		obj.setTags("christmas");
		obj.setId(milliSeconds);
		insertObject.setSearchParam(obj);
		insertObject.setCount(5);
		

		searchCombinationService.insertSearchCombination(insertObject);
		
		SearchParamCount createdRecord =searchCombinationService.getRecordById
				(insertObject.getSearchParam().getId());
		Assert.assertNotNull(createdRecord);
		Assert.assertEquals(createdRecord.getCount(), insertObject.getCount());
		Assert.assertEquals(createdRecord.getSearchParam().getCategories(),obj.getCategories());
		Assert.assertEquals(createdRecord.getSearchParam().getPublishers(),obj.getPublishers());
		Assert.assertEquals(createdRecord.getSearchParam().getPlatforms(),obj.getPlatforms());
		Assert.assertEquals(createdRecord.getSearchParam().getTags(),obj.getTags());

	}
}
