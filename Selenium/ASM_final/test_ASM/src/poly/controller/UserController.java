package poly.controller;

import java.util.List;

import javax.persistence.QueryHint;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.ehcache.hibernate.HibernateUtil;
import poly.entity.User;

@Transactional
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		model.addAttribute("users", list);
		return "user/index";

	}
//
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("user", new User());
		return "user/insert";

	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model,@Valid @ModelAttribute("user") User user,BindingResult errors) {
		if(errors.hasErrors()){
			return "user/insert";
		}else{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(user);
			t.commit();
			model.addAttribute("message", "Them moi thanh cong!!!");
		} catch (Exception ex) {
			t.rollback();
			model.addAttribute("message", "Them moi that bai!!!");
		} finally {
			session.close();
		}
		model.addAttribute("users", getUser());
		return "user/index";
	}
	}

	public List<User> getUser() {
		Session session = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		return list;

	}

	// sửa
	// lấy data qua trang edit
	@RequestMapping("{id}update")
	public String edit(ModelMap model, @PathVariable("id") String id) {
		Session session = factory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		// map với attribute
		model.addAttribute("user", user);
		model.addAttribute("users", getUser());
		return "user/edit";

	}

	@RequestMapping("update")
	// @RequestMapping(params="btnUpdate")
	public String update(ModelMap model,@Valid @ModelAttribute("user") User user, BindingResult errors) {
		if(errors.hasErrors()){
			return "user/edit";
		}else{
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(user);

			t.commit();
			model.addAttribute("message", "Cap nhat thanh cong!!!");

		} catch (Exception ex) {
			t.rollback();
			model.addAttribute("message", "Cap nhat that bai!!!");
		} finally {
			session.close();
		}
		model.addAttribute("user", user);
		model.addAttribute("users", getUser());
		return "user/index";
	}
	}

	// Xử lý XÓA trực tiếp

	@RequestMapping("{id}delete")
	public String delete(ModelMap model, @PathVariable("id") String id) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		User user = (User) session.get(User.class, id);
		// map với attribute
		model.addAttribute("user", user);
		model.addAttribute("users", getUser());
		try {
			session.delete(user);
			t.commit();
			model.addAttribute("message", "Xoa thanh cong!!!");
		} catch (Exception ex) {
			t.rollback();
			model.addAttribute("message", "Xoa that bai!!!");
		} finally {
			session.close();
		}

		model.addAttribute("users", getUser());
		return "user/index";
	}
	
//	public boolean validate(String userName, String password) {
//
//        Transaction transaction = null;
//        User user = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            // get an user object
//            user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName)
//                .uniqueResult();
//
//            if (user != null && user.getPassword().equals(password)) {
//                return true;
//            }
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//        return false;
//    }
}

//	public List<User> search(@RequestParam("keyword") String keyword) {
//		Session session = factory.getCurrentSession();
//		String hql = "Select c From User c where c.name LIKE '%' || :keyword";
//		Query query = session.createQuery(hql);
//		List<User> list = query.list();
//		return list;
//
//	}
//
//	@RequestMapping("search")
//	// @RequestMapping(params="btnUpdate")
//	public String search(ModelMap model, @ModelAttribute("user") User user) {
//		Session session = factory.openSession();
//		Transaction t = session.beginTransaction();
//		try {
//			String sql = "Select c From User c where c.name LIKE '%' || :keyword";
//			session.createSQLQuery(sql);
//
//			t.commit();
//			model.addAttribute("message", "Cap nhat thanh cong!!!");
//
//		} catch (Exception ex) {
//			t.rollback();
//			model.addAttribute("message", "Cap nhat that bai!!!");
//		} finally {
//			session.close();
//		}
//		model.addAttribute("user", user);
//		model.addAttribute("users", getUser());
//		return "user/search";
//	}

	
	