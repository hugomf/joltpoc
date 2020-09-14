package com.nike.joltpoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.json.JSONObject;
import org.json.XML;




public class Json2XmlSample {

   public  void transform()  {

      
      String source = new BufferedReader(
         new InputStreamReader(Json2XmlSample.class.getResourceAsStream("/json2xml/input.json"), StandardCharsets.UTF_8))
           .lines()
           .collect(Collectors.joining("\n"));
      
      JSONObject json = new JSONObject(source);
      String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n"  + XML.toString(json);
      System.out.println(xml);
   }


   public String getPrettyString(String xmlData, int indent) throws Exception {
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      transformerFactory.setAttribute("indent-number", indent);
    
      Transformer transformer = transformerFactory.newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    
      StringWriter stringWriter = new StringWriter();
      StreamResult xmlOutput = new StreamResult(stringWriter);
    
      Source xmlInput = new StreamSource(new StringReader(xmlData));
      transformer.transform(xmlInput, xmlOutput);
    
      return xmlOutput.getWriter().toString();
     }
}
