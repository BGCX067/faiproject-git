package id.web.faisalabdillah.common;

import id.web.faisalabdillah.domain.User;
import java.util.ArrayList;
import java.util.List;

public class PaginationResult<T> {
	private List<T> result;
	private int resultSize;
	private int pageSize;
	private int startIndex;
	private int pageNumber;
	
	
	public PaginationResult(List<T> result,int resultSize,int startIndex,int pageSize) {
		this.result=result;
		this.resultSize = resultSize;
		this.startIndex =startIndex;
		this.pageSize = pageSize;
		serializeIndex();
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
	public int getNextPageIndex() {
		if(pageSize==0){
			return 0;
		}
		int maxIndex=resultSize/pageSize;
		if(resultSize % pageSize !=0){
			maxIndex+=1;
		}
		return startIndex>=maxIndex?startIndex:startIndex+pageSize;
	}
	public int getPrevPageIndex() {
		return startIndex<1?startIndex:startIndex-pageSize;
	}
	
	public void serializeIndex(){
		if(pageSize==0){
			return;}
		int sisa=startIndex%pageSize;
		if(sisa!=0){
			startIndex -=sisa;
		}
	}
	/**
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		if(pageSize==0)return 0;
		int number=resultSize/pageSize;
		if((resultSize % pageSize)!=0){
			number++;
		}
		return number;
	}


	public static int serializeIndex(int index,int pageSize){
		int sisa=index%pageSize;
		if(sisa!=0){
			index -=sisa;
		}
		return index;
	}
	
	public static void main(String[] args) {
		PaginationResult<User> userPaginated=new PaginationResult<User>(new ArrayList<User>(), 53, 7, 5);
//		System.out.println(userPaginated.getClass().getName());
//		System.out.println(userPaginated.getClass().getCanonicalName());
//		System.out.println(userPaginated.getNextPageIndex());
//		System.out.println(userPaginated.getPrevPageIndex());
		userPaginated.serializeIndex();
		System.out.println(userPaginated.getStartIndex());
		int jump=5;
		int startIndex=4;
		System.out.println(startIndex % jump);
	}

}
