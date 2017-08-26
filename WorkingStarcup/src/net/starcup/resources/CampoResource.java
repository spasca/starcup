package net.starcup.resources;

import net.starcup.models.Campo;
import net.starcup.utils.DBUtils;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.*;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.*;

@Path("/campo")
@Produces(MediaType.APPLICATION_JSON)
public class CampoResource {
	
	private static final String getAllQuery = 
			"SELECT * FROM Campo";
	
	private static final String getFromIdQuery = 
			"SELECT * FROM Campo WHERE IdCampo = ?";
	
	private static final String insertOnePrepQuery = 
			"INSERT INTO Campo (Denominazione, Foto, GPSLat, GPSLon) VALUES"
							+ "(?, ?, ?, ?)";
	
	private static final String deleteOnePrepQuery = 
			"DELETE FROM Campo WHERE idcampo = ?";
	
	@Path("/{idcampo}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Campo getOne(@PathParam("idcampo") long idcampo) {
		Connection connection;
		PreparedStatement preparedStatement;
	    ResultSet resultSet;
	    	    
		try {
			connection = DBUtils.getDBConnection();
			
			preparedStatement = connection.prepareStatement(getFromIdQuery);
			preparedStatement.setLong(1, idcampo);
			
			// Esegue la query
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				Campo c = new Campo(resultSet.getLong("IdCampo"), 
						resultSet.getString("Denominazione"), 
						resultSet.getString("Foto"), resultSet.getLong("GPSLat"), 
						resultSet.getLong("GPSLon"));
				return c;
			}
			else {
				return null;
			}
		} catch (Exception e) {
//			campi.add(new Campo(1L, "dentro eccezione", e.toString() + e.getMessage(), 1.1f, 2.2f));

		//	MANCA ERRORHANDLING da gestire con Response con igiusti codici HTTP_RETURN_STATUS
		}
		
		return null;
		
	}

	@Path("/{idcampo}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteOne(@PathParam("idcampo") long idcampo) {
		Connection connection;
		PreparedStatement preparedStatement;
	    
		try {
			connection = DBUtils.getDBConnection();
			
			preparedStatement = connection.prepareStatement(deleteOnePrepQuery);
			preparedStatement.setLong(1, idcampo);
			
			// Esegue la query
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {

		//	MANCA ERRORHANDLING da gestire con Response con igiusti codici HTTP_RETURN_STATUS
		}
		
		return Response.ok("{\"status\": \"ok\"}", MediaType.APPLICATION_JSON).build();
		
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Campo> getAll() {
		Connection connection;
	    Statement statement;
	    ResultSet resultSet;
	    
	    List<Campo> campi = new ArrayList<>();
	    
		try {
			connection = DBUtils.getDBConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(getAllQuery);
			
			/*
			int rowcount = 0;
			if (resultSet.last()) {
			  rowcount = resultSet.getRow();
			  resultSet.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
			}
			
			campi.add(new Campo(1L, "Righe sono " + rowcount, "conto righe", 1.1f, 2.2f));
			*/
			
			
			while (resultSet.next()) {
				Campo c = new Campo(resultSet.getLong("IdCampo"), 
						resultSet.getString("Denominazione"), 
						resultSet.getString("Foto"), resultSet.getLong("GPSLat"), 
						resultSet.getLong("GPSLon"));
				campi.add(c);
			}
		} catch (Exception e) {
//			campi.add(new Campo(1L, "dentro eccezione", e.toString() + e.getMessage(), 1.1f, 2.2f));

		//	MANCA ERRORHANDLING da gestire con Response con igiusti codici HTTP_RETURN_STATUS
		}
		
		return campi;
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertOne(Campo nuovocampo) {
		Connection connection;
		PreparedStatement preparedStatement;
	    
		try {
			connection = DBUtils.getDBConnection();
			
			preparedStatement = connection.prepareStatement(insertOnePrepQuery);

			preparedStatement.setString(1, nuovocampo.getDenominazione());
			preparedStatement.setString(2, nuovocampo.getFoto());
			preparedStatement.setFloat(3, nuovocampo.getGpslat());
			preparedStatement.setFloat(4, nuovocampo.getGpslon());
			
			// execute insert SQL stetement
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {

		//	MANCA ERRORHANDLING da gestire con Response con igiusti codici HTTP_RETURN_STATUS
		}
		
		return Response.ok("{\"status\": \"ok\"}", MediaType.APPLICATION_JSON).build();

	}
	
}
