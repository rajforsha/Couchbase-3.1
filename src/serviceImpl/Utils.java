/**
 * 
 */
package serviceImpl;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import model.Domain;

/**
 * @author shashi
 *
 */
public class Utils {
	public static void beforeCreate(Domain obj, String id)
			throws NoSuchFieldException, SecurityException, JsonParseException, JsonMappingException, IOException {
		LookUpServiceImpl.createLookUptable(obj,id);
	}
}
