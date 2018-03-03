package me.protophite.core.gui;

public interface GuiEditor {

    public void setEditor(GuiEditor editor);
    public GuiEditor getEditor();
    HotbarEditor newInstance();


}
