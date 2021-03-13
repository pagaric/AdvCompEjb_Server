package fmk.persistence;

import java.util.ArrayList;
import java.util.List;

import edu.aisl08.advcomp.authentification.AdvcompException;

/**
 * Base des DAO par entité
 * 
 * @author philippe
 *
 * @param <ENTITY_TYPE>
 * @param <ID_TYPE>
 */
public interface EntityDao<ENTITY_TYPE, ID_TYPE> {

	public ENTITY_TYPE create(ENTITY_TYPE entity) throws AdvcompException;
	
	public ENTITY_TYPE retrieve(ID_TYPE id) throws AdvcompException;
	
	public ENTITY_TYPE update(ENTITY_TYPE entity) throws AdvcompException;
	
	public void delete(ENTITY_TYPE entity) throws AdvcompException;
	
	default List<ENTITY_TYPE> retrieveAll() throws AdvcompException {
		return new ArrayList<ENTITY_TYPE>();
	}
	
	public ENTITY_TYPE getNew() throws AdvcompException;
}
