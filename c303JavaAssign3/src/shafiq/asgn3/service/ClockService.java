package shafiq.asgn3.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import startup.rest.clock.ClockBean;
import startup.rest.clock.DateTimeFormatException;

/*Group#3 members:
 Shafiq-Ur-Rehman
 Sahil Mahajan
 Atul Sharma
 Nirojan Jeyandhran
 */
 
//URIs begin http://localhost:8088/contextRoot/clock 
@ApplicationPath("/")
@Path("clock")
public class ClockService extends Application {
	//@Context means that args come from app server
	@GET
	@Produces("text/html")
	public String clockInfo(@Context UriInfo uri, @Context HttpHeaders headers) {
		return "<html>" +
				"<head>" +
				"<title>Restful Clock Service</title>" +
				"<meta http-equiv='Content-Type' content='text/html'>" +
				"</head>" +
				"<body>" +
				"<p>Hello, This RESTful service resides at <b>" + uri.getAbsolutePath() + "</b></p>" +
				"<p>The request headers are </p> "    +                            
				"<div align='center'>" + writeHeaders(headers) + "</div>" +	                
				"    </body>\n" +
				"</html>";	        
	}

	private String writeHeaders(HttpHeaders headers) {
		StringBuilder buf = new StringBuilder();
		for (String header: headers.getRequestHeaders().keySet()) {
			buf.append(header);
			buf.append(":");
			buf.append(headers.getRequestHeader(header));
			buf.append("<br>");
		}
		return buf.toString();
	}

	//http://localhost:8088/YourNameAsgn3/clock/time
	//by default display MEDIUM
	@GET
	@Path("time")
	public String getTime() {
		ClockBean clockBean = new ClockBean();
		//"checked" exception (i.e., extend Exception but not RuntimeException ) is the one that clients are required to handle at compile time.
		try {
			return clockBean.getCurrentTimeFormatted("MEDIUM");
		} 
		catch (DateTimeFormatException e) {
			return e.getClass().getName() +" : "+e.getMessage();
			//it returns the exception message for the web browser to display
			//more common approach is to respond by setting the most appropriate HTTP return code
		}
	}
	
	//http://localhost:8088/YourNameAsgn3/clock/formated-time/SHORT
	@GET
	@Path("formated-time/{format}")
	public String getTime(@PathParam("format") String format) {
		ClockBean clockBean = new ClockBean();
		try {
			return clockBean.getCurrentTimeFormatted(format);
		} 
		catch (DateTimeFormatException e) {
			return e.getClass().getName() +" : "+e.getMessage();
			//it returns the exception message for the web browser to display
			//more common approach is to respond by setting the most appropriate HTTP return code
		}
	}
	
	//http://localhost:8088/YourNameAsgn3/clock/formated-time?format=long
	@GET
	@Path("formated-time")
	@Consumes(MediaType.TEXT_PLAIN)
	public String getTime(@Context UriInfo uriInfo) {
		
		String format = uriInfo.getQueryParameters().getFirst("format");//map gives value for the key=format
		
		ClockBean clockBean = new ClockBean();
		try {
			return clockBean.getCurrentTimeFormatted(format);
		} 
		catch (DateTimeFormatException e) {
			return e.getClass().getName() +" : "+e.getMessage();
			//it returns the exception message for the web browser to display
			//more common approach is to respond by setting the most appropriate HTTP return code
		}
	}
}
