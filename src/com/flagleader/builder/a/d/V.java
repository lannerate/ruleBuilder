package com.flagleader.builder.a.d;

import com.flagleader.builder.dialogs.f;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

class V extends f
{
  private Text c;
  private Text d;
  private Combo e;
  private String f = "";
  private String g = "";
  int a = 0;
  private String[] h = null;
  private String[] i = null;

  public V(P paramP)
  {
    super(Display.getCurrent().getActiveShell());
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.e = b(localComposite, "elementType.JspElementEditor", 2056, 280, 12, 2);
    this.e.setItems(P.a(this.b, "elementType.choise"));
    if (this.e.getItemCount() < 20)
      this.e.setVisibleItemCount(this.e.getItemCount());
    else
      this.e.setVisibleItemCount(20);
    if (this.a >= 0)
      this.e.select(this.a);
    this.c = a(localComposite, "DisplayName.JspElementEditor", 2048, 300, 12, 2);
    this.c.setText(this.g);
    this.c.selectAll();
    return localComposite;
  }

  protected void okPressed()
  {
    this.g = this.c.getText();
    this.a = this.e.getSelectionIndex();
    close();
  }

  public String a()
  {
    return this.f;
  }

  public String b()
  {
    return this.g;
  }

  public int c()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.V
 * JD-Core Version:    0.6.0
 */