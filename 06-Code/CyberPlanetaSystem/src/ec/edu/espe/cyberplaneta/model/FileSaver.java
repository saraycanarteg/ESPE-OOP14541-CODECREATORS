
package ec.edu.espe.cyberplaneta.model;

/**
 *
 * @author Code Creators,DCCO-ESPE
 */
public class FileSaver {

    private int numberOfFile;

    public FileSaver(int numberOfFile) {
        this.numberOfFile = numberOfFile;
    }

    @Override
    public String toString() {
        return "FileSaver{" + "numberOfFile=" + getNumberOfFile() + '}';
    }

    /**
     * @return the numberOfFile
     */
    public int getNumberOfFile() {
        return numberOfFile;
    }

    /**
     * @param numberOfFile the numberOfFile to set
     */
    public void setNumberOfFile(int numberOfFile) {
        this.numberOfFile = numberOfFile;
    }

}
