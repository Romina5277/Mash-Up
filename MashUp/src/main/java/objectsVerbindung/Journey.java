package objectsVerbindung;

public class Journey {
    private String name;
    private String category;
    private String subcategory;
    private int categoryCode;
    private String number;
    private String operator;
    private String to;
    private Stop[] passList;
    private String capacity1st;
    private String capacity2nd;

    public Stop[] getPassList() {
        return passList;
    }

    public void setPassList(Stop[] passList) {
        this.passList = passList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCapacity1st() {
        return capacity1st;
    }

    public void setCapacity1st(String capacity1st) {
        this.capacity1st = capacity1st;
    }

    public String getCapacity2nd() {
        return capacity2nd;
    }

    public void setCapacity2nd(String capacity2nd) {
        this.capacity2nd = capacity2nd;
    }
}
