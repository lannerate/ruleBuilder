package com.flagleader.builder.widget.editor.a;

import com.flagleader.builder.widget.editor.d;
import com.flagleader.builder.widget.editor.s;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.custom.StyledText;

public class c extends Action
{
  private s a;

  public c(s params)
  {
    super("打印@Ctrl+P");
    setImageDescriptor(ImageDescriptor.createFromFile(d.class, "icons\\print.gif"));
    this.a = params;
  }

  public void run()
  {
    this.a.n().getTextWidget().print();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.a.c
 * JD-Core Version:    0.6.0
 */