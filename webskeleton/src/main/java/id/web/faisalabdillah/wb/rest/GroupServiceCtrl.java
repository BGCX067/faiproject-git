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
package id.web.faisalabdillah.wb.rest;

import java.util.List;

import id.web.faisalabdillah.common.IResultBean;
import id.web.faisalabdillah.domain.Group;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * id.web.faisalabdillah.wb.rest
 * @author
 * Muhamad Faisal Abdillah
 * <br/> Jul 17, 2012
 * 
 */

@Controller
@RequestMapping("/service/group")
public class GroupServiceCtrl {
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public IResultBean<?> insert(Group group){
		return null;
	}
	
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public IResultBean<?> update(Group group){
		return null;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public IResultBean<?> delete(@PathVariable String id){
		return null;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public IResultBean<List<Group>> get(){
		return null;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public IResultBean<?> updateById(){
		return null;
	}
}
