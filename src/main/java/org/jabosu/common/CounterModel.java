package org.jabosu.common;

//import info.archinnov.achilles.annotations.*;
//import info.archinnov.achilles.type.Counter;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;

import com.datastax.driver.mapping.annotations.PartitionKey;

/**
 * Created by satya on 2/8/15.
 */
public class CounterModel {

    @PartitionKey(value = 0)
    public String folder;

   // @Enumerated(EnumType.STRING)
    @ClusteringColumn(value = 0)
    @Column(name = "counter_type")
    public String counterType;

    @ClusteringColumn(value = 1)
    @Column(name="split_id")
    public int splitId;

    @Column(name = "counter")
    public Long counter;



    public CounterModel() {
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getCounterType() {
        return counterType;
    }

    public void setCounterType(String counterType) {
        this.counterType = counterType;
    }

    public int getSplitId() {
        return splitId;
    }

    public void setSplitId(int splitId) {
        this.splitId = splitId;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    //    public CounterKey getId() {
//        return id;
//    }
//
//    public void setId(CounterKey id) {
//        this.id = id;
//    }

//    public Counter getCounter() {
//        return counter;
//    }
//
//    public void setCounter(Counter counter) {
//        this.counter = counter;
//    }

//    public static class CounterKey {
//
//        @PartitionKey(value = 1)
//        public String folder;
//
//        @ClusteringColumn(value = 1)
//        @JSON
//        public CounterType counterType;
//
//        @ClusteringColumn(value = 2)
//        public int splitId;
//
//        public CounterKey() {}
//
//        public CounterKey(String folder, CounterType counterType, int splitId) {
//            this.folder = folder;
//            this.splitId = splitId;
//            this.counterType = counterType;
//        }
//
//        public CounterKey(String folder, CounterType counterType) {
//            this.folder = folder;
//            this.counterType = counterType;
//        }
//
//        public String getFolder() {
//            return folder;
//        }
//
//        public void setFolder(String folder) {
//            this.folder = folder;
//        }
//
//        public int getSplitId() {
//            return splitId;
//        }
//
//        public void setSplitId(int splitId) {
//            this.splitId = splitId;
//        }
//
//        public CounterType getCounterType() {
//            return counterType;
//        }
//
//        public void setCounterType(CounterType counterType) {
//            this.counterType = counterType;
//        }
//    }

}
