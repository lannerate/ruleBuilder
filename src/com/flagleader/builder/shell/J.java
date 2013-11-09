package com.flagleader.builder.shell;

import com.flagleader.builder.widget.h;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class J
{
  Shell a;
  private String c;
  private Composite d;
  L b;

  public J(String paramString, L paramL)
  {
    this.c = paramString;
    this.b = paramL;
  }

  public J()
  {
  }

  public void a()
  {
  }

  void a(Display paramDisplay)
  {
    this.a = new Shell(paramDisplay);
    if (this.c != null)
      this.a.setText(this.c);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    this.a.setLayout(localGridLayout);
    this.a.addShellListener(new K(this));
  }

  private Composite b()
  {
    this.d = new Composite(this.a, 0);
    this.d.setLayout(h.a(1));
    this.d.setLayoutData(new GridData(1808));
    if (this.b != null)
      this.b.a(this.d);
    return this.d;
  }

  public Composite b(Display paramDisplay)
  {
    a(paramDisplay);
    Composite localComposite = b();
    this.a.setSize(800, 600);
    this.a.open();
    return localComposite;
  }

  void a(String paramString)
  {
    MessageBox localMessageBox = new MessageBox(this.a, 1);
    localMessageBox.setMessage(paramString);
    localMessageBox.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.J
 * JD-Core Version:    0.6.0
 */