package zajęcia;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExampleWritingXML {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.normalize();

            Element root = doc.createElement("books");
            doc.appendChild(root);

            Element book = doc.createElement("book");
            root.appendChild(book);

            Attr attr = doc.createAttribute("id");
            attr.setValue("123");
            book.setAttributeNode(attr);

            Element title = doc.createElement("title");
            title.appendChild(doc.createTextNode("Romeo and Juliet"));
            book.appendChild(title);

            Element genre = doc.createElement("genre");
            genre.appendChild(doc.createTextNode("Romance"));
            book.appendChild(genre);

            WriteXML(doc);

        } catch (DOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void WriteXML(Document doc) throws Exception {

        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);

        File newFile = new File("books.xml");

        StreamResult file = new StreamResult(newFile);
        transformer.transform(source, file);

    }

}

