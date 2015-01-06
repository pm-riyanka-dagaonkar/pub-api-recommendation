package dao;

import java.util.List;

import parser.SearchParamCount;

public interface SearchCombinationDAO {
	
	public void insertSearchParamCount(SearchParamCount spc);

	public SearchParamCount getSearchParamCountById(Long SearchParamCountId);

	public List<SearchParamCount> getAllSearchParamCounts();

//	public void updateSearchParamCount(SearchParamCount SearchParamCount);

//	public void deleteSearchParamCount(Integer SearchParamCountId);


}
