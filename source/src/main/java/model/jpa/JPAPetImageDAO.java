package model.jpa;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.Query;

import model.dao.PetImageDAO;
import model.entities.Pet;
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
		} catch (Exception e) {
			e.printStackTrace();
		}

		return image;
	}

	@Override
	public void createImagesNewPet(String image1, String image2, String image3, Pet newPet) {
		/*
		 * Method that add images to directory "new_img_pet", create a new directory
		 * with image1, image2, image3
		 */
		String path = "C:\\proyectos\\mascotinder\\source\\img_new_pets\\";
		String pathImage1 = path + image1;
		String pathImage2 = path + image2;
		String pathImage3 = path + image3;

		String[] pathsImages = { pathImage1, pathImage2, pathImage3 };

		/* Get files of "pathsImages" */
		List<File> images = getImages(pathsImages);
		/* Create images of the pet */
		for (int i = 0; i < images.size(); i++) {
			PetImage image = new PetImage(null, fileToBase64String(images.get(i)), newPet);
			create(image);
		}
	}

	private List<File> getImages(String[] pathsImages) {
		ArrayList<File> images = new ArrayList<File>();
		for (int i = 0; i < pathsImages.length; i++) {
			File image = new File(pathsImages[i]);
			if (image.exists()) {
				images.add(image);
			} else {
				System.out.println("The image doesn't exist");
			}
		}
		return images;
	}

	private String fileToBase64String(File file) {

		BufferedImage bi;
		try {
			bi = ImageIO.read(file);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			ImageIO.write(bi, "jpg", output);
			String imageAsBase64 = Base64.getEncoder().encodeToString(output.toByteArray());
			return imageAsBase64;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
