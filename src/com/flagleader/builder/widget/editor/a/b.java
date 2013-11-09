package com.flagleader.builder.widget.editor.a;

import com.flagleader.builder.widget.editor.d;
import com.flagleader.builder.widget.editor.j;
import com.flagleader.builder.widget.editor.s;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

public class b extends Action
{
  private s a;

  public b(s params)
  {
    super("打开@Ctrl+O");
    setImageDescriptor(ImageDescriptor.createFromFile(d.class, "icons\\open.gif"));
    this.a = params;
  }

  public void run()
  {
    this.a.o().a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.a.b
 * JD-Core Version:    0.6.0
 */