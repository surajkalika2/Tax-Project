package com.learning.j10.web;

import static com.learning.j10.utility.Utility.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jbbwebsolutions.service.IService;
import com.jbbwebsolutions.utility.BasicUtility;
import com.learning.j10.model.Clients;
import com.learning.j10.service.ClientsLookupService;

/**
 * Servlet implementation class ClientsWeb
 */
public class ClientsWeb extends _AbstractWeb {
	private static final long serialVersionUID = 1L;
     
	protected void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String url = this.getURLPattern(request);
		
		if(url.equals("client.view"))
			viewOne(request, response);
		else if(url.equals("clients"))
			showAll(request, response);	
		else if(url.equals("client.update"))
			update(request,response);
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		ClientsLookupService service = new ClientsLookupService();
		String action = BasicUtility.isNull(request::getParameter, "action", "update");
		
		
		int clientID =BasicUtility.whatIfNull(request::getParameter, "clientID",-999,Integer.class);
		String status = ifNull(request::getParameter, "status", "N/A");
		
		String x = ifNull(request::getParameter,"salary", "100000"); //made this before we had BasicUtility
		Double salary = Double.valueOf(x);
		Clients client = new Clients();

		client.setStatus(status);
		client.setClientID(clientID);
		client.setCurrentSalary(salary);

		if(action.equals("update")) {
		service.save(client);
		}
		else if(action.equals("delete")) {
			service.delete(clientID);
		}
		
		request.setAttribute("client", client);

		redirect("clients?status=ALL", request, response);
	}
	
	

	protected void viewOne(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		IService<Clients, Clients> service = new ClientsLookupService();
		Map<String, Object> search = new HashMap<>();		
		
		int clientID =Integer.parseInt(
				isNull(request::getParameter, "clientID",
				"-999"));
		search.put("clientID", clientID);
		List<Clients> clients = service.search(search);

		Clients client = clients.get(0);
		
		request.setAttribute("client", client);

		redirect("/WEB-INF/clientUpdate.jsp", request, response);
	}

	protected void showAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		
		IService<Clients, Clients> service = new ClientsLookupService();
		Map<String, Object> search = new HashMap<>();
		

		String status = request.getParameter("status");
		search.put("status", status);
		
		
		List<Clients> clients = service.search(search);
		
		request.setAttribute("clients", clients);
	
		request.setAttribute("developer", "kalika, suraj");
		request.setAttribute("date", new Date());
		
		
		redirect("/WEB-INF/clients.jsp", request, response);

		
		
		
	}



}
