package poly.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.entity.Depart;
import poly.entity.Staff;

@Transactional
@Controller
@RequestMapping("staff")
public class StaffController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		model.addAttribute("staffs", list);
		return "staff/index";

	}

	@RequestMapping(value = "insert",  method = RequestMethod.GET )
	public String insert(ModelMap model) {
		model.addAttribute("staff", new Staff());
		return "staff/insert";

	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model,@Valid
			@ModelAttribute("staff") Staff staff,BindingResult errors) {
		
		if(errors.hasErrors()){
			return"staff/insert";			
		}else{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {

			session.save(staff);
			t.commit();
			model.addAttribute("message", "Them moi thanh cong!!!");
		} catch (Exception ex) {
			t.rollback();
			model.addAttribute("message", "Them moi that bai!!!");
		} finally {
			session.close();
		}
		model.addAttribute("staffs", getStaff());
		return "staff/index";
	}
	}

	public List<Staff> getStaff() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list;

	}

	// sửa
	// lấy data qua trang edit
	@Autowired
	ServletContext context;

	@RequestMapping("{id}update")
	public String edit(ModelMap model, @PathVariable("id") String id)  {
		Session session = factory.getCurrentSession();
		Staff staff = (Staff) session.get(Staff.class, id);
		// map với attribute

		model.addAttribute("staff", staff);
		model.addAttribute("staffs", getStaff());
		return "staff/edit";

	}
	


	@RequestMapping("update")
	// @RequestMapping(params="btnUpdate")
	public String update(ModelMap model,@Valid @ModelAttribute("staff") Staff staff,BindingResult errors) {
		if(errors.hasErrors()){
			return "staff/edit";
		}else{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {			
			session.update(staff);
			t.commit();
			model.addAttribute("message", "Cap nhat thanh cong!!!");

		} catch (Exception ex) {
			t.rollback();
			model.addAttribute("message", "Cap nhat that bai!!!");
		} finally {
			session.close();
		}
		model.addAttribute("staff", staff);
		model.addAttribute("staffs", getStaff());
		return "staff/index";
	}
	}

	// Xử lý XÓA trực tiếp

	@RequestMapping("{id}delete")
	public String delete(ModelMap model, @PathVariable("id") String id) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Staff staff = (Staff) session.get(Staff.class, id);
		// map với attribute
		model.addAttribute("staff", staff);
		model.addAttribute("staffs", getStaff());
		try {
			session.delete(staff);
			t.commit();
			model.addAttribute("message", "Xoa thanh cong!!!");
		} catch (Exception ex) {
			t.rollback();
			model.addAttribute("message", "Xoa that bai!!!");
		} finally {
			session.close();
		}

		model.addAttribute("staffs", getStaff());
		return "staff/index";
	}

//	@RequestMapping("genders")
//	public Map<String, String> getGender() {
//		Map<String, String> genders = new HashMap<>();
//
//		genders.put("Male", "Nam");
//		genders.put("Female", "Nữ");
//		return genders;
//	}

	@ModelAttribute("departs")
	public List<Depart> getDeparts() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Depart";
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
		return list;
	}
//	
	
	//cod mẫu
//	String hql = "SELECT r.staff.id,"+
//			" SUM(case when r.type=1 then 1 else 0 end), "+
//			" SUM(case when r.type=0 then 1 else 0 end)"+
//			" FROM Record r "+
//			" GROUP BY r.staff.id";
	
//r.staff.name
	
	@RequestMapping("report")
	public String report(ModelMap model){
		Session session  = factory.getCurrentSession();
		String hql = "SELECT r.staff.id,r.staff.name,"+
				" SUM(case when r.type=1 then 1 else 0 end), "+
				" SUM(case when r.type=0 then 1 else 0 end)"+
				" FROM Record r inner join r.staff"+
				" GROUP BY r.staff.id,r.staff.name";
		Query query = session.createQuery(hql);
		List <Object[]> list = query.list();
		model.addAttribute("arrays",list);
		return"staff/report";
		
		
	}
}
	
	
//	String hql = "SELECT r.staff.id,r.staff.name,"+
//			" SUM(case when r.type=1 then 1 else 0 end), "+
//			" SUM(case when r.type=0 then 1 else 0 end)"+
//			" FROM Record r inner join r.staff"+
//			" GROUP BY r.staff.id,r.staff.name";
//}
