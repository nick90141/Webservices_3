package Task_2;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

public class XmlParser {
    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
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
        Document doc = builder.parse(new InputSource(new StringReader(xml)));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        XPathExpression nameExpression = xpath.compile("/flower/Plant/Name/text()");
        String name = nameExpression.evaluate(doc);

        XPathExpression originExpression = xpath.compile("/flower/Plant/Origin/text()");
        String origin = originExpression.evaluate(doc);

        XPathExpression stemColorExpression = xpath.compile("/flower/Plant/VisualParameters/StemColor/text()");
        String stemColor = stemColorExpression.evaluate(doc);

        System.out.println("Name: " + name);
        System.out.println("Origin: " + origin);
        System.out.println("Stem Color: " + stemColor);
    }
}
