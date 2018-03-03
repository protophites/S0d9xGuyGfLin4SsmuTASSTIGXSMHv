package me.protophite.core.data.flatfile;

public class ResourceFile {
    private String resourcePath = "resource/";
    private final String fileName;
    private final boolean override;

    public ResourceFile(String fileName, boolean override){
        this.resourcePath += fileName;
        this.fileName = fileName;
        this.override = override;
    }

    public boolean isOverride(){return override;}
    public String getResourcePath(){return resourcePath;}
    public String getFileName(){return fileName;}

}
