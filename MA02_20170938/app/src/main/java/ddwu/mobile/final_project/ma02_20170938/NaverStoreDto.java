package ddwu.mobile.final_project.ma02_20170938;


import java.io.Serializable;

public class NaverStoreDto implements Serializable {

    private int _id;
    private String title;
    private String category;

    private String telephone;
    private String address;
    private String roadAddress;
    private int mapx;
    private int mapy;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(String roadAddress) {
        this.roadAddress = roadAddress;
    }

    public int getMapx() {
        return mapx;
    }

    public void setMapx(int mapx) {
        this.mapx = mapx;
    }

    public int getMapy() {
        return mapy;
    }

    public void setMapy(int mapy) {
        this.mapy = mapy;
    }

    @Override
    public String toString() {
        return "NaverStoreDto{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", roadAddress='" + roadAddress + '\'' +
                ", mapx=" + mapx +
                ", mapy=" + mapy +
                '}';
    }
}
