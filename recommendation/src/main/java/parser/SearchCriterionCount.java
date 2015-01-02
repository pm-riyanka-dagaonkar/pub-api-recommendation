package parser;

import java.util.Comparator;

public class SearchCriterionCount<T> implements Comparator<SearchCriterionCount>{

	private T criterionValue;
	private Integer count;

	public SearchCriterionCount(){}

	public SearchCriterionCount(T criterion, Integer count) {
		this.criterionValue=criterion;
		this.count = count;
	}
	public T getCriterionValue() {
		return criterionValue;
	}

	public void setCriterionValue(T criterionValue) {
		this.criterionValue = criterionValue;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public int compare(SearchCriterionCount o1, SearchCriterionCount o2) {
		if(o1.count > o2.count)
			return -1;
		if(o1.count < o2.count)
			return 1;
		return 0;
	}
	@Override
	public String toString() {
		return criterionValue+"\nCount : "+count;
	}
}
