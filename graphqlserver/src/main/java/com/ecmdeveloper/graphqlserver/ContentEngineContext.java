/**
 * 
 */
package com.ecmdeveloper.graphqlserver;

import java.util.Optional;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.filenet.api.core.Connection;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;

import graphql.servlet.GraphQLContext;

/**
 * @author Ricardo Belfor
 *
 */
public class ContentEngineContext extends GraphQLContext {

	Optional<Connection> connection = Optional.empty();
	
	public ContentEngineContext(Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
		super(request, response);

		request.ifPresent( req -> { 
			HttpSession session = req.getSession(false);
			if (session != null && session.getAttribute("Subject") != null ) {
				setSubject( Optional.of( (Subject)session.getAttribute("Subject") ) );
				setConnection(Optional.of( (Connection)session.getAttribute("Connection") ) );
			}
		});
	}
	
    public Optional<Connection> getConnection() {
        return connection;
    }

    public void setConnection(Optional<Connection> connection) {
        this.connection = connection;
    }
    
    public ObjectStore getObjectStore(String name) {
    	
		if ( getConnection().isPresent() ) {
			Domain domain = Factory.Domain.fetchInstance(getConnection().get(), null, null);
			return Factory.ObjectStore.getInstance(domain, name);
		} else {
			throw new IllegalStateException("The user has no active session");
		}
    }
}
