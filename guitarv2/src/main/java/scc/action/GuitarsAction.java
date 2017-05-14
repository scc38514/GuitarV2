package scc.action;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import scc.entity.GuitarSpec;
import scc.entity.Guitars;
import service.GuitarsService;

@SuppressWarnings("serial")
public class GuitarsAction extends ActionSupport {
	  
	private String  builder, model, type, backWood, topWood,numStrings;
	  
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBackWood() {
		return backWood;
	}
	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}
	public String getTopWood() {
		return topWood;
	}
	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	List<Guitars> list=new LinkedList();
	public String research() throws Exception{
		
		 GuitarsService guitarsService=new  GuitarsService();	
		 GuitarSpec spec =new GuitarSpec();
		 spec.setBuilder(builder);
		 spec.setTopWood(topWood);
		 spec.setBackWood(backWood);
		 spec.setModel(model);
		 spec.setType(type);
		 spec.setNumStrings(numStrings);
		 //System.out.println(builder);
		 list=guitarsService.search(spec);
		 ActionContext.getContext().getSession().put("GuitarsList", list);
		 return SUCCESS;
      }
	public String getNumStrings() {
		return numStrings;
	}
	public void setNumStrings(String numStrings) {
		this.numStrings = numStrings;
	}
	}