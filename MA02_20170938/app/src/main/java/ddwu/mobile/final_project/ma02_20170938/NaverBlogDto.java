package ddwu.mobile.final_project.ma02_20170938;

import java.io.Serializable;

public class NaverBlogDto implements Serializable {
    private int _id;
    private String title;
    private String link;
    private String description;
    private String bloggername;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBloggername() {
        return bloggername;
    }

    public void setBloggername(String bloggername) {
        this.bloggername = bloggername;
    }

    @Override
    public String toString() {
        return "NaverBlogDto{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", bloggername='" + bloggername + '\'' +
                '}';
    }
}
