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

	public static void main(String[] args) {

		/*
		 * ArrayList<File> files = new ArrayList<>(); files.add(new
		 * File("img/pelusin.jpg")); files.add(new File("img/pelusin2.jpg"));
		 * files.add(new File("img/pelusin3.jpg"));
		 * 
		 * ArrayList<Owner> owners = new ArrayList<>(); owners.add(new
		 * Owner("francisco.encalada01@epn.edu.ec", "Francisco", "rafa123123"));
		 * owners.add(new Owner("ejemplo@gmail.com", "Carlos Iñiguez", "123"));
		 * 
		 * for (Owner owner : owners) {
		 * DAOFactory.getFactory().getOwnerDAO().create(owner); }
		 * 
		 * 
		 * String[] sex = {"male","female"}; for (int i=0;i<15;i++) { Pet pet = new
		 * Pet(null, "mascota" + i, "dog", sex[i % 2], 12 + i, owners.get(i%2));
		 * DAOFactory.getFactory().getPetDAO().create(pet);
		 * 
		 * PetImage image = new PetImage(null, fileToBase64String(files.get(i%3)), pet);
		 * DAOFactory.getFactory().getPetImageDAO().create(image);
		 * 
		 * PetImage image2 = new PetImage(null, fileToBase64String(files.get(2)), pet);
		 * DAOFactory.getFactory().getPetImageDAO().create(image2);
		 * 
		 * Preference preference = new Preference(null, "dog", sex[i % 2], i % 3 + 5, i
		 * % 3 + 12, pet);
		 * DAOFactory.getFactory().getPreferenceDAO().create(preference); }
		 */

		ArrayList<ArrayList<File>> allFiles = new ArrayList<ArrayList<File>>();

		File directory = new File("img/benjamin 4");
		allFiles.add(getFiles(directory));

		directory = new File("img/cheems 8");
		allFiles.add(getFiles(directory));

		directory = new File("img/pugzilla 6");
		allFiles.add(getFiles(directory));

		directory = new File("img/milanesa 2");
		allFiles.add(getFiles(directory));

		directory = new File("img/zoe 6");
		allFiles.add(getFiles(directory));
		
		directory = new File("img/Simurdiera 4");
		allFiles.add(getFiles(directory));

		ArrayList<Owner> owners = new ArrayList<>();

		// owners.add(new Owner("", "", ""));
		owners.add(new Owner("francisco.encalada01@epn.edu.ec", "Francisco", "rafa123"));
		owners.add(new Owner("jonathan.puglla@epn.edu.ec", "Jonathan", "jonathan123"));
		owners.add(new Owner("andres.lozano@epn.edu.ec", "Andrés", "andres123"));
		owners.add(new Owner("pollito@gmail.com", "Gaby", "gaby123"));

		for (Owner owner : owners) {
			DAOFactory.getFactory().getOwnerDAO().create(owner);
		}

		ArrayList<Pet> pets = new ArrayList<>();

		// PETS
		// pets.add(new Pet(null, "", "dog", "", , owners.get()));
		pets.add(new Pet(null, "Benjamin", "dog", "male", 4, owners.get(1)));
		pets.add(new Pet(null, "Cheems", "dog", "male", 8, owners.get(2)));
		pets.add(new Pet(null, "Pugzilla", "dog", "female", 6, owners.get(0)));
		pets.add(new Pet(null, "Milanesa", "dog", "female", 2, owners.get(3)));
		pets.add(new Pet(null, "Zoe", "dog", "female", 2, owners.get(3)));
		pets.add(new Pet(null, "Simurdiera", "dog", "male", 4, owners.get(2)));

		// Auto setting the preferences
		for (Pet pet : pets) {
			DAOFactory.getFactory().getPetDAO().create(pet);
			Preference preference = new Preference(null, "dog", changeSex(pet.getSex()), 1, 20, pet);
			DAOFactory.getFactory().getPreferenceDAO().create(preference);
		}

		// Adding the images

		int i = 0;
		for (ArrayList<File> arrayList : allFiles) {
			for (File file : arrayList) {
				PetImage image = new PetImage(null, fileToBase64String(file), pets.get(i));
				DAOFactory.getFactory().getPetImageDAO().create(image);
			}
			i++;
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

	public static ArrayList<File> getFiles(final File directory) {
		ArrayList<File> files = new ArrayList<>();
		for (final File fileEntry : directory.listFiles()) {
			files.add(fileEntry);
		}
		return files;
	}

	public static String changeSex(String sex) {
		if (sex == "male") {
			return "female";
		} else {
			return "male";
		}
	}

}
