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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DeleteElementFromXML {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            File inputFile = new File("src/subjects.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Введите название предмета для удаления:");
            String searchValue = in.nextLine();

            NodeList nodeList = doc.getElementsByTagName("subject");
            boolean found = false;

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    if (name.equalsIgnoreCase(searchValue)) {
                        doc.getDocumentElement().removeChild(node);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Совпадение не найдено.");
            } else {
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

                System.out.println("Предмет удален.");
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
