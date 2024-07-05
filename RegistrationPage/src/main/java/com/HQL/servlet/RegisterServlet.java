package com.HQL.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HQL.conn.HibernateUtil;
import com.HQL.dao.EmpDao;
import com.HQL.entity.Emp;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String Name = req.getParameter("name");
		String Depatment = req.getParameter("depatment");
		String Salary = req.getParameter("salary");
		String Email = req.getParameter("email");
		String Password = req.getParameter("password");

		Emp emp = new Emp(Name, Depatment, Salary, Email, Password);

		System.out.println(emp);

		EmpDao dao = new EmpDao(HibernateUtil.getSessionFactory());

		boolean f = dao.saveEmp(emp);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("msg", "Emp register sucessfully");
			System.out.println("Emp register sucessfully");
		} else {
			session.setAttribute("msg", "Something wrong on server");
			System.out.println("Something wrong on server");
		}
		
		resp.sendRedirect("index.jsp");

	}

}
