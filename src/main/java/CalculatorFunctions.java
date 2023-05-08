import java.util.Scanner;

public class CalculatorFunctions {

    public static String chooseTempuriFunction(String userInput) {

        if (userInput.equals("Add")) {
            return "http://tempuri.org/Add";
        } else if (userInput.equals("Subtract")) {
            return "http://tempuri.org/Subtract";
        } else if (userInput.equals("Divide")) {
            return "http://tempuri.org/Divide";
        } else if (userInput.equals("Multiply")) {
            return "http://tempuri.org/Multiply";
        } else return "Eingabe ungültig";
    }

    public static String mathFunctions(String userInput, String a, String b) {
        if (userInput.equals("Add")) {
            String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                    "<soapenv:Header/>\n" +
                    "<soapenv:Body>\n" +
                    "<tem:Add>\n" +
                    "<tem:intA>" + a + "</tem:intA>\n" +
                    "<tem:intB>" + b + "</tem:intB>\n" +
                    "</tem:Add>\n" +
                    "</soapenv:Body>\n" +
                    "</soapenv:Envelope>";
            return request;
        } else if (userInput.equals("Subtract")) {
            String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                    "<soapenv:Header/>\n" +
                    "<soapenv:Body>\n" +
                    "<tem:Subtract>\n" +
                    "<tem:intA>" + a + "</tem:intA>\n" +
                    "<tem:intB>" + b + "</tem:intB>\n" +
                    "</tem:Subtract>\n" +
                    "</soapenv:Body>\n" +
                    "</soapenv:Envelope>";
            return request;
        } else if (userInput.equals("Divide") && b != "0") {
            String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                    "<soapenv:Header/>\n" +
                    "<soapenv:Body>\n" +
                    "<tem:Divide>\n" +
                    "<tem:intA>" + a + "</tem:intA>\n" +
                    "<tem:intB>" + b + "</tem:intB>\n" +
                    "</tem:Divide>\n" +
                    "</soapenv:Body>\n" +
                    "</soapenv:Envelope>";
            return request;
        } else if (userInput.equals("Multiply")) {
            String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                    "<soapenv:Header/>\n" +
                    "<soapenv:Body>\n" +
                    "<tem:Multiply>\n" +
                    "<tem:intA>" + a + "</tem:intA>\n" +
                    "<tem:intB>" + b + "</tem:intB>\n" +
                    "</tem:Multiply>\n" +
                    "</soapenv:Body>\n" +
                    "</soapenv:Envelope>";
            return request;
        } else return "Falsche eingabe";

    }

}


