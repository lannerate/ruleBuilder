package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.rlm.editen.ISheetDynamicEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

class aZ extends f
{
  private Combo b;
  private Combo c;
  private int d;
  private List e;
  private boolean f = false;
  private int g;

  public aZ(aK paramaK)
  {
    super(Display.getCurrent().getActiveShell());
    this.g = 0;
    this.d = 0;
    this.e = aK.a(paramaK).getCanSelectSourceFields();
    this.f = true;
  }

  public aZ(aK paramaK, int paramInt1, int paramInt2)
  {
    super(Display.getCurrent().getActiveShell());
    this.g = paramInt2;
    this.d = paramInt1;
    this.e = aK.a(paramaK).getCanSelectSourceFields();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.c = b(localComposite, "mappingfield.SelectSheetAndFieldsDialog", 2048, 280, 12, 2);
    String[] arrayOfString = new String[this.e.size()];
    for (int i = 0; i < this.e.size(); i++)
      arrayOfString[i] = ((IBusinessObject)this.e.get(i)).getDisplayName();
    this.c.setItems(arrayOfString);
    if (this.c.getItemCount() < 20)
      this.c.setVisibleItemCount(this.c.getItemCount());
    else
      this.c.setVisibleItemCount(20);
    if (this.d >= 0)
      this.c.select(this.d);
    if (this.f)
      this.c.addSelectionListener(new ba(this));
    this.b = b(localComposite, "field.SelectSheetAndFieldsDialog", 2048, 280, 12, 2);
    this.b.setItems(aK.b(this.a));
    if (this.b.getItemCount() < 20)
      this.b.setVisibleItemCount(this.b.getItemCount());
    else
      this.b.setVisibleItemCount(20);
    if (this.g >= 0)
      this.b.select(this.g);
    if (this.f)
      this.b.addSelectionListener(new bb(this, arrayOfString));
    return localComposite;
  }

  protected void okPressed()
  {
    this.g = this.b.getSelectionIndex();
    this.d = this.c.getSelectionIndex();
    close();
  }

  public int a()
  {
    return this.g;
  }

  public IBusinessObject b()
  {
    return (IBusinessObject)this.e.get(this.d);
  }

  public int c()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aZ
 * JD-Core Version:    0.6.0
 */