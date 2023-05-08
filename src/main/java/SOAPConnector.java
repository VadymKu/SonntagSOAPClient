import javax.xml.soap.*;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.util.Scanner;
import javax.xml.transform.*;

public class SOAPConnector {

    public static void connection() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Welche Mathematische Funktion wollen sie verwänden? (Auswahl: Add,Subtract,Divide,Multiply): ");
        String userInput = myObj.nextLine();
        System.out.println("Erste Zahl eingabe: ");
        String a = myObj.nextLine();
        System.out.println("Zweite Zahl eingabe 2: ");
        String b = myObj.nextLine();
        try {

            // Erstellt eine neue Instanz um eine Verbindung mit dem SOAP-Wbeservice herzustellen.
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();

            // Erstellt eine Verbindung zu einem SOAP webservice
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Erstellt eine Anfrage an den Webservice
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            String endpointUrl = "http://www.dneonline.com/calculator.asmx";
            //Hier abändern als auswahl
            soapMessage.getMimeHeaders().addHeader("SOAPAction", CalculatorFunctions.chooseTempuriFunction(userInput));
            //Funktionsauswahl aus anderer Klasse die String "request" zurück gibt
            String request = CalculatorFunctions.mathFunctions(userInput,a,b);

            StreamSource requestSource = new StreamSource(new StringReader(request));
            soapPart.setContent(requestSource);
            // SOAP-Anfrage senden und Antwort empfangen
            SOAPMessage soapResponse = soapConnection.call(soapMessage, endpointUrl);

            // Antwort aus der SOAP-Nachricht extrahieren
            SOAPBody soapResponseBody = soapResponse.getSOAPBody();
            // Get Element by Tag name muss geändert werden jedes mal lösung finden
            String response = soapResponseBody.getElementsByTagName(userInput+"Result").item(0).getTextContent();

            // Verbindung zum Webservice schließen
            soapConnection.close();

            // Antwort verarbeiten
            System.out.println("Response: " + response);


        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
    }


}
