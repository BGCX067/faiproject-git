/**
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *	 
 */

package id.web.faisalabdillah.common;

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
		int maxPage=resultSize/pageSize;
		if(resultSize % pageSize !=0){
			maxPage+=1;
		}
		int maxIndex=(maxPage*pageSize)-1;
		return startIndex>=maxIndex?startIndex:startIndex+pageSize;
	}
	public int getPrevPageIndex() {
		return startIndex<1?startIndex:startIndex-pageSize;
	}
	
	public static void main(String[] args) {
		PaginationResult<Object> pag=new PaginationResult<Object>(null, 522, 0, 10);
		System.out.println(pag.getNextPageIndex());
		System.out.println(pag.getStartIndex());
		System.out.println(pag.getPageNumber());
		System.out.println(pag.getPageNumber()*pag.getPageSize());
		
	}
	
	public int getCurrentPage(){
		return 0;
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

	public static int getIndexByPageNumber(int pageNumber,int pageSize){
		if(pageNumber==0)return 0;
		return (pageNumber-1)*pageSize;
	}
	public static int serializeIndex(int index,int pageSize){
		int sisa=index%pageSize;
		if(sisa!=0){
			index -=sisa;
		}
		return index;
	}
}
