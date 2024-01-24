package entity;

public class Instrument {
    String id;
    String name;
    String typeId;
    String typeName;
    String categoryId;
    String categoryName;
    String preview;
    float price;

    public Instrument(String id, String name, String typeId, String typeName, String categoryId, String categoryName,
            String preview, float price) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.typeName = typeName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.preview = preview;
        this.price = price;
    }

    public Instrument(String name, String typeId, String categoryId,
            String preview, float price) {
        this.name = name;
        this.typeId = typeId;
        this.categoryId = categoryId;
        this.preview = preview;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPreview() {
        return this.preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
