package ECommerce.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility {
	
	public List<HashMap<String, String>> covertJsonDataToHashmap() throws IOException{
		String JsonContent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ECommerce\\Data\\SubmitOrderData.json"),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		 TypeReference<List<HashMap<String, String>>> typeRef 
         = new TypeReference<List<HashMap<String,String>>>() {};

 List<HashMap<String,String>> hashMappedData = mapper.readValue(JsonContent, typeRef); 
		
		return hashMappedData;
		
	}

	
}
