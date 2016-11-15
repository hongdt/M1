package sma.ia.etour.ontology;

import jade.content.Concept;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Hotel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h"),
    @NamedQuery(name = "Hotel.findById", query = "SELECT h FROM Hotel h WHERE h.id = :id"),
    @NamedQuery(name = "Hotel.findByAddress", query = "SELECT h FROM Hotel h WHERE h.address = :address ORDER BY h.address"),
    @NamedQuery(name = "Hotel.findAllOrder", query = "SELECT h FROM Hotel h ORDER BY h.name")})

public class Hotel extends Entitie implements Serializable, Concept {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHotel", nullable = false)
    private int id;	
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
	private List<Room> listRoom = new LinkedList<Room>();
	
	//constructors
	public Hotel() { }

	public Hotel(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Room> getListRoom() {
		return listRoom;
	}

	public void setListRoom(List<Room> listRoom) {
		this.listRoom = listRoom;
	}

	//
	@SuppressWarnings("unchecked")
	public List<Hotel> findByAddress(String address) {
        Query query = DbManager.getEntityManager()
                .createNamedQuery("Hotel.findByAddress")
                .setParameter("address", address);
      try{
        return query.getResultList();
      }catch(NoResultException e){
    	  return null;
      }
    }

	//
	@SuppressWarnings("unchecked")
	public List<Hotel> findAllOrder() {
        Query query = DbManager.getEntityManager()
                .createNamedQuery("Hotel.findAllOrder");
      try{
        return query.getResultList();
      }catch(NoResultException e){
    	  return null;
      }
    }
	
}
