import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FindInXML {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            File inputFile = new File("src/subjects.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();

                System.out.println("Введите название предмета или имя преподавателя для поиска:");
                String searchValue = in.nextLine();

                NodeList nodeList = doc.getElementsByTagName("subject");
                boolean found = false;

                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) node;
                        String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        String teacher = eElement.getElementsByTagName("teacher").item(0).getTextContent();

                        if (name.equalsIgnoreCase(searchValue)) {
                            System.out.println("Предмет: " + name);
                            System.out.println("Преподаватель: " + teacher);
                            found = true;
                            break;
                        }

                        if (teacher.equalsIgnoreCase(searchValue)) {
                            System.out.println("Предмет: " + name);
                            System.out.println("Преподаватель: " + teacher);
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    System.out.println("Совпадение не найдено.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
}
    }
}
