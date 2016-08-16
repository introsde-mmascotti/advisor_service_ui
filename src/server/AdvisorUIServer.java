package server;

import java.net.InetAddress;
import java.net.URI;

import javax.xml.ws.Endpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import service.Advisor;


public class AdvisorUIServer {
	private static final Logger logger = LogManager.getFormatterLogger("AdvisorUIServer");
	private static int port = 6800;

	public static void main(String[] args) throws Exception {

		String hostname = InetAddress.getLocalHost().getHostAddress();
		if (hostname.equals("127.0.0.1"))
			hostname = "localhost";

		if (args.length >= 1)
			port  = Integer.parseInt(args[0]);
		else
			logger.info("No port specified in arguments. Using default port: " + port);
		
		String url_str = String.format("http://%s:%d/", hostname, port);
		URI baseUrl = new URI(url_str);

		Endpoint.publish(url_str, new Advisor());
		
		logger.info("Server started: " + baseUrl);
	}
}