package zajęcia;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.w3c.dom.traversal.TreeWalker;

//import pl.Invoice.InvoiceFilter;

public class ExampleReadingXML {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            Document doc = ReadXML("data-books.xml");

            TravelByIterator(doc);

//			NodeList list = doc.getElementsByTagName("book");
//
//			for (int i = 0; i < list.getLength(); i++) {
//
////				System.out.println(list.item(i).getNodeName());
//
//				Node node = list.item(i);
//
//				if(node.getNodeType() == Node.ELEMENT_NODE) {
//
//					Element element = (Element) node;
//					System.out.println(element.getAttribute("id"));
//
//					Node nodeTitle = element.getElementsByTagName("title").item(0);
//					System.out.println(nodeTitle.getTextContent());
//
//
//				}
//
//			}


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static Document ReadXML(String path) throws Exception {

        File file = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        return doc;

    }

    public static void TravelByIterator(Document doc) {

        DocumentTraversal traversal = (DocumentTraversal) doc;

        FilterExample invoiceFilter = new FilterExample();


        NodeIterator it = traversal.createNodeIterator(doc.getDocumentElement(), NodeFilter.SHOW_ELEMENT, invoiceFilter, true);

        for (Node node = it.nextNode(); node != null; node = it.nextNode()) {

            System.out.println(node.getNodeName());

        }

    }

    private static void TravelByTreewalker(Document doc) {


        DocumentTraversal traversal = (DocumentTraversal) doc;

        TreeWalker walker = traversal.createTreeWalker(doc.getDocumentElement(),NodeFilter.SHOW_ELEMENT | NodeFilter.SHOW_TEXT, null , true);

        traverseLevel(walker);


    }

    private static void traverseLevel(TreeWalker walker) {
        // TODO Auto-generated method stub

        Node node = walker.getCurrentNode();

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(node.getNodeName());
        }

        if (node.getNodeType() == Node.TEXT_NODE) {

            String content_trimmed = node.getTextContent().trim();

            if (content_trimmed.length() > 0) {
                System.out.println(content_trimmed);
            }
        }

        for (Node n = walker.firstChild(); n != null; n = walker.nextSibling()) {

            traverseLevel(walker);
        }

        walker.setCurrentNode(node);
    }

}
