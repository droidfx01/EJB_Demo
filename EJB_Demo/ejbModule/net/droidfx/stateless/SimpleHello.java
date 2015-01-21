package net.droidfx.stateless;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import net.droidfx.stateless.SimpleHelloRemote;

/**
 * Session Bean implementation class SimpleHello
 */
@Stateless(mappedName = "HelloBean", description = "Basic Hello Bean")
@Remote(SimpleHelloRemote.class)
public class SimpleHello implements SimpleHelloRemote {

    /**
     * Default constructor. 
     */
    public SimpleHello() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello() {
		return "EJB says hello";
	}

	@Override
	public String sayHello(String s) {
		return "EJB says hello, " + s;
	}
	
}
