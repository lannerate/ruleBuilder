package com.flagleader.builder.b;

import com.flagleader.builder.dialogs.r;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;

public class I extends r
{
  private TreeItem a;

  public I(Shell paramShell)
  {
    super(paramShell);
  }

  public I(TreeItem paramTreeItem, Shell paramShell)
  {
    this(paramShell);
    this.a = paramTreeItem;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    localComposite1.setLayout(a(1));
    Composite localComposite2 = new Composite(localComposite1, 0);
    c(localComposite2);
    b(localComposite1);
    Composite localComposite3 = new Composite(localComposite1, 0);
    localComposite3.setLayout(a(3));
    localComposite3.setLayoutData(a(200, 100));
    return localComposite1;
  }

  void c(Composite paramComposite)
  {
    paramComposite.setLayout(a(1));
    a(paramComposite).setText(a("name.dialog") + ":  " + this.a.getText());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b.I
 * JD-Core Version:    0.6.0
 */