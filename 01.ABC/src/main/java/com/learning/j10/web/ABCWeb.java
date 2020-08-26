package com.learning.j10.web;

import static com.learning.j10.utility.Utility.isNull;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.j10.model.ABC;
import com.learning.j10.service.ABCService;;

/**
 * Servlet implementation class ABCWeb
 */
public class ABCWeb extends _AbstractWeb {
	private static final long serialVersionUID = 1L;

    public ABCWeb() {
    }
	protected void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String author = isNull(request::getParameter, "author", "suraj kalika");
		String displayMode = isNull(request::getParameter, "displaymode", "abc");
		String highlight = isNull(request::getParameter, "highlight", "abc");

		ABCService service = new ABCService();
		ABC[] data = service.getAlphabets(displayMode, highlight);
		
		
		request.setAttribute("abc", data);
		request.setAttribute("author", author);
		request.setAttribute("displaymode", displayMode);

		
		redirect("/WEB-INF/abc.jsp", request, response);
	}

}
