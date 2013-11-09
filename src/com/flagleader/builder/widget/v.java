package com.flagleader.builder.widget;

import com.flagleader.builder.dialogs.f;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

class v extends f
{
  private Text b;
  private Combo c;
  private String d = "";
  private String e = "";
  private int f = -1;
  private Button g;
  private boolean h = false;

  public v(s params)
  {
    super(Display.getCurrent().getActiveShell());
    this.d = s.a(params);
    this.e = "";
    this.h = s.b(params);
  }

  public v(s params, String paramString1, String paramString2)
  {
    super(Display.getCurrent().getActiveShell());
    this.d = paramString1;
    this.e = paramString2;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.c = b(localComposite, "type.RuleLogViewer", 2048, 280, 12, 2);
    this.c.setItems(s.c(this.a));
    if (this.c.getItemCount() < 20)
      this.c.setVisibleItemCount(this.c.getItemCount());
    else
      this.c.setVisibleItemCount(20);
    if (this.e != null)
      this.c.setText(this.e);
    this.b = a(localComposite, "disName.RuleLogViewer", 2048, 300, 12, 2);
    this.b.setText(this.d);
    this.b.selectAll();
    this.b.forceFocus();
    this.g = new Button(localComposite, 32);
    this.g.setText(b("onlyshow.RuleLogViewer"));
    return localComposite;
  }

  protected void okPressed()
  {
    if (this.b.getText().length() > 0)
    {
      this.d = this.b.getText();
      this.e = this.c.getText();
      this.f = this.c.getSelectionIndex();
      this.h = this.g.getSelection();
      close();
    }
  }

  public String a()
  {
    return this.d;
  }

  public String b()
  {
    return this.e;
  }

  public int c()
  {
    return this.f;
  }

  public boolean d()
  {
    return this.h;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.v
 * JD-Core Version:    0.6.0
 */