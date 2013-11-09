package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

class S extends f
{
  private Combo b;
  private Combo c;
  private int d = 0;
  private String e;
  private List f;
  private List g;
  private int h = 0;
  private boolean i = false;
  private String j = "";

  public S(C paramC)
  {
    super(Display.getCurrent().getActiveShell());
    if (C.a(paramC).getSourceSheet() != null)
      this.f = C.a(paramC).getCanSelectSourceFields();
    else
      this.f = new ArrayList();
    this.g = C.a(paramC).getCanSelectFields();
    this.i = true;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    String[] arrayOfString1 = new String[this.g.size() + 1];
    arrayOfString1[0] = "";
    for (int k = 0; k < this.g.size(); k++)
      arrayOfString1[(k + 1)] = ((IBusinessObject)this.g.get(k)).getDisplayName();
    String[] arrayOfString2 = new String[this.f.size()];
    for (int m = 0; m < this.f.size(); m++)
      arrayOfString2[m] = ((IBusinessObject)this.f.get(m)).getDisplayName();
    if (C.a(this.a).getSourceSheet() != null)
    {
      this.c = b(localComposite, "sourcefield.SelectRulePackageDialog", 2056, 280, 12, 2);
      this.c.setItems(arrayOfString2);
      if (this.c.getItemCount() < 20)
        this.c.setVisibleItemCount(this.c.getItemCount());
      else
        this.c.setVisibleItemCount(20);
      if (this.d >= 0)
        this.c.select(this.d);
    }
    else
    {
      this.c = b(localComposite, "sourcefield.SelectRulePackageDialog", 2048, 280, 12, 2);
    }
    if (this.i)
      this.c.addSelectionListener(new T(this, arrayOfString1));
    this.b = b(localComposite, "thisfield.SelectRulePackageDialog", 2048, 280, 12, 2);
    this.b.setItems(arrayOfString1);
    if (this.b.getItemCount() < 20)
      this.b.setVisibleItemCount(this.b.getItemCount());
    else
      this.b.setVisibleItemCount(20);
    if (this.h >= 1)
      this.b.select(this.h);
    if (this.i)
      this.b.addSelectionListener(new U(this, arrayOfString2));
    return localComposite;
  }

  protected void okPressed()
  {
    this.h = this.b.getSelectionIndex();
    this.d = this.c.getSelectionIndex();
    this.j = this.b.getText();
    this.e = this.c.getText();
    if (this.h >= 0)
      close();
  }

  public int a()
  {
    return this.h;
  }

  public String b()
  {
    return this.e;
  }

  public IBusinessObject c()
  {
    if (this.d >= 0)
      return (IBusinessObject)this.f.get(this.d);
    return null;
  }

  public IBusinessObject d()
  {
    if (this.h > 1)
      return (IBusinessObject)this.g.get(this.h - 1);
    return null;
  }

  public String e()
  {
    return this.j;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.S
 * JD-Core Version:    0.6.0
 */