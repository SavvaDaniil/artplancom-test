package com.artplancom2.Service;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplancom2.Entity.Pet;
import com.artplancom2.Entity.AnimalType;
import com.artplancom2.Entity.User;
import com.artplancom2.Repository.PetRepository;
import com.artplancom2.Component.HibernateUtil;

@Service
public class PetService {


	@Autowired
	PetRepository petRepository;
	
	
	public Pet findById(int id) {
		return petRepository.findById(id);
	}
    
    public Pet findByName(String name) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("unchecked")
			Query<Pet> query = session.createQuery("FROM " + Pet.class.getSimpleName() 
            		+ " where name = :name order by id DESC");
            query.setParameter("name", name);
            Pet pet = query.getSingleResult();
            transaction.commit();
            session.close();
            return pet;
        } catch (NoResultException e) {
        	return null;
        } catch (Exception e) {
        	System.out.println("PetService findByName Exception: " + e);
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
	

    public List<Pet> listAllByUserId(int userId)
    {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            @SuppressWarnings({ "unchecked" })
			Query<Pet> query = session.createQuery("FROM " + Pet.class.getSimpleName() + " where userId = :userId order by id DESC");
			query.setParameter("userId", userId);
            List<Pet> pets = query.getResultList();
            
            return pets;
        } catch (NoResultException e) {
        	return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
	public Pet add(String name, int sex, Date datebirthday, AnimalType animalType, User userOwner) {
		Date dateOfAdd = new Date();
		
		Pet pet = new Pet();
		pet.setName(name);
		pet.setSex(sex);
		pet.setDatebirthday(new java.sql.Date(datebirthday.getTime()));
		pet.setUserOwner(userOwner);
		pet.setAnimalType(animalType);
		pet.setDateOfAdd(new java.sql.Date(dateOfAdd.getTime()));
		pet.setDateOfUpdate(new java.sql.Date(dateOfAdd.getTime()));
		
		return add(pet);
	}
	
	private Pet add(Pet pet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(pet);
            transaction.commit();
            session.close();
            return pet;
        } catch (Exception e) {
        	System.out.println("Ошибка PetService add Exception: " + e.toString());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
	}
	
    public boolean update(Pet pet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(pet);
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
    	Pet pet = findById(id);
    	if(pet == null)return false;
    	return delete(pet);
    }
    
    public boolean delete(Pet pet) {
    	if(pet == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(pet);
            /*
            User User = session.get(User.class, id);
            if (User != null) {
                session.delete(User);
                System.out.println("User is deleted");
            }
            */

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
