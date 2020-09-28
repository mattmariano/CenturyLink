package com.centurylink;

import java.util.ArrayList;
import java.util.List;

public class Node{
	private Node parent;
	private int id;
	private String name;
	private List<Node> children=new ArrayList();
	private List<Node> siblings=new ArrayList();
	
	public Node() {
		
	}
	public Node(Node parent, int id, String name) {
		this.parent=parent;
		this.id=id;
		this.name=name;
	}
	public Node getParent() {
		return parent;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<Node> getChildren() {
		return children;
	}
	public List<Node> getSiblings() {
		return siblings;
	}
	public String toString() {
		StringBuffer b=new StringBuffer();
		b.append("id="+id +", name="+name);
		if(parent==null) {
			b.append(", parent=null");
		}else {
			b.append(", parent={ id= "+parent.id+", name="+parent.name+"}");
		}
		b.append(", children=[");
		String comma="";
		for(Node n:children) {
			b.append(comma+ "{ id="+n.getId()+", name="+n.getName()+"}");
			comma=", ";
		}
		b.append("]");
		b.append(", siblings=[");
		comma="";
		for(Node n:siblings) {
			b.append("{ id="+n.getId()+", name="+n.getName()+" }");
			comma=", ";
		}
		b.append("]");
		return b.toString();
		
	}
}
