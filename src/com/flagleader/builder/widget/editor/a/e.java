package com.flagleader.builder.widget.editor.a;

import com.flagleader.builder.widget.editor.d;
import com.flagleader.builder.widget.editor.j;
import com.flagleader.builder.widget.editor.s;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

public class e extends Action
{
  private s a;

  public e(s params)
  {
    super("保存@Ctrl+S");
    setImageDescriptor(ImageDescriptor.createFromFile(d.class, "icons\\save.gif"));
    this.a = params;
  }

  public void run()
  {
    this.a.o().b();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.a.e
 * JD-Core Version:    0.6.0
 */