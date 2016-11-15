package sma.ia.etour.ontology;

import jade.content.Concept;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Transport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transport.findAll", query = "SELECT t FROM Transport t"),
    @NamedQuery(name = "Transport.findById", query = "SELECT t FROM Transport t WHERE t.id = :id"),
    @NamedQuery(name = "Transport.findByType", query = "SELECT t FROM Transport t WHERE t.typeVeh = :type"),
    @NamedQuery(name = "Transport.findByPrice", query = "SELECT t FROM Transport t WHERE t.price = :price"),
    @NamedQuery(name = "Transport.findByType_Price", query = "SELECT t FROM Transport t WHERE t.typeVeh = :type AND t.price = :price"),
    @NamedQuery(name = "Transport.findAllOrder", query = "SELECT t FROM Transport t ORDER BY t.typeVeh, t.price")})

public class Transport extends Entitie implements Serializable, Concept{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransp", nullable = false)
    private int id;
	@Column(name = "typeVeh", length = 255, nullable = false)
	private String typeVeh;
	@Column(name = "price", nullable = false)
	private double price;
	
	//constructors
	public Transport() { }

	public Transport(String typeVeh, double price) {
		this.typeVeh = typeVeh;
		this.price = price;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTypeVeh() {
		return typeVeh;
	}

	public void setTypeVeh(String typeVeh) {
		this.typeVeh = typeVeh;
	}

	//
	@SuppressWarnings("unchecked")
	public List<Transport> findAllOrder() {
        Query query = DbManager.getEntityManager()
                .createNamedQuery("Transport.findAllOrder");
      try{
        return query.getResultList();
      }catch(NoResultException e){
    	  return null;
      }
    }
	//
	@SuppressWarnings("unchecked")
	public List<Transport> findByType(String type) {
        Query query = DbManager.getEntityManager()
                .createNamedQuery("Transport.findByType")
                .setParameter("type", type);
      try{
        return query.getResultList();
      }catch(NoResultException e){
    	  return null;
      }
    }
	//
	public Transport findByVehicle(String vehicle) {
        Query query = DbManager.getEntityManager()
                .createNamedQuery("Transport.findByVehicle")
                .setParameter("vehicle", vehicle);
      try{
        return (Transport)query.getSingleResult();
      }catch(NoResultException e){
    	  return null;
      }
    }
	//
	@SuppressWarnings("unchecked")
	public List<Transport> findByPrice(double price) {
        Query query = DbManager.getEntityManager()
                .createNamedQuery("Transport.findByPrice")
                .setParameter("price", price);
      try{
        return query.getResultList();
      }catch(NoResultException e){
    	  return null;
      }
    }
	//
	@SuppressWarnings("unchecked")
	public List<Transport> findByType_Price(String type, double price) {
        Query query = DbManager.getEntityManager()
                .createNamedQuery("Transport.findByType_Price")
                .setParameter("type", type)
                .setParameter("price", price);
      try{
        return query.getResultList();
      }catch(NoResultException e){
    	  return null;
      }
    }

}
