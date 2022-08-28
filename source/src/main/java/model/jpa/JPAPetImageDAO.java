package model.jpa;

import javax.persistence.Query;
import model.dao.PetImageDAO;
import model.entities.PetImage;

public class JPAPetImageDAO extends JPAGenericDAO<PetImage, Integer> implements PetImageDAO {

	public JPAPetImageDAO() {
		super(PetImage.class);
	}

	@Override
	public PetImage getFirstPetImage(Integer id) {
		PetImage image = null;
		
		String sentenceJPQL = "SELECT i FROM pet_image i WHERE i.pet.id= :pet_id AND i.pet.petImage.id= :image_id";
		Query query = em.createQuery(sentenceJPQL);
		query.setParameter("pet_id", id);
		query.setParameter("image_id", 1);
		
		try {
			image = (PetImage) query.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return image;
	}

}
