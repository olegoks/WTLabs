
package Products;
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

public class DAOProducts{
    public static class Exception extends java.lang.Exception{

    }
    public static class Product{
        public enum Type{
            Fridge,
            Kettle,
            TV
        }
        private Type type;
        private int price;
        private String name;
        public Product(Type type, int price, String name) {
            this.price = price;
            this.type = type;
        }
        public Type GetType(){
            return type;
        }
        public int GetPrice(){
            return price;
        }
        public String GetName(){
            return name;
        }
    }
    public static class Fridge extends Product{
        private int height;
        private int width;

        public Fridge(int price, String name, int height, int width) {
            super(Type.Fridge, price, name);
            this.height = height;
            this.width = width;
        }
        int getWidth(){
            return width;
        }
        int GetHeight(){
            return height;
        }
    }
    public static class Kettle extends Product{
        private int volume;
        public Kettle(int price, String name, int volume){
            super(Type.Kettle, price, name);
            this.volume = volume;
        }
    }
    public static class TV extends  Product{
        private int diagonal;
        public TV(int price, String name, int diagonal){
            super(Type.TV, price, name);
            this.diagonal = diagonal;
        }

    }
    public static interface ProcessFunction {
        public void ProcessProduct(Product product);
    } 

    private Document doc;
    public DAOProducts(String productsFileName){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.doc = builder.parse(new File("Products.xml"));
            this.doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    private Product CreateProduct(Element xmlElement)throws Exception{
        final String productType = xmlElement.getAttribute("type");
        final String priceString = xmlElement.getElementsByTagName("price").item(0).getTextContent();
        final String nameString = xmlElement.getElementsByTagName("name").item(0).getTextContent();
        final int price = Integer.parseInt(priceString);
        switch (productType){
            case "fridge":{
                final String heightString = xmlElement.getElementsByTagName("height").item(0).getTextContent();
                final String widthString = xmlElement.getElementsByTagName("width").item(0).getTextContent();
                final int height = Integer.parseInt(heightString);
                final int width = Integer.parseInt(widthString);
                return new Fridge(price, nameString, height, width);
            }
            case "kettle":{
                final String volumeString = xmlElement.getElementsByTagName("volume").item(0).getTextContent();
                final int volume = Integer.parseInt(volumeString);
                return new Kettle(price, nameString, volume);
            }
            case "TV":{
                final String diagonalString = xmlElement.getElementsByTagName("diagonal").item(0).getTextContent();
                final int diagonal = Integer.parseInt(diagonalString);
                return new TV(price, nameString, diagonal);
            }
        }
        throw new Exception();
    }
    public void EnumProducts(ProcessFunction processProduct){
        Element root = this.doc.getDocumentElement();
        NodeList products = this.doc.getElementsByTagName("product");
        for (int i = 0; i < products.getLength(); i++){
            final Node node = products.item(i);
            try {
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Product product = CreateProduct((Element) node);
                    processProduct.ProcessProduct(product);
                }
            }catch(Exception ex){
                continue;
            }
        }
    }
}