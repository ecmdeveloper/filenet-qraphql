/**
 * 
 */
package com.ecmdeveloper.graphqlserver.scalars;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;

/**
 * @author Ricardo Belfor
 *
 */
public class GraphQLDateTime extends GraphQLScalarType {

	private static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneOffset.UTC); 
	
	public GraphQLDateTime() {
		super("Date", "A date value in the UTC timezone", new Coercing<Date, String>() {

			@Override
			public String serialize(Object input) {
				if (input instanceof Date) {
					Date date = (Date) input;
					LocalDateTime localDateTime = date.toInstant().atZone(ZoneOffset.UTC).toLocalDateTime();
					return formatter.format(ZonedDateTime.of(localDateTime, ZoneOffset.UTC ) );
				}
				return null;
			}

			@Override
			public Date parseValue(Object input) {
				if (input instanceof String) {
					LocalDateTime dateTime = LocalDateTime.parse((String) input, formatter);
					return Date.from(dateTime.atZone(ZoneOffset.UTC).toInstant());
				}
				return null;
			}

			@Override
			public Date parseLiteral(Object input) {
				return parseValue(input);
			}
		});
	}
}
