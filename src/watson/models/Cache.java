package watson.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;

@XmlRootElement
public class Cache {

    @XmlAttribute(name = "url")
    @XmlSchemaType(name = "anyURI")
    private String url;

    @Override
    public String toString() {
        return "Cache [url=" + url + "]";
    }

}
