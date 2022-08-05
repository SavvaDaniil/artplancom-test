package com.artplancom2.Service;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.artplancom2.Repository.UserRepository;
import com.artplancom2.Component.HibernateUtil;
import com.artplancom2.Entity.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null)throw new UsernameNotFoundException("not_found");
		return new org.springframework.security.core.userdetails.User(Integer.toString(user.getId()), user.getPassword(), new ArrayList<>());
	}

	public UserDetails loadUserById(int id) throws UsernameNotFoundException {
		User user = userRepository.findById(id);
		if(user == null)throw new UsernameNotFoundException("not_found");
		return new org.springframework.security.core.userdetails.User(Integer.toString(user.getId()), user.getPassword(), new ArrayList<>());
	}
	
	public UserDetails toUserDetails(User user) {
		return new org.springframework.security.core.userdetails.User(Integer.toString(user.getId()), user.getPassword(), new ArrayList<>());
	}
	
	public User findById(int id) {
		return userRepository.findById(id);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
    
    public User findByUsernameExceptId(int userId, String username) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("unchecked")
			Query<User> query = session.createQuery("FROM " + User.class.getSimpleName() 
            		+ " where id != :userId AND username = :username order by id DESC");
            query.setParameter("userId", userId);
            query.setParameter("username", username);
            User user = query.getSingleResult();
            transaction.commit();
            session.close();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
	
	public User add(String username, String passwordHash) {
		Date dateOfAdd = new Date();
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(passwordHash);
		user.setDateOfAdd(new java.sql.Date(dateOfAdd.getTime()));
		
		return add(user);
	}
	
	private User add(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
            return user;
        } catch (Exception e) {
        	System.out.println("Ошибка UserService add Exception: " + e.toString());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
	}
	
    public boolean update(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
    	User user = findById(id);
    	if(user == null)return false;
    	return delete(user);
    }
    
    public boolean delete(User user) {
    	if(user == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(user);

            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
    
    

}
