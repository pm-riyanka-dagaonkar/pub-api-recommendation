package recommendation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
	
	@Ignore
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
//		Calendar cal = Calendar.getInstance();
 //      Long milliSeconds = cal.getTimeInMillis();
		SearchParamCount insertObject = new SearchParamCount();
		SearchParam obj=new SearchParam();
		obj.setCategories("1,2,3");
		obj.setPlatforms("4,5,6");
		obj.setPublishers("7,8,9");
		obj.setTags("christmas");
//		obj.setId(milliSeconds);
		insertObject.setSearchParam(obj);
		insertObject.setCount(5);
		

		insertObject=searchCombinationService.insertSearchCombination(insertObject);
		
		SearchParamCount createdRecord =searchCombinationService.getRecordById
				(insertObject.getSearchParam().getId());
		Assert.assertNotNull(createdRecord);
		Assert.assertEquals(createdRecord.getCount(), insertObject.getCount());
		Assert.assertEquals(createdRecord.getSearchParam().getCategories(),obj.getCategories());
		Assert.assertEquals(createdRecord.getSearchParam().getPublishers(),obj.getPublishers());
		Assert.assertEquals(createdRecord.getSearchParam().getPlatforms(),obj.getPlatforms());
		Assert.assertEquals(createdRecord.getSearchParam().getTags(),obj.getTags());

	}
	
	@Ignore
	@Test
	public void testUrl()
	{
		//positive
		List<String> testStrings=new ArrayList<String>();
		testStrings.add("foo@demo.net");
		testStrings.add("bar.ba@test.co.uk");
		testStrings.add("www.demo.com");
		testStrings.add("http://foo.co.uk");
		testStrings.add("http://regexr.com/foo.html?q=bar");
		testStrings.add("https://foo.co.uk/");
		testStrings.add("https://regexr.com/foo.html?q=bar");
		testStrings.add("http://foo.co.uk/");
		testStrings.add("http://username:password@hostname.tld/path?arg=value#anchor");
		testStrings.add("http://www.domain.com/");
		testStrings.add("http://www.doamin.co.uk/");
		testStrings.add("http://www.yahoo.com/");
		testStrings.add("http://www.google.au/");
		testStrings.add("https://username:password@domain.com/");
		testStrings.add("ftp://user:password@domain.com/path/");
		testStrings.add("https://www.blah1.subdoamin.doamin.tld/");
		testStrings.add("domain.tld/#anchor");
		testStrings.add("doamin.tld/?query=123");
		testStrings.add("domain.co.uk/");
		testStrings.add("domain.tld");
		testStrings.add("http://www.domain.tld/index.php?var1=blah");
		testStrings.add("http://www.domain.tld/path/to/index.ext");
		testStrings.add("mailto://user@unkwndesign.com");
		testStrings.add("https://portal.wdf.sap.corp/irj/go/km/docs/guid/600840f6-2d2d-2e10-5bb7-##fca7779a24cc");
		
		
		testStrings.add("http://foo.com/blah_blah	");
		testStrings.add("http://foo.com/blah_blah/	");
		testStrings.add("http://foo.com/blah_blah_(wikipedia)	");
		testStrings.add("http://foo.com/blah_blah_(wikipedia)_(again)	");
		testStrings.add("http://www.example.com/wpstyle/?p=364	");
		testStrings.add("https://www.example.com/foo/?bar=baz&inga=42&quux	");
		testStrings.add("http://✪df.ws/123	");
		testStrings.add("http://userid:password@example.com:8080	");
		testStrings.add("http://userid:password@example.com:8080/	");
		testStrings.add("http://userid@example.com	");
		testStrings.add("http://userid@example.com/	");
		testStrings.add("http://userid@example.com:8080	");
		testStrings.add("http://userid@example.com:8080/	");
		testStrings.add("http://userid:password@example.com	");
		testStrings.add("http://userid:password@example.com/	");
		testStrings.add("http://142.42.1.1/	");
		testStrings.add("http://142.42.1.1:8080/	");
		testStrings.add("http://➡.ws/䨹	");
		testStrings.add("http://⌘.ws	");
		testStrings.add("http://⌘.ws/	");
		testStrings.add("http://foo.com/blah_(wikipedia)#cite-1	");
		testStrings.add("http://foo.com/blah_(wikipedia)_blah#cite-1	");
		testStrings.add("http://foo.com/unicode_(✪)_in_parens	");
		testStrings.add("http://foo.com/(something)?after=parens	");
		testStrings.add("http://☺.damowmow.com/	");
		testStrings.add("http://code.google.com/events/#&product=browser	");
		testStrings.add("http://j.mp	");
		testStrings.add("ftp://foo.bar/baz	");
		testStrings.add("http://foo.bar/?q=Test%20URL-encoded%20stuff	");
		testStrings.add("http://مثال.إختبار	");
		testStrings.add("http://例子.测试	");
		testStrings.add("http://उदाहरण.परीक्षा	");
		testStrings.add("http://-.~_!$&'()*+,;=:%40:80%2f::::::@example.com	");
		testStrings.add("http://1337.net	");
		testStrings.add("http://a.b-c.de	");
		testStrings.add("http://223.255.255.254	");
		testStrings.add("www.ebay.com/sports");
		testStrings.add("www.ebay.com");
		//invalid urls
		testStrings.add("sampleinvalidurl");
		testStrings.add("http://	");
		testStrings.add("http://.	");
		testStrings.add("http://..	");
		testStrings.add("http://../	");
		testStrings.add("http://?	");
		testStrings.add("http://??	");
		testStrings.add("http://??/	");
		testStrings.add("http://#	");
		testStrings.add("http://##	");
		testStrings.add("http://##/	");
		testStrings.add("http://foo.bar?q=Spaces should be encoded	");
		testStrings.add("//	");
		testStrings.add("//a	");
		testStrings.add("///a	");
		testStrings.add("///	");
		testStrings.add("http:///a	");
		testStrings.add("foo.com	");
		testStrings.add("rdar://1234	");
		testStrings.add("h://test	");
		testStrings.add("http:// shouldfail.com	");
		testStrings.add(":// should fail	");
		testStrings.add("http://foo.bar/foo(bar)baz quux	");
		testStrings.add("ftps://foo.bar/	");
		testStrings.add("http://-error-.invalid/	");
		testStrings.add("http://a.b--c.de/	");
		testStrings.add("http://-a.b.co	");
		testStrings.add("http://a.b-.co	");
		testStrings.add("http://0.0.0.0	");
		testStrings.add("http://10.1.1.0	");
		testStrings.add("http://10.1.1.255	");
		testStrings.add("http://224.1.1.1	");
		testStrings.add("http://1.1.1.1.1	");
		testStrings.add("http://123.123.123	");
		testStrings.add("http://3628126748	");
		testStrings.add("http://.www.foo.bar/	");
		testStrings.add("http://www.foo.bar./	");
		testStrings.add("http://.www.foo.bar./	");
		testStrings.add("http://10.1.1.1	");
		testStrings.add("http://10.1.1.254");
		
		
//		String regEx = "^[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		String regEx="((https?):////)?(www.)?([a-zA-Z0-9+&@#//%?=~_|!:,.;]+)\\.[a-zA-Z0-9+&@#//%=~_|]*.[a-z]*.?([a-z]+)?";
		//String regEx="((https?):////)?(www.)?([a-zA-Z0-9+&@#//%?=~_|!:,.;]+).[a-zA-Z0-9+&@#//%=~_|]*.[a-z]*.?([a-z]+)?";
		Pattern pattern = Pattern.compile(regEx);
		
		for(String oneSite : testStrings)
		{ 
             Matcher matcher = pattern.matcher(oneSite.trim());
              if (matcher.matches())
            	 System.out.println("valid -> "+oneSite);
              else
            	  System.out.println("invalid -> "+oneSite);
			
		}
	}
}
