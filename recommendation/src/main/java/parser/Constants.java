package parser;

public class Constants {
	
	public static String OFFER_SEARCH_URL = "http://172.16.4.67:8080/inventory/offerInsights";
	public static String OFFER_SEARCH_URL_2 = "http://localhost:8080/inventory/offerInsights";
	public static String PUBLISHER_IDS="publisherIds"; 
	public static String FILTERS="filters";
	public static String NAME="name";
	public static String PRODUCT_CATEGORY="productCategoryId";
	public static String PLATFORMS="platFormIds";
	public static String LIKE="like";
	public static String EQ="eq";
	public static String DESCRIPTION="description";
	public static String TAGS="tags";
	public static String ADDRESS="Address: ";
	public static int TOP_N=5;
	
	// the below fields will be populated using the threshold.properties
	public static long	CPM_THRESHOLD	;
	public static long	CATEGORIES_THRESHOLD	;
	public static long	SITES_THRESHOLD	;
	public static long	ADTAGS_THRESHOLD	;
	public static long	GEOS_THRESHOLD	;
	public static long	OFFER_THRESHOLD	;
	
	public static long	WEIGHT_CPM	= 1l;
	public static long	WEIGHT_CATEGORIES	= 1l;
	public static long	WEIGHT_SITES	= 1l;
	public static long	WEIGHT_ADTAGS	= 1l;
	public static long	WEIGHT_GEOS	;
	public static long	WEIGHT_ADCODETYPES	= 1l;
	public static long	WEIGHT_PLATFORMS	= 1l;


}
