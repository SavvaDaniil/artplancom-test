package com.artplancom2.Service;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplancom2.Component.HibernateUtil;
import com.artplancom2.Entity.AnimalType;
import com.artplancom2.Repository.AnimalTypeRepository;

@Service
public class AnimalTypeService {

	@Autowired
	AnimalTypeRepository animalTypeRepository;

	public AnimalType findById(int id) {
		return animalTypeRepository.findById(id);
	}

    public AnimalType findByName(String animalTypeName)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings({ "unchecked" })
			Query<AnimalType> query = session.createQuery("FROM " + AnimalType.class.getSimpleName() + " where title = :animalTypeName order by id DESC");
			query.setParameter("animalTypeName", animalTypeName);
            AnimalType animalType = (AnimalType)query.getSingleResult();
            transaction.commit();
            session.close();
            return animalType;
        } catch (NoResultException e) {
        	return null;
        } catch (Exception e) {
        	System.out.println("AnimalTypeService findByName Exception: " + e);
            e.printStackTrace();
        }
        return null;
    }

    public AnimalType findByNameExceptId(int animalTypeId, String title)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings({ "unchecked" })
			Query<AnimalType> query = session.createQuery("FROM " + AnimalType.class.getSimpleName() + " where id != :animalTypeId"
					+ " AND title = :name order by id DESC");
			query.setParameter("animalTypeId", animalTypeId);
			query.setParameter("title", title);
            AnimalType animalType = query.getSingleResult();
            transaction.commit();
            session.close();
            return animalType;
        } catch (NoResultException e) {
        	return null;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

	public AnimalType add(String name) {
		AnimalType animalType = new AnimalType();
		animalType.setTitle(name);
		
		return add(animalType);
	}
	
	private AnimalType add(AnimalType animalType) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(animalType);
            transaction.commit();
            session.close();
            return animalType;
        } catch (Exception e) {
        	System.out.println("Ошибка PetService add Exception: " + e.toString());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
	}
	
    public boolean update(AnimalType animalType) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(animalType);
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
    	AnimalType animalType = findById(id);
    	if(animalType == null)return false;
    	return delete(animalType);
    }
    
    public boolean delete(AnimalType animalType) {
    	if(animalType == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(animalType);

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
	
    public List<AnimalType> listAll()
    {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            @SuppressWarnings({ "unchecked" })
			Query<AnimalType> query = session.createQuery("FROM " + AnimalType.class.getSimpleName() + " order by id DESC");
            List<AnimalType> animalTypes = query.getResultList();
            
            return animalTypes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
