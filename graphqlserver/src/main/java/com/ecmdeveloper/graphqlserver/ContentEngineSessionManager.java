/**
 * 
 */
package com.ecmdeveloper.graphqlserver;

import java.util.Map;

import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;

import com.filenet.api.core.Connection;
import com.filenet.api.core.Factory;
import com.filenet.api.util.UserContext;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import graphql.servlet.GraphQLServletListener;

/**
 * @author Ricardo Belfor
 *
 */
public class ContentEngineSessionManager {

	public static GraphQLServletListener getListener() {

		return new GraphQLServletListener() {

			@Override
			public GraphQLServletListener.OperationCallback onOperation(GraphQLContext context, String operationName, String query, Map<String, Object> variables) {

				context.getSubject().ifPresent(subject -> UserContext.get().pushSubject(subject) );
				
				return new GraphQLServletListener.OperationCallback() {

					@Override
					public void onFinally(GraphQLContext context, String operationName, String query, Map<String, Object> variables, Object data) {
						context.getSubject().ifPresent( subject -> UserContext.get().popSubject() );
					}
				};
			}	
		};
	}
	
	public static DataFetcher<String> getLogonMutation() {
		
		return new DataFetcher<String>() {

			@Override
			public String get(DataFetchingEnvironment environment) {
				GraphQLContext context = environment.getContext();
				HttpSession session = context.getRequest().get().getSession();

				if ( session.getAttribute("Subject") == null ) {

					String username = environment.getArgument("username");
					String password = environment.getArgument("password");
			
					Connection connection = Factory.Connection.getConnection(ContentEngineEndpoint.url);
				    Subject subject = UserContext.createSubject(connection, username, password, null );
				    
				    session.setAttribute("Connection", connection);
				    session.setAttribute("Subject", subject);
				}

				return session.getId();
			}
			
		}; 
	}
}
