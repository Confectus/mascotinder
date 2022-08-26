package test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import javax.imageio.ImageIO;

import model.dao.DAOFactory;
import model.entities.Owner;
import model.entities.Pet;
import model.entities.PetImage;
import model.entities.Preference;

public class JPATableCreation {
	
	public static void main(String[] args)  {
		
		
		ArrayList<File> files = new ArrayList<>();
		files.add(new File("img/pelusin.jpg"));
		files.add(new File("img/pelusin2.jpg"));
		files.add(new File("img/pelusin3.jpg"));
		
		ArrayList<Owner> owners = new ArrayList<>();
		owners.add(new Owner("francisco.encalada01@epn.edu.ec", "Francisco", "rafa123123"));
		owners.add(new Owner("ejemplo@gmail.com", "Carlos Iñiguez", "123"));
		
		for (Owner owner : owners) {
			DAOFactory.getFactory().getOwnerDAO().create(owner);
		}
		
		
		String[] sex = {"male","female"};
		for (int i=0;i<15;i++) {
			Pet pet = new Pet(null, "mascota" + 1, "a", "y", 12 + i, owners.get(i%2));
			DAOFactory.getFactory().getPetDAO().create(pet);
			
			PetImage image = new PetImage(null, fileToBase64String(files.get(i%3)), pet);
			DAOFactory.getFactory().getPetImageDAO().create(image);
			
			Preference preference = new Preference(null, "dog", sex[i % 2], i % 3 + 5, i % 3 + 8, pet);
			DAOFactory.getFactory().getPreferenceDAO().create(preference);
		}
		
				
	}
	
	public static String fileToBase64String(File file) {
		
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
