package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

class bx extends f
{
  private Combo b;
  private Combo c;
  private Combo d;
  private int e;
  private int f;
  private List g;
  private List h;
  private boolean i = false;
  private int j;

  public bx(be parambe)
  {
    super(Display.getCurrent().getActiveShell());
    this.j = 0;
    this.e = 0;
    this.f = 0;
    this.g = be.a(parambe).getCanSelectSourceFields(true);
    this.h = be.a(parambe).getCanSelectSourceFields(false);
    this.i = true;
  }

  public bx(be parambe, int paramInt1, int paramInt2, int paramInt3)
  {
    super(Display.getCurrent().getActiveShell());
    this.j = paramInt3;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = be.a(parambe).getCanSelectSourceFields(true);
    this.h = be.a(parambe).getCanSelectSourceFields(false);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.c = b(localComposite, "afield.SelectSheetFentanDialog", 2048, 280, 12, 2);
    String[] arrayOfString1 = new String[this.g.size()];
    for (int k = 0; k < this.g.size(); k++)
      arrayOfString1[k] = ((IBusinessObject)this.g.get(k)).getDisplayName();
    this.c.setItems(arrayOfString1);
    if (this.c.getItemCount() < 20)
      this.c.setVisibleItemCount(this.c.getItemCount());
    else
      this.c.setVisibleItemCount(20);
    if (this.e >= 0)
      this.c.select(this.e);
    if (this.i)
      this.c.addSelectionListener(new by(this));
    this.d = b(localComposite, "bfield.SelectSheetFentanDialog", 2048, 280, 12, 2);
    String[] arrayOfString2 = new String[this.h.size()];
    for (int m = 0; m < this.h.size(); m++)
      arrayOfString2[m] = ((IBusinessObject)this.h.get(m)).getDisplayName();
    this.d.setItems(arrayOfString2);
    if (this.d.getItemCount() < 20)
      this.d.setVisibleItemCount(this.d.getItemCount());
    else
      this.d.setVisibleItemCount(20);
    if (this.f >= 0)
      this.d.select(this.f);
    if (this.i)
      this.d.addSelectionListener(new bz(this));
    this.b = b(localComposite, "cfield.SelectSheetFentanDialog", 2048, 280, 12, 2);
    this.b.setItems(be.b(this.a));
    if (this.b.getItemCount() < 20)
      this.b.setVisibleItemCount(this.b.getItemCount());
    else
      this.b.setVisibleItemCount(20);
    if (this.j >= 0)
      this.b.select(this.j);
    return localComposite;
  }

  protected void okPressed()
  {
    this.j = this.b.getSelectionIndex();
    this.e = this.c.getSelectionIndex();
    this.f = this.d.getSelectionIndex();
    if ((this.j >= 0) && (this.e >= 0) && (this.f >= 0))
      close();
  }

  public int a()
  {
    return this.j;
  }

  public IBusinessObject b()
  {
    return (IBusinessObject)this.g.get(this.e);
  }

  public int c()
  {
    return this.e;
  }

  public IBusinessObject d()
  {
    if (this.f >= 0)
      return (IBusinessObject)this.h.get(this.f);
    return null;
  }

  public int e()
  {
    return this.f;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bx
 * JD-Core Version:    0.6.0
 */