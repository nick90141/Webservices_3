package Task_3_5;

import javax.xml.bind.JAXBException;

public class Task_3 {
    public static void main(String[] args) {
        try {
            saveAndPrintXML();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void saveAndPrintXML() throws JAXBException {
        Flower flower = FlowerManager.unmarshal("D:\\web\\33\\src\\main\\resources\\plants.xml");
        FlowerManager.marshal(flower, "D:\\web\\33\\src\\main\\resources\\plants.xml");
        System.out.println("Новий XML-документ збережено.");
    }
}
