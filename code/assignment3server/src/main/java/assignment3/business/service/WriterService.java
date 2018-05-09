package assignment3.business.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import assignment3.data.entity.Writer;
import assignment3.data.repository.WriterJpaRepository;

@Service
public class WriterService {
	@Autowired 
	WriterJpaRepository writerRepository;
	
	public String findAll() throws JsonGenerationException, JsonMappingException, IOException {
		List<Writer> writers = writerRepository.findAll(); 
		return writeListToJSON(writers);
	}
	public String writerLogin(String username, String password) throws JsonGenerationException, JsonMappingException, IOException {
		Writer writer = writerRepository.findByWriterUsernameAndWriterPassword(username, password);
		return writeJSON(writer);
	}
	
	public void createAccount(String data) throws JsonParseException, JsonMappingException, IOException {
		Writer writer = readJSON(data);
		writerRepository.save(writer);
	}
	
	public void updateAccount(String data) throws JsonParseException, JsonMappingException, IOException {
		Writer writer = readJSON(data);
		Writer updatedWriter = writerRepository.findByWriterId(writer.getWriterId());
		updatedWriter.setWriterName(writer.getWriterName());
		updatedWriter.setWriterUserame(writer.getWriterUserame());
		updatedWriter.setWriterPassword(writer.getWriterPassword());
		writerRepository.save(updatedWriter);
	}
	
	public void deleteAccount(String data) throws JsonParseException, JsonMappingException, IOException {
		Writer writer = writerRepository.findByWriterId(readJSON(data).getWriterId());
		writerRepository.delete(writer);
	}
	
	public Writer readJSON(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Writer writer = mapper.readValue(jsonString, Writer.class);
		return writer;
	}
	
	public String writeJSON(Writer writer) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(writer);
		return result;
	}

	public String writeListToJSON(List<Writer> writers) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(writers);
		return result;
	}
}
