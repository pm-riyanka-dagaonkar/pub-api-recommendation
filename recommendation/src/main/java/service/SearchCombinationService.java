package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import parser.SearchParamCount;
import dao.MyBatisUtil;
import dao.SearchCombinationDAO;

public class SearchCombinationService {
	
	public SearchCombinationService(){}
	
	public SearchParamCount insertSearchCombination(SearchParamCount searchCombObject) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			SearchCombinationDAO searchCombDaoObj = sqlSession.getMapper(SearchCombinationDAO.class);
			Integer id=searchCombDaoObj.insertSearchParamCount(searchCombObject);
			Long idToSet=Long.parseLong(id.toString());
			searchCombObject.getSearchParam().setId(idToSet);
			sqlSession.commit();
			return searchCombObject;
		}finally{
			sqlSession.close();
		}
	}

	public SearchParamCount getRecordById(Long SearchParamCountId) {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
			  SearchCombinationDAO searchCombDaoObj = sqlSession.getMapper(SearchCombinationDAO.class);
			  SearchParamCount result=searchCombDaoObj.getSearchParamCountById(SearchParamCountId);
			  return result;
		  }finally{
		   sqlSession.close();
		  }
		 }

	public List<SearchParamCount> getAllSearches() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			SearchCombinationDAO searchCombDaoObj = sqlSession.getMapper(SearchCombinationDAO.class);
			return searchCombDaoObj.getAllSearchParamCounts();
		}finally{
			sqlSession.close();
		}
	}

}
