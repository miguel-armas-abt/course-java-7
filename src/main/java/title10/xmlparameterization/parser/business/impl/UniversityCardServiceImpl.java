package title10.xmlparameterization.parser.business.impl;

import org.xml.sax.SAXException;
import title10.xmlparameterization.parser.business.UniversityCardService;
import title10.xmlparameterization.parser.dao.UniversityCardDao;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static title10.xmlparameterization.parser.util.constant.Constants.*;

public class UniversityCardServiceImpl implements UniversityCardService {

  private final UniversityCardDao universityCardDao;

  public UniversityCardServiceImpl() {
    universityCardDao = new UniversityCardDao();
  }

  @Override
  public void processXmlDocument() throws IOException, SAXException, ParserConfigurationException {


      if(universityCardDao.isXmlWellFormed(XML_DOCUMENT)) {
        System.out.println(MESSAGE_XML_DOCUMENT.concat(" bien formado"));
        if (universityCardDao.isXmlValidated(XML_DOCUMENT, XML_SCHEMA)) {
          System.out.println(MESSAGE_XML_DOCUMENT.concat(" válido"));
        } else {
          System.out.println(MESSAGE_XML_DOCUMENT.concat(" no válido"));
        }
      } else {
        System.out.println(MESSAGE_XML_DOCUMENT.concat(" mal formado"));
      }
  }

  @Override
  public long countStudentsByProfessionalSchool(String professionalSchool)
      throws IOException, SAXException, ParserConfigurationException {
    if (universityCardDao.isXmlWellFormed(XML_DOCUMENT) && universityCardDao.isXmlValidated(XML_DOCUMENT, XML_SCHEMA)) {
      return universityCardDao.toObject("universityCard", XML_DOCUMENT_LIST)
          .stream()
          .filter(universityCard -> universityCard
              .getStudent()
              .getCareer()
              .getCareerName().equals(professionalSchool))
          .count();
    } else {
      return 0L;
    }
  }
}
