package com.xyz.rcp.firstapplication.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {

	public static void main(String argv[]) {

		try {

			File fXmlFile = new File(
					"C:\\Users\\vattarde\\Documents\\GitHub\\com.xyz.rcp.application\\com.xyz.rcp.firstapplication\\data\\NewFile.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getDocumentElement().getChildNodes();
			// node.getNextSibling()
			System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					if (eElement.getNodeName().equals("ns0:organisations")) {
						System.out.println("Name : "
								+ getTagValue("ns0:name", eElement));
						System.out.println("Type : "
								+ getTagValue("ns0:type", eElement));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}

	public static List<Organisation> readXML(List<Organisation> orgs) {

		try {

			File fXmlFile = new File(
					"C:\\Users\\vattarde\\Documents\\GitHub\\com.xyz.rcp.application\\com.xyz.rcp.firstapplication\\data\\NewFile.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getDocumentElement().getChildNodes();
			// node.getNextSibling()
			System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					if (eElement.getNodeName().equals("ns0:organisations")) {

						Organisation organisation = new Organisation();
						organisation.setNameOfOrganisation(getTagValue(
								"ns0:name", eElement));
						organisation.setType(getTagValue("ns0:type", eElement));

						ArrayList<Person> persons = new ArrayList<Person>();
						NodeList nPersonList = eElement.getChildNodes();
						for (int temp2 = 0; temp2 < nPersonList.getLength(); temp2++) {
							Node nNode2 = nPersonList.item(temp2);
							if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

								Element eElement2 = (Element) nNode2;
								if (eElement2.getNodeName().equals(
										"ns0:employees")) {

									Person person = new Person();
									person.setFirstName(getTagValue(
											"ns0:firstName", eElement2));
									person.setLastName(getTagValue("ns0:lastName", eElement2));
                                    person.setAge(new Integer(getTagValue(
											"ns0:age", eElement2)));
                                    person.setGender(getTagValue(
											"ns0:gender", eElement2));
                                    String value=getTagValue(
											"ns0:empID", eElement2);
                                    person.setID(Integer.parseInt(value));
                                   person.setAddress(new Address(getTagValue(
											"ns0:postalCode", eElement2),getTagValue(
													"ns0:city", eElement2) ,getTagValue(
															"ns0:country", eElement2)));
                                   String married=getTagValue(
											"ns0:married", eElement2);
                                   person.setMarried(Boolean.parseBoolean(married));
                                    
									persons.add(person);
								}

							}
						}

						organisation.setEmployees(persons);
						orgs.add(organisation);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orgs;
	}
 
}