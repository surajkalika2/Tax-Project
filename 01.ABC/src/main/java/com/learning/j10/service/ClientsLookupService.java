package com.learning.j10.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.dao.IUpdate;
import com.jbbwebsolutions.exception.DataRepositoryCustomException;
import com.jbbwebsolutions.service.IService;
import com.learning.j10.dao.AbstractClientDAO;
import com.learning.j10.dao.clientSQLDAO;
import com.learning.j10.model.Clients;
import com.learning.j10.utility.Utility;

public class ClientsLookupService implements IService<Clients, Clients>, IUpdate<Integer>{

	private AbstractClientDAO dao = null;
	
	public ClientsLookupService() {
	dao = new clientSQLDAO();
	}
	public ClientsLookupService(IQuery<Clients> dao) {
		this.dao = (AbstractClientDAO) dao;
	}
	
	
	
	@Override
	public void save(Clients client) {
		dao.save(client);
	
	}
	
	@Override
	public int delete(Integer clientID) throws DataRepositoryCustomException {
		
		Clients model = new Clients();
		model.setClientID(clientID);
		
		return dao.delete(model);
	}
	@Override
	public List<Clients> search(Map<String,Object> search){
		
		if(search == null) {
			return new ArrayList<>();
		}
		
		String status = Utility.ifNull(search::get, "status", "ALL");
		int clientID = Utility.ifNull(search::get, "clientID", -999);

		
		Clients model = new Clients();
		
		model.setStatus(status);
		model.setClientID(clientID);
		
		List<Clients> clients = dao.findBy(model);
		
		clients = clients.stream()
						 .collect(Collectors.toList());
			//List<Clients> clientList = dao.findAll(); 
		
		

		
		
		return clients;
	}
	
	
}
