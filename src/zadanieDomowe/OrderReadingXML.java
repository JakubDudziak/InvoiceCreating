package zadanieDomowe;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.w3c.dom.traversal.TreeWalker;

import java.io.File;

public class OrderReadingXML {

    public static void main(String[] args) {

        try {
            Document doc = ReadXML("Order.xml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static Document ReadXML(String path) throws Exception {

        File file = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        return doc;

    }


}
