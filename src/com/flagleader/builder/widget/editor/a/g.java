package com.flagleader.builder.widget.editor.a;

import com.flagleader.builder.widget.editor.d;
import com.flagleader.builder.widget.editor.s;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.IUndoManager;

public class g extends Action
{
  private s a;

  public g(s params)
  {
    super("撤销@Ctrl+Z");
    setImageDescriptor(ImageDescriptor.createFromFile(d.class, "icons\\undo.gif"));
    this.a = params;
  }

  public void run()
  {
    this.a.q().undo();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.a.g
 * JD-Core Version:    0.6.0
 */