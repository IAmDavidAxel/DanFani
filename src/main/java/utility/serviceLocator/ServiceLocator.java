package utility.serviceLocator;

import java.util.HashMap;
import java.util.Map;

public enum ServiceLocator {

	INSTANCE;

	private Map<Class<?>,Object> instances = new HashMap<>();

	public <T> void  register(Class<T> abstraction , Object implementation) {
		if (instances.containsKey(abstraction)) {
			throw new ServiceAlreadyRegisteredException();
		}
	instances.put(abstraction,implementation);
	}

	@SuppressWarnings("unchecked")
	public <T> T resolve (Class<T> abstraction){
		T service = (T) instances.get(abstraction);

		if(service.equals(null)){
			throw new
					UnknownResolvedServieException();
		}
		return service;
	}

	public void reset(){
		instances.clear();
	}


}
