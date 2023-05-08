import javax.xml.soap.*;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.sql.Connection;
import javax.xml.transform.*;

public class SoapMainClient {

    public static void main(String[] args) {
   DbFunctions db= new DbFunctions();
   Connection conn = db.connect_to_db("SoapAPIDB","postgres","980126");
   db.createTable(conn,"Calculation1");
        //     SOAPConnector.connection();
/*
        String a = "20";
        String b = "3";

        try {

            // Verbindung erstellen mit dem Webservice
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Erstellt eine Anfrage an den Webservice
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            String endpointUrl = "http://www.dneonline.com/calculator.asmx";
            soapMessage.getMimeHeaders().addHeader("SOAPAction", "http://tempuri.org/Add");

            // Anfragetext:
            String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                    "<soapenv:Header/>\n" +
                    "<soapenv:Body>\n" +
                    "<tem:Add>\n" +
                    "<tem:intA>" + a + "</tem:intA>\n" +
                    "<tem:intB>" + b + "</tem:intB>\n" +
                    "</tem:Add>\n" +
                    "</soapenv:Body>\n" +
                    "</soapenv:Envelope>";

            StreamSource requestSource = new StreamSource(new StringReader(request));
            soapPart.setContent(requestSource);
            // SOAP-Anfrage senden und Antwort empfangen
            SOAPMessage soapResponse = soapConnection.call(soapMessage, endpointUrl);

            // Antwort aus der SOAP-Nachricht extrahieren
            SOAPBody soapResponseBody = soapResponse.getSOAPBody();
            String response = soapResponseBody.getElementsByTagName("AddResult").item(0).getTextContent();

            // Verbindung zum Webservice schließen
            soapConnection.close();

            // Antwort verarbeiten
            System.out.println("Response: " + response);

        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
  */  }
}

