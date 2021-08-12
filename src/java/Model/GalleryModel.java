
package Model;

import java.util.List;

public class GalleryModel {

    private int id;
    private String title;
    private String description;
    List<ImageModel> listImages;
    private String name;
    private String url;

    public GalleryModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ImageModel> getListImages() {
        return listImages;
    }

    public void setListImages(List<ImageModel> listImages) {
        this.listImages = listImages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
