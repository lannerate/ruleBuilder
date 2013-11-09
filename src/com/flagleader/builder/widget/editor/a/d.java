package com.flagleader.builder.widget.editor.a;

import com.flagleader.builder.widget.editor.s;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.IUndoManager;

public class d extends Action
{
  private s a;

  public d(s params)
  {
    super("重做@Ctrl+Y");
    setImageDescriptor(ImageDescriptor.createFromFile(com.flagleader.builder.widget.editor.d.class, "icons\\redo.gif"));
    this.a = params;
  }

  public void run()
  {
    this.a.q().redo();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.a.d
 * JD-Core Version:    0.6.0
 */