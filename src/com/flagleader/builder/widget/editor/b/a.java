package com.flagleader.builder.widget.editor.b;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class a extends Dialog
{
  public a(Shell paramShell)
  {
    super(paramShell);
  }

  protected Control createContents(Composite paramComposite)
  {
    getShell().setSize(200, 150);
    getShell().setText("关于我们");
    paramComposite.setLayout(new GridLayout());
    new Label(paramComposite, 16777216).setText("文本编辑器 Verson 1.0");
    new Label(paramComposite, 16777216).setText("作者：shijq");
    new Label(paramComposite, 131072).setText("2008.4");
    return paramComposite;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.b.a
 * JD-Core Version:    0.6.0
 */