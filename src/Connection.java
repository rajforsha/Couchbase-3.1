import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;

import com.fasterxml.jackson.databind.ObjectMapper;

import couchbase.CouchbaseWrapper;
import model.Constants;
import model.Employee;
import model.LookUpDocument;
import serviceImpl.Utils;

/**
 * @author shashi
 */
public class Connection implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4389357470728250384L;

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, JSONException, IOException {

		Employee emp = new Employee();
		emp.setCompany("CISCO");
		emp.setDesignation("SDE-2");
		emp.setName("Shashi");
		emp.setSalary(1000000);
		emp.setGender("male");
		emp.setId("1002");
		Utils.beforeCreate(emp, emp.getId());
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		CouchbaseWrapper.createDocument(emp.getId(), result);

		// System.out.println(CouchbaseWrapper.deleteDocument("TESCO:EMP:ID:shashsi
		// raj"));
		// CouchbaseWrapper.updateDocument("TESCO:EMP:ID:shashsi raj", emp);
		// Map<String, Object> mapList = new HashMap<String, Object>();
		// List<String> keyList = new ArrayList<>();
		// keyList.add("TESCO:EMP:ID:shashsi raj");
		// keyList.add("TESCO:EMP:ID:Randhir");
		// mapList = CouchbaseWrapper.findAll(keyList);
		// Employee empView = (Employee) mapList.get("TESCO:EMP:ID:Randhir");
		// System.out.println(empView);
		// String function = "function(doc,meta){\n" + "if(doc.name){\n" +
		// "emit(doc.name,doc)}\n" + "}";
		// CouchbaseWrapper.createView("byName", function);
		// CouchbaseWrapper.count("shashi", "byName");
		Employee emp1 = new Employee();
		String entityName = emp1.getClass().getName().toString();
		Object obj = CouchbaseWrapper.getDocument(Constants.ROOT_ID + Constants.COLON + entityName);
		System.out.println(obj);
		LookUpDocument doc = mapper.readValue(obj.toString(), LookUpDocument.class);
		List<String> rootList = doc.getChilIds();
		Map<String, Object> objList = CouchbaseWrapper.getBulk(rootList);
		for (Map.Entry<String, Object> map : objList.entrySet()) {
			System.out.println(map.getKey() + ":::::" + map.getValue());
		}
		CouchbaseWrapper.closeConnection();
	}

}