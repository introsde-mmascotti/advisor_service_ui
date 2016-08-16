package service;

import healthprofile.storage.service.Measure;
import healthprofile.storage.service.Person;

import java.util.Calendar;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import recipestorage.service.Ingredient;
import recipestorage.service.Recipe;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface AdvisorInterface {
		
	@WebMethod
	public Person getPerson(@WebParam(name="person_id") Integer person_id);
	
	@WebMethod
	public List<Measure> getHealthprofile(@WebParam(name="person_id") Integer person_id);
	
	@WebMethod
	public Measure getMeasure(
			@WebParam(name="person_id") Integer person_id,
			@WebParam(name="type") String type);
	
	@WebMethod
	public List<Measure> getMeasureHistory(
			@WebParam(name="person_id") Integer person_id,
			@WebParam(name="type") String type,
			@WebParam(name="from") Calendar from,
			@WebParam(name="from") Calendar to);
	
	@WebMethod
	public Person savePerson(@WebParam(name="person") Person p);
	
	@WebMethod
	public void saveHealthprofile(
			@WebParam(name="person") int person_id,
			@WebParam(name="measures") List<Measure> measures);
	
	@WebMethod
	public void saveMeasure(
			@WebParam(name="person") int person_id,
			@WebParam(name="measure") Measure measure,
			@WebParam(name="update") boolean update);	
	
	/*@WebMethod
	public List<Measure> getRecipe(@WebParam(name="id") Integer id); */
	
	@WebMethod
	public List<Recipe> findRecipe(
			@WebParam(name="search_item") String search_item,
			@WebParam(name="author") String author);
	
	@WebMethod
	public List<Ingredient> findIngredient( @WebParam(name="search_term") String search_term);
	
	@WebMethod
	public Recipe saveRecipe(
			@WebParam(name="recipe") Recipe r);

	@WebMethod
	public Recipe addRecipeIngredient(
			@WebParam(name="recipe") Recipe r,
			@WebParam(name="ingredient") Ingredient ingr,
			@WebParam(name="amount") double amount);
	
	@WebMethod
	public Recipe removeRecipeIngredient(
			@WebParam(name="recipe") Recipe r,
			@WebParam(name="ingredient") Ingredient ingr);
	
	@WebMethod
	public Recipe replaceRecipeIngredient(
			@WebParam(name="recipe") Recipe r,
			@WebParam(name="ingredient") Ingredient ingr,
			@WebParam(name="amount") double amount);

	public String getHealthAdvice(
			@WebParam(name="person") Person p,
			@WebParam(name="recipes") List<Recipe> recipes);

}
