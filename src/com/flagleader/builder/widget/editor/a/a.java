package com.flagleader.builder.widget.editor.a;

import com.flagleader.builder.widget.editor.d;
import com.flagleader.builder.widget.editor.s;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;

public class a extends Action
{
  private s a;

  public a(s params)
  {
    super("帮助@Ctrl+O");
    setImageDescriptor(ImageDescriptor.createFromFile(d.class, "icons\\help.gif"));
    this.a = params;
  }

  public void run()
  {
    com.flagleader.builder.widget.editor.b.a locala = new com.flagleader.builder.widget.editor.b.a(Display.getCurrent().getActiveShell());
    locala.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.a.a
 * JD-Core Version:    0.6.0
 */