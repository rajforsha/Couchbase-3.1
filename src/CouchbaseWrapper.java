import java.util.List;
import java.util.Map;

import com.couchbase.client.CouchbaseClient;

/**
 * @author shashi
 *
 */
public class CouchbaseWrapper {
	public final static String empPrefix = "TESCO:EMP:ID:";
	static CouchbaseClient client = CouchBaseResource.getCouchBaseClient();

	public static void createDocument(Employee emp) {

		if (client.add(empPrefix + emp.getName(), emp) != null) {
			System.out.println("Document created");
		} else {
			System.out.println("oops! some error occured!");
		}

	}

	public static Employee getDocument(String key) {
		return (Employee) (client.get(key));
	}

	public static boolean deleteDocument(String key) {
		return (client.delete(key)) != null;
	}

	public static boolean updateDocument(String key, Employee emp) {
		return client.replace(key, emp) != null;
	}

	public static Map<String, Object> findAll(List<String> keys) {
		return (client.getBulk(keys));
	}

	public static void closeConnection() {
		client.shutdown();
	}
}
