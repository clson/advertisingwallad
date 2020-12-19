package model;

//封装若干歌广告(广告牌)
public class AdvertisingBoard {
    private Advertisement[] advertisement=null;
    int index=-1;

    public Advertisement getAdvertisement(int i) {
        if (advertisement==null){
            return null;
        }
        if (advertisement.length==0){
            return null;
        }
        if (i>=advertisement.length||i<0){
            return null;
        }
        return advertisement[i];
    }
    //下一个
    public Advertisement nextAdvertisement(){
        index++;
        if (advertisement==null){
            return null;
        }
        if (advertisement.length==0){
            return null;
        }
        if (index==advertisement.length){
            index=0; //循环
        }
        return advertisement[index];
    }
    //上一个
    public Advertisement previousAdveriserment(){
        index--;
        if (advertisement==null){
            return null;
        }
        if (advertisement.length==0){
            return null;
        }
        if (index<0){
            index=advertisement.length-1;
        }
        return advertisement[index];
    }

    public void setAdvertisements(Advertisement[] advertisements) {
        this.advertisement = advertisements;
    }
}
