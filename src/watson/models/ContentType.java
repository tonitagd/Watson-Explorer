package watson.models;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;

@XmlRootElement
public class ContentType {

    @XmlAttribute(name = "name")
    private String name;

    @XmlValue
    private String value;

    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    @Override
    public String toString() {
        return String.format("%s%s%s%s", "\nContentType [ name=", name, ", value=", value, "]");
    }
}
