package domain;

import java.io.Serializable;
import java.sql.Timestamp;


public class Bookmark implements Serializable{
    private int id;
    private int owner_id;
    private String title;
    private Timestamp date_created;
    private Timestamp date_updated;
    private String url;
    private String preview;
    private String description;
    private int catalog_id;

    public Bookmark() {
    }

    public Bookmark(int id, int owner_id, String title, Timestamp date_created,
                    Timestamp date_updated, String url, String preview, String description, int catalog_id) {
        this.id = id;
        this.owner_id = owner_id;
        this.title = title;
        this.date_created = date_created;
        this.date_updated = date_updated;
        this.url = url;
        this.preview = preview;
        this.description = description;
        this.catalog_id = catalog_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDate_created() {
        return date_created;
    }

    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }

    public Timestamp getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(Timestamp date_updated) {
        this.date_updated = date_updated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(int catalog_id) {
        this.catalog_id = catalog_id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bookmark{");
        sb.append("id=").append(id);
        sb.append(", owner_id=").append(owner_id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", date_created=").append(date_created);
        sb.append(", date_updated=").append(date_updated);
        sb.append(", url='").append(url).append('\'');
        sb.append(", preview='").append(preview).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", catalog_id='").append(catalog_id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
