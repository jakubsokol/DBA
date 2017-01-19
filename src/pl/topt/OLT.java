package pl.topt;

import java.util.ArrayList;

public class OLT {
    
    private static final double UPSTREAM_SPEED = 1250000000;
    private static final double UPSTREAM_FRAME_PER_SECOND = 8000;
    public static final double DATA_PER_SIMULATION_TACT = UPSTREAM_SPEED / UPSTREAM_FRAME_PER_SECOND;
    private Integer[]       slotData;
    private final double    maxSlotDataTDMA ;
    private Integer         numberOfONUs;
    
    
    
    public int getMaxSlotDataTDMA() {
        return (int) maxSlotDataTDMA;
    }


    public OLT(Integer numberOfONUs) {
        this.numberOfONUs = numberOfONUs;
        maxSlotDataTDMA =  DATA_PER_SIMULATION_TACT /  numberOfONUs;
        System.out.println("maxSlotDataTDMA=" + maxSlotDataTDMA);
        
        slotData = new Integer[numberOfONUs];
        

    }

}
