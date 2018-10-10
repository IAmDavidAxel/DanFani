package server;

import utility.datamanager.ApplicationConfiguration;

import java.util.ArrayList;
import java.util.List;

public abstract class Context {

	protected List<Object> resourcesContext = new ArrayList<>();

	public static Context create() {

		if (ApplicationConfiguration.mode .equals("dev") ){
			return new DevelopmentContext();

		} else {
			throw new UnknownModeServerException();
		}
	}

	List<Object> getResourcesContext() {
		return resourcesContext;
	}

	public abstract void initializeResource();

	public abstract void registerServices();
}
