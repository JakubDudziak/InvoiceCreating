package zajęcia;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeFilter;

public class FilterExample  implements NodeFilter {

    public short acceptNode(Node thisNode) {

        if (thisNode instanceof Element) {

            if (((Element) thisNode).getTagName().equals("title") || ((Element) thisNode).getTagName().equals("price")) {
                return NodeFilter.FILTER_ACCEPT;

            }

        }
        return NodeFilter.FILTER_REJECT;



    }

}
