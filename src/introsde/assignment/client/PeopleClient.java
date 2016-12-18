package introsde.assignment.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import javax.xml.ws.Service;

import introsde.assignment.soap.Measure;
import introsde.assignment.soap.MeasureDefinition;
import introsde.assignment.soap.People;
import introsde.assignment.soap.Person;

public class PeopleClient {
	
	PrintWriter pw;
	
	PeopleClient() {
		File f = new File("log.txt");
		try {
			pw = new PrintWriter(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void print(String toPrint) {
		pw.println(toPrint);
		pw.flush();
		System.out.println(toPrint);
	}
	
    public static void main(String[] args) throws Exception {
    	PeopleClient pc = new PeopleClient();
    	String serverUrl = "http://isde3-scarton.herokuapp.com/ws/people?wsdl";
        URL url = new URL(serverUrl);
        pc.print("Try to reach the resources at: "+serverUrl);
        QName qname = new QName("http://soap.assignment.introsde/", "PeopleService");
        Service service = Service.create(url, qname);
        
        //###### creation of input data (jump to line 78 to see the simulation)
        
        System.out.println("Creating data...");
        
        //utils for xml gregorian calendar
        GregorianCalendar gregCal = new GregorianCalendar();
        DatatypeFactory dtf = DatatypeFactory.newInstance();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        
        Person p1 = new Person();
        p1.setFirstname("Gabriele1");
        p1.setLastname("ISDE3");
        gregCal.setTime(format.parse("1993-1-1"));
        p1.setBirthdate(dtf.newXMLGregorianCalendar(gregCal));
        Holder<Person> ph1 = new Holder<Person>();
		ph1.value = p1;
		
		Person p2 = new Person();
        p2.setFirstname("Gabriele2");
        p2.setLastname("ISDE3");
        gregCal.setTime(format.parse("1993-2-2"));
        p2.setBirthdate(dtf.newXMLGregorianCalendar(gregCal));
        Holder<Person> ph2 = new Holder<Person>();
		ph2.value = p2;
		
		Measure m1 = new Measure();
		gregCal.setTime(format.parse("2015-1-1"));
		m1.setDateRegistered(dtf.newXMLGregorianCalendar(gregCal));
		m1.setMeasureValue("171");
		m1.setMeasureType("height");
		m1.setMeasureValueType("int");
		Holder<Measure> mh1 = new Holder<Measure>();
		mh1.value = m1;
		
		Measure m2 = new Measure();
		gregCal.setTime(new Date());
		m2.setDateRegistered(dtf.newXMLGregorianCalendar(gregCal));
		m2.setMeasureValue("181");
		m2.setMeasureType("height");
		m2.setMeasureValueType("int");
		Holder<Measure> mh2 = new Holder<Measure>();
		mh2.value = m2;
		
		Measure m3 = new Measure();
		gregCal.setTime(format.parse("2015-3-3"));
		m3.setDateRegistered(dtf.newXMLGregorianCalendar(gregCal));
		m3.setMeasureValue("81");
		m3.setMeasureType("weight");
		m3.setMeasureValueType("int");
		Holder<Measure> mh3 = new Holder<Measure>();
		mh3.value = m3;
		
		Measure m4 = new Measure();
		gregCal.setTime(format.parse("2015-4-4"));
		m4.setDateRegistered(dtf.newXMLGregorianCalendar(gregCal));
		m4.setMeasureValue("181");
		m4.setMeasureType("steps");
		m4.setMeasureValueType("int");
		Holder<Measure> mh4 = new Holder<Measure>();
		mh4.value = m4;
		
		Measure m5 = new Measure();
		gregCal.setTime(format.parse("2015-5-5"));
		m5.setDateRegistered(dtf.newXMLGregorianCalendar(gregCal));
		m5.setMeasureValue("185");
		m5.setMeasureType("height");
		m5.setMeasureValueType("int");
		Holder<Measure> mh5 = new Holder<Measure>();
		mh5.value = m5;
		
		Measure m6 = new Measure();
		gregCal.setTime(format.parse("2015-6-6"));
		m6.setDateRegistered(dtf.newXMLGregorianCalendar(gregCal));
		m6.setMeasureValue("186");
		m6.setMeasureType("height");
		m6.setMeasureValueType("int");
		Holder<Measure> mh6 = new Holder<Measure>();
		mh6.value = m6;
		
		System.out.println("Input data created");
		
		
		//##### start simulation
		//get server interface
		System.out.println("Start simulation");
        People people = service.getPort(People.class);
        
        //req #01 - get person list
        List<Person> personList = people.readPersonList();
        pc.print("Performed req #01 readPersonList(). Person in the db: "+ personList.size());
        
        //req #04 - create person
        people.createPerson(ph1);
        Long id1 = ph1.value.getPersonId();
        pc.print("Performed req #04 createPerson(p). New person created with ID: "+ ph1.value.getPersonId());
        people.createPerson(ph2);
        pc.print("Performed req #04 createPerson(p). New person created with ID: "+ ph2.value.getPersonId());
        
        //req #01 - get person list
        personList = people.readPersonList();
        pc.print("Performed req #01 readPersonList(). Person in the db: "+ personList.size());
        
        //req #07 - measure types
        List<MeasureDefinition> measureTypes = people.readMeasureTypes();       
        System.out.println("Performed req #07 readMeasureTypes(). In the db there are "+measureTypes.size()+" types of measures");
        
        //req #09 - save measure
        people.savePersonMeasure(id1, mh1);
        pc.print("Performed req #09 savePersonMeasure(id, m) on person with ID: "+id1+". Measure saved with ID: "+ mh1.value.getMid() + " and type: " + mh1.value.getMeasureType());
        people.savePersonMeasure(id1, mh2);
        pc.print("Performed req #09 savePersonMeasure(id, m) on person with ID: "+id1+". Measure saved with ID: "+ mh2.value.getMid() + " and type: " + mh2.value.getMeasureType());
        people.savePersonMeasure(id1, mh3);
        pc.print("Performed req #09 savePersonMeasure(id, m) on person with ID: "+id1+". Measure saved with ID: "+ mh3.value.getMid() + " and type: " + mh3.value.getMeasureType());
        people.savePersonMeasure(id1, mh4);
        pc.print("Performed req #09 savePersonMeasure(id, m) on person with ID: "+id1+". Measure saved with ID: "+ mh4.value.getMid() + " and type: " + mh4.value.getMeasureType());
        people.savePersonMeasure(id1, mh5);
        pc.print("Performed req #09 savePersonMeasure(id, m) on person with ID: "+id1+". Measure saved with ID: "+ mh5.value.getMid() + " and type: " + mh5.value.getMeasureType());
        people.savePersonMeasure(id1, mh6);
        pc.print("Performed req #09 savePersonMeasure(id, m) on person with ID: "+id1+". Measure saved with ID: "+ mh6.value.getMid() + " and type: " + mh6.value.getMeasureType());
        
        
        //req #07 - measure types
        measureTypes = people.readMeasureTypes();       
        pc.print("Performed req #07 readMeasureTypes(). In the db there are "+measureTypes.size()+" types of measures");
        
        //req #06 - get list of a specific measure
        List<Measure> measureList = people.readMeasureHistory(id1, "height");
        pc.print("Performed req #06 readMeasureHistory(id, 'height'). Person with ID: "+id1+" has "+measureList.size() +" measure of type height");
        
        //req #02 - get person
        Person output = people.readPerson(id1);
        pc.print("Performed req #02 readPerson(id). Received a person with ID: "+output.getPersonId()+" and lastname "+output.getLastname());
        
        //req #03 - update person
        ph1.value.setLastname("updated_lastname");
        people.updatePerson(ph1);
        pc.print("Performed req #03 updatePerson(p). Modified the lastname of person with ID: "+ph1.value.getPersonId());
        
        //req #02 - get person
        output = people.readPerson(id1);
        pc.print("Performed req #02 readPerson(id). Received a person with ID: "+output.getPersonId()+" and lastname "+output.getLastname());
        
        //req #08 - get a specific measure
        Measure m = people.readPersonMeasure(id1, "height", mh1.value.getMid());
        pc.print("Performed req #08 readPersonMeasure(id, 'height', mid). Measure with ID: "+m.getMid()+" has value: "+m.getMeasureValue());
       	
        //req #10 - update a specific measure
        mh1.value.setMeasureValue("167");
        people.updateMeasure(id1, mh1);
        pc.print("Performed req #09 updateMeasure(id, m). Measure with ID: "+m.getPersonId()+" has a new value");
        
        //req #08 - get a specific measure
        m = people.readPersonMeasure(id1, "height", mh1.value.getMid());
        pc.print("Performed req #08 readPersonMeasure(id, 'height', mid). Measure with ID: "+m.getMid()+" has value: "+m.getMeasureValue());
        
        //req #05 - delete person
        people.deletePerson(id1);
        people.deletePerson(ph2.value.getPersonId());
        pc.print("Performed req #05 deletePerson(id) on the 2 instances of Person created");
        
        //req #01 - get person list
        personList = people.readPersonList();
        pc.print("Performed req #01 readPersonList(). Person in the db: "+ personList.size());
        //*/
    }

}
