package rTour.ontology;

import java.util.Date;
import jade.content.Predicate;

public class Tourism  implements Predicate {
	
	
//	private Broker broker;
	private String quality;
	private Date startDate;
	private Date endDate;
//	private Hotel hotel;
//	private Vehicle vehicleBeginning;
//	private Vehicle vehicleDestmation;
//	private FoodService foodService;
	
	

	private int price;//Prix total du tour
	private int startHour;
	private int endHour;
	private String addressDestination;
	
	private String addressBegining;
	
	private int countDayAtHotel;
	private int sumPriceHotel;
	private int sumpriceVehicle;
	private int sumPriceFoodService;
	
	private int countMember;
	private int countDay;
	private String nameTour;
	private String code;
	private String status;
	
//	public Vehicle getVehicleBeginning() {
//		return vehicleBeginning;
//	}
//	public void setVehicleBeginning(Vehicle vehicleBeginning) {
//		this.vehicleBeginning = vehicleBeginning;
//	}
//	public Vehicle getVehicleDestmation() {
//		return vehicleDestmation;
//	}
//	public void setVehicleDestmation(Vehicle vehicleDestmation) {
//		this.vehicleDestmation = vehicleDestmation;
//	}

	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	public String getAddressDestination() {
		return addressDestination;
	}
	public void setAddressDestination(String addressDestination) {
		this.addressDestination = addressDestination;
	}
	public String getAddressBegining() {
		return addressBegining;
	}
	public void setAddressBegining(String addressBegining) {
		this.addressBegining = addressBegining;
	}
	
//	public Hotel getHotel() {
//		return hotel;
//	}
//	public void setHotel(Hotel hotel) {
//		this.hotel = hotel;
//	}
//	
//	public FoodService getFoodService() {
//		return foodService;
//	}
//	public void setFoodService(FoodService foodService) {
//		this.foodService = foodService;
//	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQualityInt() {
		if (quality.equalsIgnoreCase("vip"))
		{
			return 1;
		}
		else if (quality.equalsIgnoreCase("Bình thường"))
		{
			return 2;
		}
		else 
		{
			return 3;
		}
	}
	
	public int getCountDayAtHotel() {
		return countDayAtHotel;
	}
	public void setCountDayAtHotel(int countDayAtHotel) {
		this.countDayAtHotel = countDayAtHotel;
	}
	public int getSumPriceHotel() {
		return sumPriceHotel;
	}
	public void setSumPriceHotel(int sumPriceHotel) {
		this.sumPriceHotel = sumPriceHotel;
	}
	public int getSumpriceVehicle() {
		return sumpriceVehicle;
	}
	public void setSumpriceVehicle(int sumpriceVehicle) {
		this.sumpriceVehicle = sumpriceVehicle;
	}
	public int getSumPriceFoodService() {
		return sumPriceFoodService;
	}
	public void setSumPriceFoodService(int sumPriceFoodService) {
		this.sumPriceFoodService = sumPriceFoodService;
	}
//	public Broker getBroker() {
//		return broker;
//	}
//	public void setBroker(Broker broker) {
//		this.broker = broker;
//	}
	public int getCountMember() {
		return countMember;
	}
	public void setCountMember(int countMember) {
		this.countMember = countMember;
	}
	public String getNameTour() {
		return nameTour;
	}
	public void setNameTour(String nameTour) {
		this.nameTour = nameTour;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCountDay() {
		return countDay;
	}
	public void setCountDay(int countDay) {
		this.countDay = countDay;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
