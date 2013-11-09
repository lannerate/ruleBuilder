package com.flagleader.builder.widget.editor.a;

import com.flagleader.builder.widget.editor.b.b;
import com.flagleader.builder.widget.editor.d;
import com.flagleader.builder.widget.editor.s;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;

public class f extends Action
{
  private s a;

  public f(s params)
  {
    super("查找\\替换@Ctrl+F");
    setImageDescriptor(ImageDescriptor.createFromFile(d.class, "icons\\search.gif"));
    this.a = params;
  }

  public void run()
  {
    new b(this.a, Display.getCurrent().getActiveShell()).open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.a.f
 * JD-Core Version:    0.6.0
 */