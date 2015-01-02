package parser;

import java.util.Comparator;

public class SearchParamCount implements Comparator<SearchParamCount> {
	private SearchParam searchParam;
	private int count;
	
	 public SearchParamCount(SearchParam searchParam,int count) {
		 this.setSearchParam(searchParam);
		 this.setCount(count);
	}
	 
	 public SearchParamCount() {
	
	}
	public SearchParam getSearchParam() {
		return searchParam;
	}
	public void setSearchParam(SearchParam searchParam) {
		this.searchParam = searchParam;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public int compare(SearchParamCount o1, SearchParamCount o2) {
		
		if(o1.count > o2.count)
			return -1;
		if(o1.count < o2.count)
			return 1;
		return 0;
	}
	@Override
	public String toString() {
		return searchParam.toString()+"\nCount : "+count;
	}
	
	

}
