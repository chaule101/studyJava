package poly.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import poly.entity.Record;
import poly.entity.Staff;


@Transactional
@Controller
@RequestMapping("record")
public class RecordController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Record";
		Query query = session.createQuery(hql);
		List<Record> list = query.list();
		model.addAttribute("records", list);
		return "record/index";

	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("record", new Record());
		return "record/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("record") Record record) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			record.setDate(new Date());
			session.save(record);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại !");
		} finally {
			session.close();
		}
		model.addAttribute("records", getRecords());
		
		return "record/index";
	}

	@ModelAttribute("records")
	public List<Record> getRecords() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Record";
		Query query = session.createQuery(hql);
		List<Record> list = query.list();
		return list;
	}

	@RequestMapping("{id}delete")
	public String delete(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Record record = (Record) session.get(Record.class, id);
		// map với attribute
		model.addAttribute("record", record);
		model.addAttribute("records", getRecords());
		try {
			session.delete(record);
			t.commit();
			model.addAttribute("message", "Xoa thanh cong!!!");
		} catch (Exception ex) {
			t.rollback();
			model.addAttribute("message", "Xoa that bai!!!");
		} finally {
			session.close();
		}
		model.addAttribute("records", getRecords());
		return "record/index";
	}

	@RequestMapping("{id}update")
	public String edit(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.getCurrentSession();
		Record record = (Record) session.get(Record.class, id);
		// map với attribute
		model.addAttribute("record", record);
		model.addAttribute("records", getRecords());
		return "record/edit";
	}

	@RequestMapping("update")
	// @RequestMapping(params="btnUpdate")
	public String update(ModelMap model, @ModelAttribute("record") Record record) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(record);

			t.commit();
			model.addAttribute("message", "Cap nhat thanh cong!!!");

		} catch (Exception ex) {
			t.rollback();
			model.addAttribute("message", "Cap nhat that bai!!!");
		} finally {
			session.close();
		}
		model.addAttribute("record", record);
		model.addAttribute("records", getRecords());
		return "record/index";
	}
	
	@ModelAttribute("staffs")
	public List<Staff> getStaffs() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list;
	}
	
	@ModelAttribute("types")
	public Map<Integer, String> getType() {
		Map<Integer, String> types = new HashMap<>();
		types.put(0, "Thành Tích");
		types.put(1, "Kỉ Luật");
		return types;
	}
}
