package server;

import javafx.beans.property.Property;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import utility.datamanager.ApplicationConfiguration;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DanFaniServer {

	private static final Logger SERVER_LOGGER = Logger.getLogger(DanFaniServer.class.getName());

	private Server server;

	public static void main (String[] args ) throws Exception{

		SERVER_LOGGER.info("Loading application configuration parameters");
		PropertyConfiguration property = new PropertyConfiguration(ApplicationConfiguration.PROPERTIES_FILE_NAME);
		property.initialize();
		property.apply();

		SERVER_LOGGER.info("Loading application context parameters," +
				"registering and initializing services.");

		Context applicationContext = Context.create();
		applicationContext.initializeResource();
		applicationContext.registerServices();

		DanFaniServer server = new DanFaniServer();
		server.start(ApplicationConfiguration.serverPort,applicationContext);
		server.join();
	}

	private void join() {
		try {
			server.join();
		}catch (Exception e){
			Logger.getGlobal().log(Level.SEVERE,"");
		}finally {
			tryStopServer();
		}
	}

	private void start(int serverPort, Context applicationContext) throws Exception{
		server = new Server(serverPort);
		ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		ContextHandlerCollection contextHandlerCollection = configureJersey(servletContextHandler,applicationContext);
		server.setHandler(contextHandlerCollection);

		try{
			server.start();
			SERVER_LOGGER.info("Server stated at " + server.getURI());
		}catch (Exception e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
		}finally {
			tryStopServer();
		}
	}

	private ContextHandlerCollection configureJersey(ServletContextHandler servletContextHandler, Context applicationContext) {

		servletContextHandler.setContextPath("/api/");
		SERVER_LOGGER.info("Registering resources. ");
		ResourceConfig resourceConfig = ResourceConfig.forApplication(new Application(){
			@Override
			public Set<Object> getSingletons() {
				HashSet<Object> resources = new HashSet<>();
				resources.addAll(applicationContext.getResourcesContext());
				return resources;
			}
		});

		ServletContainer servletContainer = new ServletContainer(resourceConfig);
		ServletHolder servletHolder = new ServletHolder(servletContainer);
		servletContextHandler.addServlet(servletHolder,"/*");

		SERVER_LOGGER.info("Registering  Angular Webapp");

		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(new Handler[]{servletContextHandler});

		return contexts;
	}

	private void tryStopServer() {
		try {
			server.destroy();
		}catch (Exception e){
			return;
		}
	}

	private void stop(){
		try {
			server.stop();
		}catch (Exception e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
		}
	}

}
