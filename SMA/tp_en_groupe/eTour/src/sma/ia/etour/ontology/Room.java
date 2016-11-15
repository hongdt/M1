package sma.ia.etour.ontology;

import jade.content.Concept;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Room")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
		@NamedQuery(name = "Room.findById", query = "SELECT r FROM Room r WHERE r.id = :id"),
		@NamedQuery(name = "Room.findByNum", query = "SELECT r FROM Room r WHERE r.num = :num"),
		@NamedQuery(name = "Room.findByType", query = "SELECT r FROM Room r WHERE r.typeRoom = :type"),
		@NamedQuery(name = "Room.findByType_Price", query = "SELECT r FROM Room r WHERE r.typeRoom = :type AND r.price = :price AND r.hotel.id = :hotel"),
		@NamedQuery(name = "Room.findByHotel", query = "SELECT r FROM Room r WHERE r.hotel.id = :hotel"),
		@NamedQuery(name = "Room.findAllOrder", query = "SELECT r FROM Room r ORDER BY r.num") })
public class Room extends Entitie implements Serializable, Concept {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRoom", nullable = false)
	private int id;
	@Column(name = "typeRoom", length = 100, nullable = false)
	private String typeRoom;
	@Column(name = "num", length = 100, nullable = false)
	private String num;
	@Column(name = "price", nullable = false)
	private double price;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	// constructors
	public Room() {
	}

	public Room(String typeRoom, String num, double price, Hotel hotel) {
		this.typeRoom = typeRoom;
		this.num = num;
		this.price = price;
		this.hotel = hotel;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeRoom() {
		return typeRoom;
	}

	public void setTypeRoom(String typeRoom) {
		this.typeRoom = typeRoom;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	//
	@SuppressWarnings("unchecked")
	public List<Room> findAllOrder() {
		Query query = DbManager.getEntityManager().createNamedQuery(
				"Room.findAllOrder");
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	//
	@SuppressWarnings("unchecked")
	public List<Room> findByHotel(Hotel h) {
		Query query = DbManager.getEntityManager()
				.createNamedQuery("Room.findByHotel")
				.setParameter("hotel", hotel.getId());
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	//
	@SuppressWarnings("unchecked")
	public List<Room> findByType(String type) {
		Query query = DbManager.getEntityManager()
				.createNamedQuery("Room.findByType").setParameter("type", type);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	//
	public Room findByNum(String num) {
		Query query = DbManager.getEntityManager()
				.createNamedQuery("Room.findByNum").setParameter("num", num);
		try {
			return (Room) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	//
	@SuppressWarnings("unchecked")
	public List<Room> findByType_Price(String type, double price, Hotel h) {
		Query query = DbManager.getEntityManager()
				.createNamedQuery("Room.findByType_Price")
				.setParameter("type", type).setParameter("price", price)
				.setParameter("hotel", h.getId());
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

}
