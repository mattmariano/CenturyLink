package com.centurylink;

import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

public class MainTest {
	@Test
	public void testNodes() {
		Main m=new Main();
		m.process();
		Map<Integer,Node> nodeMap=m.getNodeMap();
		Node grandpa=nodeMap.get(0);
		assertNull("parent should be null", grandpa.getParent());
		assert(grandpa.getChildren().size()==2);
		assert(grandpa.getSiblings().size()==0);
		Node n=grandpa.getChildren().get(0);
		assert(n.getId()==1 || n.getId()==2);
		n=grandpa.getChildren().get(1);
		assert(n.getId()==1 || n.getId()==2);
		Node son=nodeMap.get(1);
		assert(son.getParent().getId()==0);
		assert(son.getChildren().size()==2);
		assert(son.getSiblings().size()==1);
		assert(son.getChildren().get(0).getId()==3 || son.getChildren().get(0).getId()==4);
		assert(son.getChildren().get(1).getId()==3 || son.getChildren().get(1).getId()==4);
		assert(son.getSiblings().get(0).getId()==2);
		Node daughter=nodeMap.get(2);
		assert(daughter.getParent().getId()==0);
		assert(daughter.getChildren().size()==1);
		assert(daughter.getSiblings().size()==1);
		assert(daughter.getChildren().get(0).getId()==5 );
		assert(daughter.getSiblings().get(0).getId()==1);
		Node grandkid1=nodeMap.get(3);
		assert(grandkid1.getParent().getId()==1);
		assert(grandkid1.getChildren().size()==0);
		assert(grandkid1.getSiblings().size()==1);
		//assert(son.getChildren().get(0).getId()==3 || son.getChildren().get(0).getId()==4);
		//assert(son.getChildren().get(1).getId()==3 || son.getChildren().get(1).getId()==4);
		assert(grandkid1.getSiblings().get(0).getId()==4);
		Node grandkid2=nodeMap.get(4);
		assert(grandkid2.getParent().getId()==1);
		assert(grandkid2.getChildren().size()==0);
		assert(grandkid2.getSiblings().size()==1);
		assert(grandkid2.getSiblings().get(0).getId()==3);	
		Node grandkid3=nodeMap.get(5);
		assert(grandkid3.getParent().getId()==2);
		assert(grandkid3.getChildren().size()==1);
		assert(grandkid3.getSiblings().size()==0);
		assert(grandkid3.getChildren().get(0).getId()==6);
		Node greatgrandkid=nodeMap.get(6);
		assert(greatgrandkid.getParent().getId()==5);
		assert(greatgrandkid.getChildren().size()==0);
		assert(greatgrandkid.getSiblings().size()==0);

	}
}
