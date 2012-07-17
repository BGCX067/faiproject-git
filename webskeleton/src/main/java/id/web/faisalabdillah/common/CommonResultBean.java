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

import java.util.ArrayList;
import java.util.List;

public class CommonResultBean<T>{
	private int size;
	private int currentPage;
	private int pageSize;
	private List<T> result;
	private Object message;
	private boolean success;
	
	public int getNextPage(){
		return currentPage>=getMaxPage()?currentPage:currentPage+1;
	}
	public int getPrevPage(){
		return currentPage<=1?currentPage:currentPage-1;
	}
	
	public int getIndex(int page){
		int index=(page-1)*pageSize;
		return index;
	}
	
	public static int getIndex(int page,int pageSize){
		int index=(page-1)*pageSize;
		return index;
	}
	public int getCurrentIndex(){
		return getIndex(currentPage);
	}
	public int getMaxPage(){
		int max=size/pageSize;
		if(size%pageSize!=0){
			max++;
		}
		return max;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getResult() {
		if(result==null)result=new ArrayList<T>();
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
