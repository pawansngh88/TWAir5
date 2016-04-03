package com.twair;

public class TravelClass {
    private ClassType classType;
    private Integer totalSeats;
    private Integer occupiedSeats;
    private Double basePrice;

    public TravelClass(ClassType classType, Integer totalSeats, Double basePrice) {
        this.classType = classType;
        this.totalSeats = totalSeats;
        this.occupiedSeats = 0;
        this.basePrice = basePrice;
    }

    public void book(int numberOfSeats) throws Exception {
        if(canBook(numberOfSeats) == false) {
            throw new Exception("Booking can not be made");
        }
        occupiedSeats += numberOfSeats;
    }

    public boolean canBook(Integer numberOfSetas) {
        if(occupiedSeats + numberOfSetas > totalSeats) {
            return false;
        }
        return true;
    }

    public ClassType getClassType() {
        return classType;
    }

    public Double getBasePrice() {
        return basePrice;
    }
    private Double getOccupancyRatio() {
        if (this.totalSeats ==0) return 0.0;
        return this.occupiedSeats *100.0/this.totalSeats;
    }
    private Double getMultiplicativeFactor(Double occupiedRatio) {
        if (occupiedRatio <=0.4) return 1.0;
        else if(occupiedRatio >0.4 && occupiedRatio <=0.6) return 1.3;

        return 1.6;
    }

    public Double getEffectivePrice(int numberOfSeats) {
        if(classType==ClassType.ECONOMY) {
            return getMultiplicativeFactor(getOccupancyRatio()) *getBasePrice() * numberOfSeats;
        }else {
            return getBasePrice() * numberOfSeats;
        }
    }
}
