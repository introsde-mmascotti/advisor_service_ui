package service;

import healthprofile.storage.service.HealthProfileService;
import healthprofile.storage.service.HealthProfileServiceService;
import healthprofile.storage.service.Measure;
import healthprofile.storage.service.Person;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import recipe.service.RecipeOperation;
import recipe.service.RecipeOperationService;
import recipestorage.service.Ingredient;
import recipestorage.service.Recipe;
import advisor.service.AdvisorService;
import advisor.service.AdvisorServiceService;

@WebService
public class Advisor implements AdvisorInterface {
	
	private static final Logger logger = LogManager.getFormatterLogger("AdvisorInterfaceUI");


	@Override
	public Person savePerson(Person p) {
		HealthProfileServiceService service = new HealthProfileServiceService();
		HealthProfileService port = service.getHealthProfileServicePort();
		
		Integer id = port.createPerson(p);
		logger.info("Saved person with id=%d: %s", id, p);
		return port.getPersonById(id);
	}

	@Override
	public void saveHealthprofile(int person_id, List<Measure> measures) {
		HealthProfileServiceService service = new HealthProfileServiceService();
		HealthProfileService port = service.getHealthProfileServicePort();
		
		Person p = port.getPersonById(new Integer(person_id));
		
		logger.info("Saving healthprofile for person %s", p);
		for (int i = 0; i < measures.size(); i++){
			logger.info("Adding measure %s", measures.get(i) );
			port.addMeasureToHealthprofile(p, measures.get(i));
		}
	}

	@Override
	public void saveMeasure(int person_id, Measure measure, boolean update) {
		HealthProfileServiceService service = new HealthProfileServiceService();
		HealthProfileService port = service.getHealthProfileServicePort();
		
		Person p = port.getPersonById(new Integer(person_id));
		
		logger.info("Saving measure %s for person id %d", measure, person_id );
		if (update) {
			port.updateMeasure(measure);
			logger.info("Updating measure %s for person id %d", measure, person_id );
		}
		else {
			port.addMeasureToHealthprofile(p, measure);
			logger.info("Saving measure %s for person id %d", measure, person_id );
		}
	}

	@Override
	public List<Recipe> findRecipe(String search_item, String author) {
		RecipeOperationService service = new RecipeOperationService();
		RecipeOperation port = service.getRecipeOperationPort();
		
		logger.info("Searching recipes: " + search_item);
		return port.findRecipe(search_item, author);
	}

	@Override
	public List<Ingredient> findIngredient(String search_term) {
		RecipeOperationService service = new RecipeOperationService();
		RecipeOperation port = service.getRecipeOperationPort();
		
		logger.info("Searching ingredients: " + search_term);
		return port.findIngredient(search_term);
	}

	@Override
	public Recipe saveRecipe(Recipe r) {
		RecipeOperationService service = new RecipeOperationService();
		RecipeOperation port = service.getRecipeOperationPort();
	
		logger.info("Saving recipe %s", r);
		return port.saveRecipe(r);
	}

	@Override
	public Recipe addRecipeIngredient(Recipe r, Ingredient ingr, double amount) {
		RecipeOperationService service = new RecipeOperationService();
		RecipeOperation port = service.getRecipeOperationPort();
		
		logger.info("Adding to recipe %s ingredient %s (amount %f)", r, ingr, amount);
		r = port.updateRecipeIngredients(r, ingr, amount);
		return r;
	}

	@Override
	public Recipe removeRecipeIngredient(Recipe r, Ingredient ingr) {
		RecipeOperationService service = new RecipeOperationService();
		RecipeOperation port = service.getRecipeOperationPort();
		
		logger.info("Removing from recipe %s ingredient %s", r, ingr);
		r = port.updateRecipeIngredients(r, ingr, null);
		return r;
	}

	@Override
	public Recipe replaceRecipeIngredient(Recipe r, Ingredient ingr, double amount) {
		RecipeOperationService service = new RecipeOperationService();
		RecipeOperation port = service.getRecipeOperationPort();
		
		logger.info("Recipe %s: Changing amount of ingredient %s to %f", r, ingr, amount);
		r = port.updateRecipeIngredients(r, ingr, null);
		r = port.updateRecipeIngredients(r, ingr, amount);
		return r;
	}

	@Override
	public String getHealthAdvice(Person p, List<Recipe> recipes) {
		AdvisorServiceService service = new AdvisorServiceService();
		AdvisorService port = service.getAdvisorServicePort();
		
		StringBuilder result = new StringBuilder();
		logger.info("Getting health advice for %s", p);
		
		result.append("FITNESS:\n");
		result.append(port.getFitnessAdvice(p.getId()));
		result.append("\nWEIGHT:\n");
		result.append(port.getWeightAdvice(p.getId()));
		result.append("\nABOUT YOUR SELECTED MEALS:\n");
		result.append(port.getMealAdvice(p, recipes));
		
		logger.debug(result.toString());
		return result.toString();		
	}

	@Override
	public Person getPerson(Integer person_id) {
		HealthProfileServiceService service = new HealthProfileServiceService();
		HealthProfileService port = service.getHealthProfileServicePort();

		logger.debug("Getting person with id: " + person_id);
		return port.getPersonById(person_id);
	}

	@Override
	public List<Measure> getHealthprofile(Integer person_id) {
		HealthProfileServiceService service = new HealthProfileServiceService();
		HealthProfileService port = service.getHealthProfileServicePort();

		logger.debug("Getting healthprofile for person with id: " + person_id);
		return port.getHealthProfile(person_id);
	}

	/*@Override
	public List<Measure> getRecipe(Integer id) {
		RecipeOperationService service = new RecipeOperationService();
		RecipeOperation port = service.getRecipeOperationPort();
		
		Recipe r = port.
		return null;
	}*/

	@Override
	public Measure getMeasure(Integer person_id, String type) {
		HealthProfileServiceService service = new HealthProfileServiceService();
		HealthProfileService port = service.getHealthProfileServicePort();
		
		Measure ret = port.getMeasure(person_id, type);
		logger.debug("Getting %s for person %d", type, person_id);
		return ret;
	}

	@Override
	public List<Measure> getMeasureHistory(Integer person_id, String type, Calendar from, Calendar to) {
		HealthProfileServiceService service = new HealthProfileServiceService();
		HealthProfileService port = service.getHealthProfileServicePort();
		return port.getMeasureHistory(person_id, type, toXMLCal(from), toXMLCal(to));
	}

	private XMLGregorianCalendar toXMLCal(Calendar c){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeInMillis(c.getTimeInMillis());
		XMLGregorianCalendar ret = null;
		try {
			ret = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
