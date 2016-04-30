import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import com.couchbase.client.CouchbaseClient;

/**
 * @author shashi
 *
 */
public class CouchBaseResource {
	static CouchbaseClient client = null;

	public static CouchbaseClient getCouchBaseClient() {

		if ((client == null)) {
			ArrayList<URI> uriList = new ArrayList<URI>();
			uriList.add(URI.create("http://127.0.0.1:8091/pools"));
			try {
				client = new CouchbaseClient(uriList, "default", "123456");
			} catch (IOException e) {
				System.err.println("couchbase connection not established.");
				e.printStackTrace();
			}
			return client;
		} else
			return client;

	}
}
