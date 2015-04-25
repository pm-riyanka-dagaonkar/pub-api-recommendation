package com.pubmatic.beanCollection;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pubmatic.bean.Category;
import com.pubmatic.interfaces.Similar;

public class CategoryList implements Similar{
	
	private List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public long getSimilarPercent(Object o) {
		if(null == o || !(o instanceof CategoryList))
			return 0;
		
		CategoryList list2 = (CategoryList) o;
		if((list2.getCategories() == null || list2.getCategories().isEmpty()))
		{
			if(this.categories == null|| this.categories.isEmpty())
				return 100;
			else
				return 0;
		} 
		else
		{
			if(this.categories == null || this.categories.isEmpty())
				return 0;
		}
		
		
		int similarityPercentage=0;
		int sizeBase = this.categories.size();
		int equalCount = 0;

		Set<Category> list2Cats = new HashSet<Category>();
		list2Cats.addAll((Collection<? extends Category>) list2.getCategories());

		for(Category category : this.categories)
		{
			if(list2Cats.contains(category))
			{
				equalCount++;
			}
		}

		similarityPercentage=(equalCount/sizeBase)*100;
		return similarityPercentage;
	}
	

}
