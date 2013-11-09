package com.flagleader.builder.a.d;

import com.flagleader.builder.dialogs.f;
import com.flagleader.export.PagesMessages;
import com.flagleader.repository.export.IPage;
import java.util.HashMap;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

class aO extends f
{
  private Text b;
  private Text c;
  private Combo d;
  private String e;
  private String f;
  private String g;
  private String[] h = null;
  private String[] i = null;

  public aO(aI paramaI)
  {
    super(Display.getCurrent().getActiveShell());
    this.e = "";
    this.f = "";
    this.g = "";
  }

  public aO(aI paramaI, String paramString1, String paramString2, String paramString3)
  {
    super(Display.getCurrent().getActiveShell());
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    HashMap localHashMap = new HashMap();
    this.h = this.a.e().getPreferences().getStringArray(this.a.e().getImportFile() + ".keys");
    if (this.h == null)
      this.h = this.a.e().getPreferences().getStringArray("export.keys");
    this.i = new String[this.h.length];
    for (int j = 0; j < this.h.length; j++)
      this.i[j] = this.a.e().getPreferences().getString(this.h[j] + ".kvalue", this.h[j]);
    for (j = 0; (this.h != null) && (this.i != null) && (j < this.h.length); j++)
      localHashMap.put(this.h[j], this.i[j]);
    this.d = b(localComposite, "describe.DataDialog", 2048, 280, 12, 2);
    if (this.i != null)
      this.d.setItems(this.i);
    if (this.d.getItemCount() < 20)
      this.d.setVisibleItemCount(this.d.getItemCount());
    else
      this.d.setVisibleItemCount(20);
    if (this.g != null)
      this.d.setText(this.g);
    this.d.addSelectionListener(new aP(this));
    this.c = a(localComposite, "key.ExportDialog", 2048, 300, 12, 2);
    this.c.setText(this.e);
    this.c.selectAll();
    this.b = a(localComposite, "value.ExportDialog", 2048, 300, 12, 2);
    this.b.setText(this.f);
    this.b.selectAll();
    return localComposite;
  }

  protected void okPressed()
  {
    this.e = this.c.getText();
    this.f = this.b.getText();
    this.g = this.d.getText();
    close();
  }

  public String a()
  {
    return this.e;
  }

  public String b()
  {
    return this.f;
  }

  public String c()
  {
    return this.g;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.aO
 * JD-Core Version:    0.6.0
 */