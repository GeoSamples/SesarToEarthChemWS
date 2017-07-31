package com.sesar.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sesar.dao.SamplingFeatureDao;
import com.sesar.model.*;

/*
* This is Restful web service file. 
* 
* @author  Bai
* @version 1.0
* @since   2017-07-11
* 
* Use XHR Poster as client with sesarec.war for test:
* url: http://localhost:8080/sesarec/ssec/samples
* content-type: application/xml
* accept-language: text/html
*/

@Path("/ssec")
public class SesarEcService {

	@Path("/samples")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String getSamples(Samples samples) {
		String error = null;
		String name = null;
		List<Sample> list = samples.getSamples();
		for(Sample sample: list) {
			name = sample.getName();
			error = new SamplingFeatureDao(sample).saveDataToDB();		
			if(error != null) break;
		}
		if(error != null) return "Error: "+error+" The data for sample "+name+" was not saved to the database.";
		else return "The data have been saved to database!";
	}
	
}
