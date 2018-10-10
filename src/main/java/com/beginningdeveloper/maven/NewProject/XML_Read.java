package com.beginningdeveloper.maven.NewProject;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML_Read {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		//Declare XML path
		File xmlFile = new File("/Users/ethirajp/eclipse-workspace1/NewProject/New.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		
		//Get node list
		NodeList nlxml = doc.getChildNodes();
		
		//Get xml first node
		Node nxml = nlxml.item(0);
		
		//Assign node element
		Element e1 = (Element)nxml;
		
		String a = e1.getElementsByTagName("URL").item(0).getTextContent();
		System.out.println(a);
	
//		NodeList nlxml1 = doc.getElementsByTagName("PERSON");
//		int len= nlxml1.getLength();
//		for(int i=0;i<len;i++) {
//			Node p =nlxml.item(i);
//		}
	
	}
	
public static String getData() throws SAXException, IOException, ParserConfigurationException {
		
		//Declare XML path
		File xmlFile = new File("/Users/ethirajp/eclipse-workspace1/NewProject/New.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		
		//Get node list
		NodeList nlxml = doc.getChildNodes();
		
		//Get xml first node
		Node nxml = nlxml.item(0);
		
		//Assign node element
		Element e1 = (Element)nxml;
		
		
		
		
		String a = e1.getElementsByTagName("URL").item(0).getTextContent();
		System.out.println(a);
		
		String a1 = e1.getElementsByTagName("WOW").item(0).getTextContent();
		System.out.println(a1);
		
		
		return a;
	
	}
	

}
