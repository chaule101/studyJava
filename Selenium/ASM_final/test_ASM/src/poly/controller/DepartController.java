package poly.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.entity.Depart;

@Transactional
@Controller
@RequestMapping("depart")
public class DepartController {
	@Autowired
	SessionFactory factory;
	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Depart";
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
		model.addAttribute("departs", list);
		return "depart/index";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("depart", new Depart());
		return "depart/insert";

	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("depart") Depart depart) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(depart);
			t.commit();
			model.addAttribute("message", "Them moi thanh cong!!!");
		} catch (Exception ex) {
			t.rollback();
			model.addAttribute("message", "Them moi that bai!!!");
		} finally {
			session.close();
		}
		model.addAttribute("departs", getDepart());
		return "depart/index";
	}

	public List<Depart> getDepart() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Depart";
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
		return list;

	}
	
	//sửa
	//lấy data qua trang edit
	@RequestMapping("{id}update")
	public String edit (ModelMap model , @PathVariable("id") String id){
		Session session = factory.getCurrentSession();
		Depart depart = (Depart) session.get(Depart.class, id);
		//map với attribute
		model.addAttribute("depart",depart);
		model.addAttribute("departs", getDepart());
		return "depart/edit";
		
	}
	@RequestMapping("update")
//	@RequestMapping(params="btnUpdate")
	public String update(ModelMap model, @ModelAttribute("depart") Depart depart) {		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(depart);
			t.commit();
			model.addAttribute("message", "Cap nhat thanh cong!!!");
		
		} catch (Exception ex) {
			t.rollback();
			model.addAttribute("message", "Cap nhat that bai!!!");
		} finally {
			session.close();
		}
		model.addAttribute("depart",depart);
		model.addAttribute("departs", getDepart());
		return "depart/index";
	}
	
	
	
	//Xử lý XÓA trực tiếp
	
	@RequestMapping("{id}delete")
	public String delete (ModelMap model , @PathVariable("id") String id){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Depart depart = (Depart) session.get(Depart.class, id);
		//map với attribute
		model.addAttribute("depart", depart);
		model.addAttribute("departs", getDepart());
		try {
			session.delete(depart);
			t.commit();
			model.addAttribute("message", "Xoa thanh cong!!!");
		} catch (Exception ex) {
			t.rollback();
			model.addAttribute("message", "Xoa that bai!!!");
		} finally {
			session.close();
		}
	
		model.addAttribute("departs", getDepart());
		return "depart/index";
	}
	
}
