package framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.reflect.Field;

import org.reflections.Reflections;

public class FWContext {

	private static List<Object> objectMap = new ArrayList<>();
	private static List<Object> serviceObjectMap = new ArrayList<>();
	
	public FWContext() {
		try {
			Reflections reflections = new Reflections("");
			Set<Class<?>> types = reflections.getTypesAnnotatedWith(TestClass.class);
			for (Class<?> cls : types) {
				System.out.println(cls.getName());
				objectMap.add((Object) cls.newInstance());
			}
			
			Set<Class<?>> serviceTypes = reflections.getTypesAnnotatedWith(Service.class);
			for (Class<?> cls : serviceTypes) {
				System.out.println(cls.getName());
				serviceObjectMap.add((Object) cls.newInstance());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		performDependencyInjection();
	}
	
	public void start() {
		try {
			for (Object cls : objectMap) {
				Method before = null, test = null;
				for (Method m : cls.getClass().getDeclaredMethods()) {
					if (m.isAnnotationPresent(Before.class)) {
						before = m;
					}
					if (m.isAnnotationPresent(Test.class)) {
						test = m;
					}
					
					if (before != null & test != null) {
						before.invoke(cls);
						test.invoke(cls);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void performDependencyInjection() {
		try {
			for (Object cls : objectMap) {				
				for (Field f : cls.getClass().getDeclaredFields()) {
					if (f.isAnnotationPresent(Inject.class)) {					
						Class<?> t = f.getType();				
						Object instance = getBeanOftype(t);				
						f.setAccessible(true);
						f.set(cls, instance);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object getBeanOftype(Class<?> theFieldType) {
		Object service = null;
		try {
			for (Object cls : serviceObjectMap) {
				Class<?>[] interfaces = cls.getClass().getInterfaces();
				for (Class<?> i : interfaces) {
					if (i.getName().contentEquals(theFieldType.getName()))
						service = cls;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}

}
