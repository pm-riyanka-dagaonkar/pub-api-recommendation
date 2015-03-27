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
		int similarityPercentage=0;
		int sizeBase = this.categories.size();
		int equalCount = 0;
		CategoryList list2 = (CategoryList) o;
		Set<Category> list2Cats = new HashSet<Category>();
		list2Cats.addAll((Collection<? extends Category>) list2);
				
		for(Category category : this.categories)
		{
			if(list2Cats.contains(category))
			{
				equalCount++;
			}
		}
		
		similarityPercentage=((sizeBase-equalCount)/sizeBase)*100;
		return similarityPercentage;
	}
	

}
