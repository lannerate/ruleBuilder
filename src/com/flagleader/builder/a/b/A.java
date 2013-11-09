package com.flagleader.builder.a.b;

import com.flagleader.builder.dialogs.f;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class A extends f
{
  private String b = "";
  private int c = 0;
  private Combo d;

  public A(e parame, String paramString, int paramInt)
  {
    super(Display.getCurrent().getActiveShell());
    if (paramString != null)
      this.b = paramString;
    this.c = paramInt;
  }

  public String a()
  {
    return this.b;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.d = b(localComposite, this.a.n()[this.c], 2048, 280, 12, 2);
    this.d.setItems(e.a(this.a, this.c));
    if (this.d.getItemCount() < 30)
      this.d.setVisibleItemCount(this.d.getItemCount());
    else
      this.d.setVisibleItemCount(30);
    if (this.b != null)
      this.d.setText(this.b);
    return localComposite;
  }

  protected void okPressed()
  {
    this.b = this.d.getText();
    close();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.A
 * JD-Core Version:    0.6.0
 */