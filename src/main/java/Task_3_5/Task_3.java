package Task_3_5;

import Task_3_5.Flower.Flower;
import Task_3_5.FlowerManager.FlowerManager;

import javax.xml.bind.JAXBException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;


public class Task_3 {
    public static void main(String[] args) {
//        try {
//            saveAndPrintXML();
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void saveAndPrintXML() throws JAXBException {
//        Flower flower = FlowerManager.unmarshal("src/main/resources/plants.xml");
//        FlowerManager.marshal(flower, "src/main/resources/plants.xml");
//        System.out.println("Новий XML-документ збережено.");

        try {
            String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<flower>\n" +
                    "    <Plant>\n" +
                    "        <Name>Rose</Name>\n" +
                    "        <Soil>Soil</Soil>\n" +
                    "        <Origin>Europe</Origin>\n" +
                    "        <VisualParameters>\n" +
                    "            <StemColor>Green</StemColor>\n" +
                    "            <LeafColor>Green</LeafColor>\n" +
                    "            <Size>Medium</Size>\n" +
                    "        </VisualParameters>\n" +
                    "        <GrowingTips>\n" +
                    "            <Temperature>20-25</Temperature>\n" +
                    "            <Lighting>Sunlight</Lighting>\n" +
                    "            <Watering>Once a week</Watering>\n" +
                    "        </GrowingTips>\n" +
                    "        <Multiplying>Seeds</Multiplying>\n" +
                    "    </Plant>\n" +
                    "</flower>";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlString)));

            Element root = document.getDocumentElement();
            NodeList plantList = root.getElementsByTagName("Plant");

            if (plantList.getLength() > 0) {
                Element plant = (Element) plantList.item(0);

                String name = plant.getElementsByTagName("Name").item(0).getTextContent();
                String origin = plant.getElementsByTagName("Origin").item(0).getTextContent();


                String html = "<html>\n" +
                        "  <head>\n" +
                        "    <title>" + name + "</title>\n" +
                        "  </head>\n" +
                        "  <body>\n" +
                        "    <h1>" + name + "</h1>\n" +
                        "    <p>Origin: " + origin + "</p>\n" +
                        "  </body>\n" +
                        "</html>";

                System.out.println(html);
            } else {
                System.out.println("Не нашел.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
