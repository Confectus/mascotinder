package test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import controller.CatalogueController;
import model.dao.DAOFactory;
import model.entities.Owner;
import model.entities.Pet;
import model.entities.PetImage;
import model.entities.Preference;
import model.jpa.JPAPetDAO;

public class JPATableCreation {
	
	public static void main(String[] args)  {
		
		/*
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
			Pet pet = new Pet(null, "mascota" + i, "dog", sex[i % 2], 12 + i, owners.get(i%2));
			DAOFactory.getFactory().getPetDAO().create(pet);
			
			PetImage image = new PetImage(null, fileToBase64String(files.get(i%3)), pet);
			DAOFactory.getFactory().getPetImageDAO().create(image);
			
			PetImage image2 = new PetImage(null, fileToBase64String(files.get(2)), pet);
			DAOFactory.getFactory().getPetImageDAO().create(image2);
			
			Preference preference = new Preference(null, "dog", sex[i % 2], i % 3 + 5, i % 3 + 12, pet);
			DAOFactory.getFactory().getPreferenceDAO().create(preference);
		}
		*/
		
		File directory = new File("img/benjamin 4");
		ArrayList<File> benjamin = getFiles(directory);
		
		directory = new File("img/cheems 8");
		ArrayList<File> cheems = getFiles(directory);
		
		directory = new File("img/milanesa 2");
		ArrayList<File> milanesa = getFiles(directory);
		
		directory = new File("img/pugzilla 6");
		ArrayList<File> pugzilla = getFiles(directory);
		
		directory = new File("img/zoe 6");
		ArrayList<File> zoe = getFiles(directory);
		
		
		ArrayList<Owner> owners = new ArrayList<>();
		//owners.add(new Owner("", "", ""));
		owners.add(new Owner("francisco.encalada01@epn.edu.ec", "Francisco", "rafa123123"));
		owners.add(new Owner("oscarin@gmail.com", "Oscar Polo", "oscar123"));
		owners.add(new Owner("jahaziela@gmail.com", "Jahaziela", "jazi123"));
		owners.add(new Owner("pollito@gmail.com", "Gaby", "gaby123"));
		
		for (Owner owner : owners) {
			DAOFactory.getFactory().getOwnerDAO().create(owner);
		}
		
		//BENJAMIN
		Pet pet = new Pet(null, "Benjamin", "dog", "male", 4, owners.get(1));
		DAOFactory.getFactory().getPetDAO().create(pet);
		
		PetImage image = new PetImage(null, fileToBase64String(benjamin.get(0)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		image = new PetImage(null, fileToBase64String(benjamin.get(1)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		image = new PetImage(null, fileToBase64String(benjamin.get(2)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		
		//CHEEMS
		pet = new Pet(null, "Cheems", "dog", "male", 8, owners.get(2));
		DAOFactory.getFactory().getPetDAO().create(pet);
		
		image = new PetImage(null, fileToBase64String(cheems.get(0)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		image = new PetImage(null, fileToBase64String(cheems.get(1)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		image = new PetImage(null, fileToBase64String(cheems.get(2)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		
		//PUGZILLA
		pet = new Pet(null, "Pugzilla", "dog", "female", 6, owners.get(0));
		DAOFactory.getFactory().getPetDAO().create(pet);
		
		image = new PetImage(null, fileToBase64String(pugzilla.get(0)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		image = new PetImage(null, fileToBase64String(pugzilla.get(1)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		image = new PetImage(null, fileToBase64String(pugzilla.get(2)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		
		//MILANESA
		pet = new Pet(null, "Milanesa", "dog", "female", 2, owners.get(3));
		DAOFactory.getFactory().getPetDAO().create(pet);
		
		image = new PetImage(null, fileToBase64String(milanesa.get(0)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		image = new PetImage(null, fileToBase64String(milanesa.get(1)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		image = new PetImage(null, fileToBase64String(milanesa.get(2)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		
		//ZOE
		pet = new Pet(null, "Zoe", "dog", "female", 2, owners.get(3));
		DAOFactory.getFactory().getPetDAO().create(pet);
		
		image = new PetImage(null, fileToBase64String(zoe.get(0)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		image = new PetImage(null, fileToBase64String(zoe.get(1)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		image = new PetImage(null, fileToBase64String(zoe.get(2)), pet);
		DAOFactory.getFactory().getPetImageDAO().create(image);
		
		
				
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
	
	public static ArrayList<File> getFiles(final File directory) {
		ArrayList<File> files = new ArrayList<>();
	    for (final File fileEntry : directory.listFiles()) {
            files.add(fileEntry);
	    }
	    return files;
	}
	
}
