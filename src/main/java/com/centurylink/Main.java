package com.centurylink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
	Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();

	public static void main(String[] args) {
		new Main().process();
	}

	public void process() {
		String data = "null,0,grandpa|0,1,son|0,2,daugther|1,3,grandkid|1,4,grandkid|2,5,grandkid|5,6,greatgrandkid";
		String[] nodesData = data.split("\\|");
		for (String s : nodesData) {
			String[] pieces = s.split(",");
			String parentId = pieces[0];
			Node parent = null;
			if (!parentId.equals("null")) {
				parent = nodeMap.get(Integer.parseInt(parentId));
			}
			int nodeId = Integer.parseInt(pieces[1]);
			String name = pieces[2];
			Node node = new Node(parent, nodeId, name);
			if (parent != null) {
				parent.getChildren().add(node);
			}else {
				//parent=new Node(null)
			}
			nodeMap.put(nodeId, node);
		}
		processSiblings();
		
		nodeMap.values().stream().forEach((n)->System.out.println(n));
	}

	private void processSiblings() {
		Consumer<Node> c = (node) -> {
			nodeMap.values().stream().filter(n -> !n.equals(node)).filter(n -> n.getParent()!=null && n.getParent().equals(node.getParent()))
					.forEach((n) -> node.getSiblings().add(n));
		};

		nodeMap.values().forEach(c);
	}

	public Map<Integer, Node> getNodeMap() {
		return nodeMap;
	}
	
}
