class Project {
    private String name;
    private String description;
    private double initialCost = 0;
    public Project() {}
    public Project(String projectName){
        this.name = projectName;
    }
    public Project(String projectName, String projectDescription, double projectCost) {
        this.name = projectName;
        this.description = projectDescription;
        this.initialCost = projectCost;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public double getCost() {
        return this.initialCost;
    }
    public void setName(String projectName) {
        this.name = projectName;
    }
    public void setDescription(String projectDescription) {
        this.description = projectDescription;
    }
    public void setCost(double cost) {
        this.initialCost = cost;
    }

    public String ElevatorPitch() {
        return String.format(("%s %s %f"), name, description, initialCost);
    }
}