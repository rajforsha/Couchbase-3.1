import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author shashi
 */
public class Connection {
	public static void main(String[] args) throws JsonProcessingException {

		// Employee emp = new Employee();
		// emp.setCompany("CISCO");
		// emp.setDesignation("SDE-2");
		// emp.setName("pooja");
		// emp.setSalary(1000000);
		// emp.setGender("female");
		// ObjectMapper mapper = new ObjectMapper();
		// String value =
		// mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		// CouchbaseWrapper.createDocument("4", value);

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
		CouchbaseWrapper.searchByView("shashi", "byName");
		CouchbaseWrapper.closeConnection();
	}

}