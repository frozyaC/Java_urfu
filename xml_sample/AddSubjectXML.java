import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AddSubjectXML {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            File inputFile = new File("src/subjects.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Element rootElement = doc.getDocumentElement();

            System.out.println("Введите название предмета:");
            Element subject = doc.createElement("subject");
            rootElement.appendChild(subject);

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(in.nextLine()));
            subject.appendChild(name);

            System.out.println("Введите имя преподавателя:");
            Element teacher = doc.createElement("teacher");
            teacher.appendChild(doc.createTextNode(in.nextLine()));
            subject.appendChild(teacher);

            doc.setXmlStandalone(true);
            doc.normalizeDocument();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(inputFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
