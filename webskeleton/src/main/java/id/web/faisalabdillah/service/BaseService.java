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

package id.web.faisalabdillah.service;

import id.web.faisalabdillah.common.PaginationResult;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	
	public boolean insert(T entity);
	public boolean delete(Serializable id);
	public boolean update(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
	public PaginationResult<T> findAll(int firstResult,int maxResult);
	public List<T> searchByExample(T entity);
	public PaginationResult<T> searchByExample(T entity,int firstResult,int maxResult);
}
