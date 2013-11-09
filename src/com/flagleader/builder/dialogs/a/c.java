package com.flagleader.builder.dialogs.a;

import com.flagleader.builder.dialogs.r;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.m;
import com.flagleader.repository.rom.IBusinessObject;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class c extends r
{
  private IBusinessObject a = null;
  private String b;
  private String c;
  private String d;
  private Text e;
  private Text f;
  private Combo g;

  public c(Shell paramShell, IBusinessObject paramIBusinessObject)
  {
    super(paramShell);
    this.a = paramIBusinessObject;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.AddListElementDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(500, 100));
    a(localComposite2).setText(a("index.AddListElementDialog"));
    this.e = a(localComposite2, 2048, 200, 12);
    a(localComposite2, a("type.AddListElementDialog"));
    this.g = c(localComposite2);
    this.g.setItems(m.a().g().c());
    if (this.g.getItemCount() < 20)
      this.g.setVisibleItemCount(this.g.getItemCount());
    else
      this.g.setVisibleItemCount(20);
    a(localComposite2).setText(a("disElement.AddListElementDialog"));
    this.f = a(localComposite2, 2048, 200, 12);
    return localComposite1;
  }

  private Combo c(Composite paramComposite)
  {
    Combo localCombo = new Combo(paramComposite, 2048);
    GridData localGridData = new GridData();
    localGridData.widthHint = 180;
    localCombo.setLayoutData(localGridData);
    return localCombo;
  }

  protected void okPressed()
  {
    this.b = this.e.getText();
    this.c = this.f.getText();
    this.d = this.g.getText();
    if ((this.b.length() > 0) && (this.c.length() > 0) && (this.d.length() > 0))
      try
      {
        Integer.parseInt(this.b);
        super.okPressed();
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public String c()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.c
 * JD-Core Version:    0.6.0
 */