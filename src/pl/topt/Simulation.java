package pl.topt;

import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    
    private int simulationTime;
    private int numberOfONUS;
    private ArrayList<ONU> onuList;


    public Simulation(int simulationTime, int numberOfONUS) {
        this.simulationTime = simulationTime;
        this.numberOfONUS = numberOfONUS;
    }
    
    
    public void TDMASimulation() {

        OLT olt = new OLT(numberOfONUS);
        initializeONUs();
        
        long currentTimestamp = System.currentTimeMillis();
        int maxSlotDataTDMA = olt.getMaxSlotDataTDMA();
        int data = 0;
        
        for (int i = 0; i < 8000; i++) {   
            for (ONU onu : onuList) {
                data += onu.removeData(maxSlotDataTDMA);
                onu.countData();
            }
            
        }
        System.out.println(data/1000/1000);
    }
    
    public void DBASimulation() {
        //OLT olt = new OLT(numberOfONUS);
        initializeONUs();
//        int sumOfData = 
        countSumOfData();
        int data = 0;
        
        double partitionFactor = OLT.DATA_PER_SIMULATION_TACT / countSumOfData();
        //System.out.println("First partitionFactor=" + partitionFactor + ", DATA_PER_SIMULATION_TACT=" + OLT.DATA_PER_SIMULATION_TACT + ", sumOfData=" + sumOfData);
        
        for(int i = 0; i < 8000; i++) {
            System.out.println("partitionFactor=" + partitionFactor);
            if(partitionFactor > 1) {
               for(ONU onu: onuList) {
                   data+= onu.removeAllData();
                   onu.countData();
               }
            } else {
                for(ONU onu: onuList) {
                   int dataToRemove = (int) (onu.getData() * partitionFactor);
                   data+= onu.removeData(dataToRemove);
                   onu.countData();
                }
            }
            partitionFactor = OLT.DATA_PER_SIMULATION_TACT / countSumOfData();
        }
        System.out.println(data/1000/1000);
    }
    
    private void initializeONUs() {
        onuList = new ArrayList<>();
        for (int i = 0; i < numberOfONUS; i++) {
            onuList.add(new ONU(i));
        }
    }
    
    private int countSumOfData() {
        int sumOfData = 0;
        for(ONU onu: onuList) {
            sumOfData+= onu.getData();
        }
        return sumOfData;
    }
   
    
}
