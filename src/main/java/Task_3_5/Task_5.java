package Task_3_5;

import Task_3_5.Flower.Flower;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Task_5 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/plants.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Flower.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Flower flower = (Flower) unmarshaller.unmarshal(xmlFile);

            System.out.println(flower);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
