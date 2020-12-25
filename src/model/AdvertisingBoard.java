package model;

import java.util.List;

//封装若干个广告(广告牌)
public class AdvertisingBoard {
//    private Advertisement[] advertisement=null;
    private List<Advertisement> advertisement=null;
    int index=-1;

    public Advertisement getAdvertisement(int i) {
        if (advertisement==null){
            return null;
        }
        if (advertisement.size()==0){
            return null;
        }
        if (i>=advertisement.size()||i<0){
            return null;
        }
        return advertisement.get(i);
    }
    //下一个
    public Advertisement nextAdvertisement(){
        index++;
        if (advertisement==null){
            return null;
        }
        if (advertisement.size()==0){
            return null;
        }
        if (index==advertisement.size()){
            index=0; //循环
        }
        return advertisement.get(index);
    }
    //上一个
    public Advertisement previousAdvertisement(){
        index--;
        if (advertisement==null){
            return null;
        }
        if (advertisement.size()==0){
            return null;
        }
        if (index<0){
            index=advertisement.size()-1;
        }
        return advertisement.get(index);
    }

    public void setAdvertisement(List<Advertisement> advertisements) {
        this.advertisement = advertisements;
    }
}
