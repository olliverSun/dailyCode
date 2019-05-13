public class ElementData {
    private String elements;
    private String imfluname;



    ElementData(String elements,String imfluname){

        setImfluname(imfluname);
        setElements(elements);
    }
    public String getElements() {
        return elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

    public String getImfluname() {
        return imfluname;
    }

    public void setImfluname(String imfluname) {
        this.imfluname = imfluname;
    }
}
