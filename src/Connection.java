import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shashi
 *
 */
public class Connection {
	public static void main(String[] args) {
		// Employee emp = new Employee();
		// emp.setCompany("CISCO");
		// emp.setDesignation("SDE-2");
		// emp.setName("Randhir");
		// emp.setSalary(1000000);
		// CouchbaseWrapper.createDocument(emp);

		// System.out.println(CouchbaseWrapper.deleteDocument("TESCO:EMP:ID:shashsi
		// raj"));
		// CouchbaseWrapper.updateDocument("TESCO:EMP:ID:shashsi raj", emp);

		Map<String, Object> mapList = new HashMap<String, Object>();
		List<String> keyList = new ArrayList<>();
		keyList.add("TESCO:EMP:ID:shashsi raj");
		keyList.add("TESCO:EMP:ID:Randhir");
		mapList = CouchbaseWrapper.findAll(keyList);
		Employee empView = (Employee) mapList.get("TESCO:EMP:ID:Randhir");
		System.out.println(empView);
		CouchbaseWrapper.closeConnection();
	}

}