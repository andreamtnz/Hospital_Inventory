package Hospital_InventoryXMLManager;

import java.io.File;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import Hospital_InventoryJDBC.*;
import Hospital_InventoryPOJO.Doctor;
import Hospital_InventoryPOJO.Nurse;
import Hospital_inventoryInterfaces.XMLManager;


public class XMLDoctor_NurseManager implements XMLManager{
	
	JDBCManager manager;
	
	public XMLDoctor_NurseManager(JDBCManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void doctor2xml(Doctor d) {
		// TODO Auto-generated method stub
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Doctor.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("./xmls/Doctor.xml");
			
			
			marshaller.marshal(d, file);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void doctorID2xml(Integer id) {
		Doctor d = null;
		try {
			JDBCDoctorManager doctorManager = new JDBCDoctorManager(manager);
			d = doctorManager.getDoctorByID(id);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Doctor.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("./xmls/Doctor.xml");
			
			marshaller.marshal(d, file);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void nurse2xml(Nurse n) {
		try {
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Nurse.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("./xmls/Nurse.xml");
			
			marshaller.marshal(n, file);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Doctor xml2doctor(File xml) {
		Doctor d = null;
		try {
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Doctor.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			d = (Doctor) unmarshaller.unmarshal(xml);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return d;
	}


	@Override
	public Nurse xml2nurse(File xml) {
		Nurse n = null;
		try {
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Nurse.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			n = (Nurse) unmarshaller.unmarshal(xml);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public void simpleTransform(String sourcePath, String xsltPath, String resultDir) {
		// TODO Auto-generated method stub
		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = tFactory.newTransformer(new StreamSource(new File(xsltPath)));
			transformer.transform(new StreamSource(new File(sourcePath)),new StreamResult(new File(resultDir)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}



	

	

	

