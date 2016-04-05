package watson.rest.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

@XmlRootElement
public class ListType {

    @XmlElements({@XmlElement(name = "document")})
    private List<DocumentType> documents;

    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nListType:\n [documents=");

        for (DocumentType documentType : documents) {
            builder.append(documentType.toString());
        }

        builder.append("]");
        return builder.toString();
    }
}