package serviceImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import couchbase.CouchbaseWrapper;
import model.Constants;
import model.Domain;
import model.LookUpDocument;

/**
 * @author shashi
 *
 */
public class LookUpServiceImpl {

	public static void createLookUptable(Domain obj, String id)
			throws NoSuchFieldException, SecurityException, JsonParseException, JsonMappingException, IOException {
		String entityName = obj.getClass().getName().toString();
		System.out.println(entityName);
		if (CouchbaseWrapper.getDocument(Constants.ROOT_ID + Constants.COLON + entityName) != null) {
			Object object = CouchbaseWrapper.getDocument(Constants.ROOT_ID + Constants.COLON + entityName);
			ObjectMapper mapper = new ObjectMapper();
			LookUpDocument lookup = mapper.readValue(object.toString(), LookUpDocument.class);
			List<String> childIds = lookup.getChilIds();
			childIds.add(id);
			String result = null;
			try {
				result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lookup);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			CouchbaseWrapper.updateDocument(lookup.getRootId(), result);
		} else {
			LookUpDocument doc = new LookUpDocument();
			doc.setRootId(Constants.ROOT_ID + Constants.COLON + entityName);
			doc.setChilIds(Arrays.asList(id));
			ObjectMapper mapper = new ObjectMapper();
			String result = null;
			try {
				result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(doc);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			CouchbaseWrapper.createDocument(doc.getRootId(), result);
		}
	}
}
