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
        return ((double)this.occupiedSeats )/this.totalSeats;
    }
    private Double getMultiplicativeFactor(Double occupiedRatio) {
        //System.out.println(occupiedRatio);
        if (occupiedRatio <=0.4) return 0.0;
        else if(occupiedRatio >0.4 && occupiedRatio <=0.6) return 0.3;

        return 0.6;
    }

    public Double getEffectivePrice(int numberOfSeats) {
        Double additionalFare = 0.0;
        if(classType==ClassType.ECONOMY) {
            additionalFare = getMultiplicativeFactor(getOccupancyRatio());
        }

        return  getBasePrice()* (1 + additionalFare) * numberOfSeats;
    }
}
