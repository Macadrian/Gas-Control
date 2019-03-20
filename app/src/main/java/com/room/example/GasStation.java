package com.room.example;

/**
 * Custom class for the population of the Custom Adapter and the ListView
 *
 * {@link GasStation} represents a price and an address of a Gas Station
 * in the area that we searched for.
 */
public class GasStation {

    /**
     * The private float variable of the price.
     */
    private float mPrice;

    /**
     * The private String variable of the address.
     */
    private String mAddress;

    /**
     * @param price parameter of price to put on the listView item.
     * @param address parameter of the address to put on the listView item.
     */
    public GasStation(float price, String address) {
        mPrice = price;
        mAddress = address;
    }

    /**
     * @return Getter of the price.
     */
    public float getPrice() {
        return mPrice;
    }

    /**
     * @return Getter of the address.
     */
    public String getAddress() {
        return mAddress;
    }
}
