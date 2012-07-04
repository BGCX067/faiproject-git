package id.web.faisalabdillah.common;

import id.web.faisalabdillah.domain.User;
import id.web.faisalabdillah.domain.UserDetail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PaginationResult<T> {
	private List<T> result;
	private int resultSize;
	private int pageSize;
	private int startIndex;
	public PaginationResult(List<T> result,int resultSize,int startIndex,int pageSize) {
		this.result=result;
		this.resultSize = resultSize;
		this.startIndex =startIndex;
		this.pageSize = pageSize;
	}
	
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public int getResultSize() {
		return resultSize;
	}
	public void setResultSize(int resultSize) {
		this.resultSize = resultSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getNextIndex() {
		int maxIndex=resultSize/pageSize;
		if(resultSize % pageSize !=0){
			maxIndex+=1;
		}
		return startIndex>=maxIndex?startIndex:startIndex+pageSize;
	}
	public int getPrevIndex() {
		return startIndex<1?startIndex:startIndex-pageSize;
	}
	public static void main(String[] args) {
		PaginationResult<User> userPaginated=new PaginationResult<User>(new ArrayList<User>(), 5, 2, 3);
		System.out.println(userPaginated.getClass().getName());
		System.out.println(userPaginated.getClass().getCanonicalName());
	}

}
