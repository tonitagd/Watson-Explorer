package watson.rest.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.namespace.QName;

@XmlRootElement
public class DocumentType {

    @XmlAttribute(name = "url")
    @XmlSchemaType(name = "anyURI")
    private String url;

    @XmlElement(name = "cache", required = true)
    private Cache cache;

    @XmlElements({@XmlElement(name = "content")})
    private List<ContentType> contents;

    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nDocumentType:\n [url=");
        builder.append(url);
        builder.append(", \ncache=");
        builder.append(cache.toString());
        builder.append(", \ncontents=");

        for (ContentType contentType : contents) {
            builder.append(contentType.toString());
        }

        builder.append("]");
        return builder.toString();
    }
}