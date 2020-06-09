package ddwu.mobile.final_project.ma02_20170938;



import java.io.Serializable;

class MyReviewDto implements Serializable {
    private int _id;
    private String title;
    private String image;
    private String review;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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

    public String getReview() {
        return review;
    }

    public void setReview(String myreview) {
        this.review = myreview;
    }
}