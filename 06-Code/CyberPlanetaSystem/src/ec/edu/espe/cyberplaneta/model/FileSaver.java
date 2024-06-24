package ec.edu.espe.cyberplaneta.model;

public class FileSaver {

    private int numberOfFile;

    public FileSaver(int numberOfFile) {
        this.numberOfFile = numberOfFile;
    }

    @Override
    public String toString() {
        return "FileSaver{" + "numberOfFile=" + getNumberOfFile() + '}';
    }
    public static void saveFile(){
        //method to be done when the program starts using FRM 
    }
    public int getNumberOfFile() {
        return numberOfFile;
    }

    public void setNumberOfFile(int numberOfFile) {
        this.numberOfFile = numberOfFile;
    }
}
