package id.web.faisalabdillah.common;

import java.util.Set;

public class CommonMenuTree {
	private String code;
	private String name;
	private String url;
	private String type;
	private int level;
	private CommonMenuTree parent;
	private Set<CommonMenuTree> child;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public CommonMenuTree getParent() {
		return parent;
	}
	public void setParent(CommonMenuTree parent) {
		this.parent = parent;
	}
	public Set<CommonMenuTree> getChild() {
		return child;
	}
	public void setChild(Set<CommonMenuTree> child) {
		this.child = child;
	}
	
	
	
}
