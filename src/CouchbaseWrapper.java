import java.util.List;
import java.util.Map;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.protocol.views.DesignDocument;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.Stale;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewDesign;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;

/**
 * @author shashi
 *
 */
public class CouchbaseWrapper {
	public final static String empPrefix = "TESCO:EMP:ID:";
	static CouchbaseClient client = CouchBaseResource.getCouchBaseClient();

	public static void createDocument(String key, String value) {

		if (client.add(key, value) != null) {
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

	public static boolean createView(String viewName, String function) {
		DesignDocument doc = new DesignDocument("dev_search");
		ViewDesign design = new ViewDesign(viewName, function);
		doc.getViews().add(design);
		if (client.createDesignDoc(doc)) {
			return true;
		} else
			return false;

	}

	public static void searchByView(String key, String viewName) {
		System.setProperty("viewmode", "Development");
		View view = client.getView("search", viewName);
		Query query = new Query();
		query.setInclusiveEnd(true);
		query.setKey(key);
		query.setSkip(0);
		query.setStale(Stale.FALSE);
		ViewResponse result = client.query(view, query);
		for (ViewRow row : result) {
			System.out.println(row.getValue());
			// resultSet.add(row);
		}
		// return resultSet;
	}
}
