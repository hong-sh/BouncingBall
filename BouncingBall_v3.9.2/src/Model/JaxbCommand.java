package Model;

import java.awt.Color;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JaxbCommand {

	private JAXBContext jaxbContext;
	private Marshaller marshaller;

	public JaxbCommand() {

		try {

			jaxbContext = JAXBContext.newInstance(Command.class);
			marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getXMLCommand(String action, String groupName) {

		StringWriter sw = new StringWriter();
		try {
			
			ObjectFactory objectFactory = new ObjectFactory();
			Command command = objectFactory.createCommand();
			command.setAction(action);
			command.setGroupname(groupName);

			marshaller.marshal(command, sw);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(sw.toString());
		return sw.toString().trim().replaceAll(">\\s*<", "><");
	}

	public String getXMLCommand(String action, String groupName, Color groupColor) {
		
		StringWriter sw = new StringWriter();
		try {
			
			ObjectFactory objectFactory = new ObjectFactory();
			Command command = objectFactory.createCommand();
			command.setAction(action);
			command.setGroupname(groupName);
			command.setGroupcolor(Integer.toString(groupColor.getRGB()));

			marshaller.marshal(command, sw);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(sw.toString());
		return sw.toString().trim().replaceAll(">\\s*<", "><");
	}

}
