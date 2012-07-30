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

/**
 * id.web.faisalabdillah.common
 * 
 * @author Muhamad Faisal Abdillah <br/>
 *         Jul 17, 2012
 * 
 */
public interface IResultBean<T> {
	int getCurrentPage();

	void setCurrentPage(int curr);

	int getSize();

	void setSize(int size);

	Object getMessage();

	void setMessage(Object message);

	boolean isSuccess();
	
	T getResult();
	
	void setResult(T t);
	
	int getPageSize();
	
	void setPageSize(int pageSize);
	
}
