package containers;

import java.util.ArrayList;

public class ContainerHistory {
    private ArrayList<Double> containerHistoryRecords;


    public ContainerHistory() {
        containerHistoryRecords = new ArrayList<Double>(); //creates empty arrayList object
    }


    // adds the parameter situation to the end of the container history
    public void add(double situation) {
        containerHistoryRecords.add(situation);
    }


    public double containerHistoryRecordsSum() {
        double sum = 0;
        for (Double record : containerHistoryRecords) {
            sum += record;
        }
        return sum;
    }


    // deletes the containerHistory records
    public void reset() {
        containerHistoryRecords.clear();
    }


    public String toString() {
        return containerHistoryRecords.toString();
    }


    // returns the greatest value in the container history.
    public double maxValue() {
        if (containerHistoryRecords.size() == 0) {
            return 0;                   //If the history is empty, the method return 0
        } else {
            double i = 0;
            for (Double record : containerHistoryRecords) {
                if (record > i) {
                    i = record;
                }
            }
            return i;
        }
    }


    //returns the smallest value in the container history
    public double minValue() {
        if (containerHistoryRecords.size() == 0) {
            return 0;                   //If the history is empty, the method return 0
        } else {
            double i = containerHistoryRecords.get(0);    //initial comparing number is first history record;
            for (Double record : containerHistoryRecords) {
                if (record < i) {
                    i = record;
                }
            }
            return i;
        }
    }


    //returns the average of the values in the container history.
    public double average() {
        if (containerHistoryRecords.size() == 0) {
            return 0;                   //If the history is empty, the method return 0
        } else {
            return containerHistoryRecordsSum() / containerHistoryRecords.size();
        }
    }


    //returns the absolute value of the single greatest fluctuation in the container history.
    public double greatestChange() {
        if (containerHistoryRecords.size() == 0) {
            return 0;                   //If the history is empty, the method return 0
        } else {
            return Math.abs(maxValue() - minValue());
        }
    }


    //returns the sample variance of the container history values
    public double variance() {
        if (containerHistoryRecords.size() == 0 || containerHistoryRecords.size() == 1) {
            return 0;                   //If the history is empty or has only one record, the method return 0
        } else {
            return sampleVariance();
        }
    }


    // sample variance()
    public double sampleVariance() {
        double sumOfDifferencesSquared = 0;
        for (Double record : containerHistoryRecords) {
            record -= average();
            sumOfDifferencesSquared += Math.pow(record, 2);
        }
        return sumOfDifferencesSquared / (containerHistoryRecords.size() - 1);
    }


}
