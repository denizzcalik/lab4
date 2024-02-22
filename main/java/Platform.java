package Lab3.main.java;

public class Platform implements Attachment {
    private int platformAngle;

    public Platform(){
        this.platformAngle = 0;
    }

    @Override
    public int getState(){
        return this.platformAngle;
    }
    @Override
    public void raiseAttachment(){
        this.platformAngle = Math.min(getState() + 10, 70);
    }
    @Override
    public void lowerAttachment(){
        this.platformAngle = Math.max(getState() - 10, 0);
    }
    
    @Override
    public Boolean attachmentInUse(){
        return this.platformAngle > 0;
    }


}

