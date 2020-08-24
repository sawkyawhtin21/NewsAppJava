package com.skh.newapp_java.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class News {

	@SerializedName("totalResults")
	private Integer totalResults;

	@SerializedName("articles")
	private List<ArticlesItem> articles;

	@SerializedName("status")
	private String status;

	public void setTotalResults(Integer totalResults){
		this.totalResults = totalResults;
	}

	public Integer getTotalResults(){
		return totalResults;
	}

	public void setArticles(List<ArticlesItem> articles){
		this.articles = articles;
	}

	public List<ArticlesItem> getArticles(){
		return articles;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}