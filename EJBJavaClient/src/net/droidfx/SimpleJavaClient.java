package net.droidfx;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.droidfx.stateless.SimpleHelloRemote;

public class SimpleJavaClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result;
		SimpleHelloRemote bean;
		try {

			final Properties env = new Properties();
			//Updated naming properties for JBossAS 7+
			env.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");
			env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, "remote://localhost:4447"));
			env.put("jboss.naming.client.ejb.context", true);

			Context ctx = new InitialContext(env);
			Object obj = ctx.lookup("/EJB_EAR_Demo/EJB_Demo/SimpleHello!net.droidfx.stateless.SimpleHelloRemote");
			bean = (SimpleHelloRemote)obj; 
			result = bean.sayHello("Bobby Bill");
			System.out.println(result);
			result = bean.sayHello();
			System.out.println("And again, another method:  " + result);
			
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
