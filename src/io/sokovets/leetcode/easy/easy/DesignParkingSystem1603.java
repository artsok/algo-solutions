package io.sokovets.leetcode.easy.easy;

/**
 * Design a parking system for a parking lot. The parking lot has three kinds of parking spaces: big, medium, and small, with a fixed number of slots for each size.
 * <p>
 * Implement the ParkingSystem class:
 * <p>
 * ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem class. The number of slots for each parking space are given as part of the constructor.
 * bool addCar(int carType) Checks whether there is a parking space of carType for the car that wants to get into the parking lot. carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively. A car can only park in a parking space of its carType. If there is no space available, return false, else park the car in that size space and return true.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * [[1, 1, 0], [1], [2], [3], [1]]
 * Output
 * [null, true, true, false, false]
 * <p>
 * Explanation
 * ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
 * parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
 * parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
 * parkingSystem.addCar(3); // return false because there is no available slot for a small car
 * parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.
 */
public class DesignParkingSystem1603 {
    private final int totalSpaceForBig;
    private final int totalSpaceForMedium;
    private final int totalSpaceForSmall;

    private int currentSpaceForBig = 0;
    private int currentSpaceForMedium = 0;
    private int currentSpaceForSmall = 0;

    /**
     * Объявили переменные
     */
    enum CarType {
        BIG(1), MEDIUM(2), SMALL(3);
        private final int type;

        CarType(int a) {
            this.type = a;
        }
    }

    public DesignParkingSystem1603(int big, int medium, int small) {
        this.totalSpaceForBig = big;
        this.totalSpaceForMedium = medium;
        this.totalSpaceForSmall = small;
    }

    public boolean addCar(int carType) {

        if (!isAvailableSpaceExist(CarType.valueOf(Integer.toString(carType)))) {
            return false;
        }

        if (carType == CarType.BIG.type) {
            currentSpaceForBig++;
        } else if (carType == CarType.MEDIUM.type) {
            currentSpaceForMedium++;
        } else {
            currentSpaceForSmall++;
        }

        return true;
    }

    private boolean isAvailableSpaceExist(CarType carType) {
        if (carType == CarType.BIG) {
            return totalSpaceForBig < currentSpaceForBig;
        } else if (carType == CarType.MEDIUM) {
            return totalSpaceForMedium < currentSpaceForMedium;
        } else {
            return totalSpaceForSmall < currentSpaceForSmall;
        }
    }
}


/**
 * В этом решение считаем, что если 0 то парковаться не можем.
 * 1. Инифиализировали разер парковки
 * 2. и далее сравниваем тип, и если наш размер каждого типа больше чем 0 то мы уменьшаем количество свободных парковок и возвращаем true
 * 3. в противном случаее возвращаем false
 *
 * class ParkingSystem {
 *     int big = 0,  medium = 0, small = 0;
 *     public ParkingSystem(int big, int medium, int small) {
 *         this.big = big;
 *         this.medium = medium;
 *         this.small = small;
 *     }
 *
 *     public boolean addCar(int carType) {
 *         if(carType == 1 && big > 0){
 *             big--;
 *             return true;
 *         }
 *         else if(carType == 2 && medium > 0 ){
 *             medium--;
 *             return true;
 *         }
 *         else if(carType == 3 && small > 0){
 *             small --;
 *             return true;
 *         }
 *         return false;
 *     }
 * }
 */