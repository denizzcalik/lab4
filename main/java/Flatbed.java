package Lab3.main.java;

public class Flatbed implements Attachment {
    private int state;

    public Flatbed() {
        this.state = 0;
    }

    @Override
    public Boolean attachmentInUse(){
        return this.state > 0;
    }
    @Override
    public void raiseAttachment() {
        this.state = 1;
    }
    @Override
    public void lowerAttachment(){
        this.state = 0;
    }
    @Override
    public int getState(){
        return this.state;
    }

}
