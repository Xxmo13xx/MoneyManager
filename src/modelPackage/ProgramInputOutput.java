package modelPackage;
import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;

import sun.tools.jstat.OutputFormatter;


public class ProgramInputOutput {



    public ProgramInputOutput(){

    }



    public void createTestOuputDocument(){

        try{
            FileOutputStream fos = new FileOutputStream("testXmlOutput.xml");
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(fos, format);


            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("controllerTestsData");
            Element accountsElement = root.addElement("Accounts");
            Element accountNameElement = accountsElement.addElement("account")
                    .addAttribute("Name", "Test Account")
                    .addAttribute("Balance","1000.00")
                    .addAttribute("Type", "Normal");
            accountsElement.addElement("account")
                    .addAttribute("Name", "Test Checking Account")
                    .addAttribute("Balance", "1000.00")
                    .addAttribute("Type" , "Checkings");
            accountsElement.addElement("account")
                    .addAttribute("Name", "Test Savings Account")
                    .addAttribute("Balance", "1000.00")
                    .addAttribute("SavingsGoal", "1500.00")
                    .addAttribute("Type", "Savings");


            // pretty print the document to system out
           /* Use this to output to screen
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer;
            writer = new XMLWriter(System.out, format);
           */
            writer.write(document);
            writer.flush();



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseXmlDocument(){

        try {
            File inputFile = new File("testXmlOutput.xml");
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputFile);

            System.out.println("The Root Element is " + document.getRootElement().getName());

            Element rootElement = document.getRootElement();
            String accountsPath = "/controllerTestsData/Accounts/account";
            List<Node> accountNodes = document.selectNodes(accountsPath);
            if (accountNodes.size() > 0) {

                for (Node node : accountNodes) {

                    System.out.println("Account type is: " + node.valueOf("@Type"));
                    System.out.println("Account name is: " + node.valueOf("@Name"));
                    System.out.println("Account balance is: " + node.valueOf("@Balance"));
                    System.out.println();

                }
            }


        } catch (DocumentException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ProgramInputOutput testOutput = new ProgramInputOutput();
        testOutput.createTestOuputDocument();
        testOutput.parseXmlDocument();
    }


}
