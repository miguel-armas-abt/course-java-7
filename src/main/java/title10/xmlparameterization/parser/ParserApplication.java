package title10.xmlparameterization.parser;

import org.xml.sax.SAXException;
import title10.xmlparameterization.parser.business.UniversityCardService;
import title10.xmlparameterization.parser.business.impl.UniversityCardServiceImpl;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ParserApplication {

  public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

    UniversityCardService universityCardService = new UniversityCardServiceImpl();

    universityCardService.processXmlDocument();

    System.out.println("Estudiantes de Ingeniería de Sistemas: "
        .concat(String.valueOf(universityCardService.countStudentsByProfessionalSchool("INGENIERIA DE SISTEMAS"))));

    System.out.println("Estudiantes de Ingeniería de Software: "
        .concat(String.valueOf(universityCardService.countStudentsByProfessionalSchool("INGENIERIA DE SOFTWARE"))));

  }
}
