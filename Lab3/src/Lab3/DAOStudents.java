package Lab3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DAOStudents {

    public static interface ProcessFunction {
        public void ProcessStudent(Student student);
    }
    public static class Student {
        private String name;
        private int id;
        private String group;
        public Student(String name, int id, String group) {
            this.name = name;
            this.id = id;
            this.group = group;
        }
        public String GetName() {
            return name;
        }
        public int GetId() { return id; }
        public String GetGroup() {
            return group;
        }

    }
    private Document doc;
    public DAOStudents(String studentsFileName){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.doc = builder.parse(new File("Students.xml"));
            this.doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private Student CreateStudent(Element xmlElement) {

        final String nameString = xmlElement.getElementsByTagName("name").item(0).getTextContent();
        final String idString = xmlElement.getElementsByTagName("id").item(0).getTextContent();
        final String groupString = xmlElement.getElementsByTagName("group").item(0).getTextContent();
        final int id = Integer.parseInt(idString);
        return new Student(nameString, id, groupString);

    }

    public synchronized void EnumStudents(ProcessFunction processStudent){
        Element root = this.doc.getDocumentElement();
        NodeList products = this.doc.getElementsByTagName("student");
        for (int i = 0; i < products.getLength(); i++){
            final Node node = products.item(i);
            try {
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Student student = CreateStudent((Element) node);
                    processStudent.ProcessStudent(student);
                }
            } catch(Exception ex){
                continue;
            }
        }
    }

    public synchronized void DeleteStudentWithId(int id){
        Element root = this.doc.getDocumentElement();
        NodeList products = this.doc.getElementsByTagName("student");
        for (int i = 0; i < products.getLength(); i++){
            final Node node = products.item(i);
            try {
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Student student = CreateStudent((Element) node);
                    if(student.id == id){
                        node.getParentNode().removeChild(node);
                        break;
                    }
                }
            } catch(Exception ex){
                continue;
            }
        }
    }
}
