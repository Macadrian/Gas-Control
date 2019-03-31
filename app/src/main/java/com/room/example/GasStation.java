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
    private Double mPrice;

    /**
     * The private String variable of the address.
     */
    private String mAddress;
    private String mName;
    private String mLength;
    private String mLatitud;

    /**
     * @param price parameter of price to put on the listView item.
     * @param address parameter of the address to put on the listView item.
     */
    public GasStation(Double price, String address, String name, String length, String latitud) {
        mPrice = price;
        mAddress = address;
        mLatitud = latitud;
        mLength = length;
        mName = name;
    }

    public Double getPrice() {
        return mPrice;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getName() {
        return mName;
    }

    public String getLength() {
        return mLength;
    }

    public String getLatitud() {
        return mLatitud;
    }
}
