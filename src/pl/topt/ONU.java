package pl.topt;

import java.util.Random;

public class ONU {
    
    private Integer id;
    private Integer data = 0;
    private Integer averageBitrate;

    public Integer getAverageBitrate() {
        return averageBitrate;
    }

    public void setAverageBitrate(Integer averageBitrate) {
        this.averageBitrate = averageBitrate;
    }

    public ONU(Integer id) {
        this.id = id;
        this.averageBitrate = new Random().nextInt(10000);
        countData();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
    
    public void countData() {
        int gaussian = -1;
        while (gaussian < 0) {
            gaussian = (int) new Random().nextGaussian() + averageBitrate;
        }
        data += gaussian;
    }
    
    public int removeData(int dataToRemove) {
        if (data < dataToRemove) {
            dataToRemove = data;
        }
        data-=dataToRemove;
        return dataToRemove;
    }
    
    public int removeAllData() {
        int removedAllData = data;
        data = 0;
        return removedAllData;
    }
}
