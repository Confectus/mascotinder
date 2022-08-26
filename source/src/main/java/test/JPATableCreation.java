package test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import model.dao.DAOFactory;
import model.entities.Owner;
import model.entities.Pet;
import model.entities.PetImage;

public class JPATableCreation {
	
	public static void main(String[] args)  {
		
		File file1 = new File("../mascotinderConcept2/img/pelusin.jpg");
		File file2 = new File("../mascotinderConcept2/img/pelusin2.jpg");
		File file3 = new File("../mascotinderConcept2/img/pelusin3.jpg");
		
		Owner owner1 = new Owner("francisco.encalada01@epn.edu.ec", "Francisco", "rafa123123");		
		DAOFactory.getFactory().getOwnerDAO().create(owner1);
		
		Pet pt = new Pet(1,"Alpha","x","y",12,owner1);
		Pet pt2 = new Pet(2,"Betha","x","y",12,owner1);
		DAOFactory.getFactory().getPetDAO().create(pt);
		DAOFactory.getFactory().getPetDAO().create(pt2);
		
		
		try {
			PetImage image1 = new PetImage(1,fileToBase64String(file1),pt);
			PetImage image2 = new PetImage(1,fileToBase64String(file2),pt);
			PetImage image3 = new PetImage(1,fileToBase64String(file3),pt);
			
			DAOFactory.getFactory().getPetImageDAO().create(image1);
			DAOFactory.getFactory().getPetImageDAO().create(image2);
			DAOFactory.getFactory().getPetImageDAO().create(image3);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
				
	}
	
	public static String fileToBase64String(File file) throws IOException {
		
		BufferedImage bi = ImageIO.read(file);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageIO.write(bi, "jpg", output);
		
		String imageAsBase64 = Base64.getEncoder().encodeToString(output.toByteArray());
		
		return imageAsBase64;
	}
	
}
