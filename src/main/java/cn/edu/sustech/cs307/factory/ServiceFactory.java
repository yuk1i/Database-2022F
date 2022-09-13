package cn.edu.sustech.cs307.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ServiceFactory {
    private final Map<Class<?>, Object> services = new HashMap<>();

    /**
     * Create a service instance of the given service class.
     *
     * @param serviceClass the requested service class.
     * @return an instance of the service.
     */
    public <T> T createService(Class<T> serviceClass) {
        try {
            return (T) services.get(serviceClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Register a service implementation class.
     *
     * @param serviceClass the service interface.
     * @param implementationInstance the service implementation instance.
     */
    protected <T> void registerService(Class<T> serviceClass, T implementationInstance) {
        services.put(serviceClass, implementationInstance);
    }

    /**
     * Return sids of your group members. This method is used in final judging.
     * For Example: return List.of("12110000", "114514", "1919810");
     *
     * @return List of sid
     */
    public abstract List<String> getUIDs();

    /**
     * In this method, you are required to truncate all tables of your database for this project.
     * This method is used in automatic junit tests.
     */
    public abstract void truncateDatabase();
}
