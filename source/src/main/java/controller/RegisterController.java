package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DAOFactory;
import model.entities.Owner;
import model.entities.Pet;
import model.entities.PetImage;
import model.entities.Preference;

@WebServlet("/RegisterController")

public class RegisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Get parameters
		// 2. Talk with the model
		// 3. Send data to the view
		/* Get all types and numbers of the ages */
		List<String> types = DAOFactory.getFactory().getPetDAO().getTypes();
		request.setAttribute("types", types);
		getServletContext().getRequestDispatcher("/jsp/Register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Get parameters
		String name = request.getParameter("pet_name");
		String type = request.getParameter("pet_type");
		String sex = request.getParameter("pet_sex");
		int age = Integer.parseInt(request.getParameter("pet_age"));
		Owner sessionOwner = (Owner) request.getSession().getAttribute("loggedOwner");
		String image1 = request.getParameter("pet_image_1");
		String image2 = request.getParameter("pet_image_2");
		String image3 = request.getParameter("pet_image_3");
		Pet newPet = new Pet(0, name, type, sex, age, sessionOwner);
		// 2. Talk with the model
		DAOFactory.getFactory().getPetDAO().create(newPet);
		/*Creation of the preference of the new pet*/
		newPet.setPreference(new Preference(null, type, changeSex(sex), 1, 20, newPet));
		Preference preferencePet = newPet.getPreference();
		DAOFactory.getFactory().getPreferenceDAO().create(preferencePet);
		/*Creating of the images of the new pet*/
		createImagesNewPet(image1, image2, image3, newPet);

		// 3. Send data to the view
		getServletContext().getRequestDispatcher("/ListPetsController").forward(request, response);
	}

	private String changeSex(String sex) {
		if (sex == "male") {
			return "female";
		} else {
			return "male";
		}
	}

	private void createImagesNewPet(String image1, String image2, String image3, Pet newPet) {
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
			DAOFactory.getFactory().getPetImageDAO().create(image);
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
