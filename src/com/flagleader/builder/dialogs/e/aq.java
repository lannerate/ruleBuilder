package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.editen.ISheetAndFieldEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

class aq extends f
{
  private Text b;
  private Combo c;
  private Combo d;
  private Combo e;
  private String f;
  private String g;
  private String h;
  private List i;
  private int j;
  private g k;

  public String a()
  {
    return this.h;
  }

  public aq(Y paramY)
  {
    super(Display.getCurrent().getActiveShell());
    this.f = "";
    this.j = 0;
    this.g = "";
    this.h = "and";
    this.i = Y.a(paramY).getCanSelectSourceFields();
  }

  public aq(Y paramY, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    super(Display.getCurrent().getActiveShell());
    this.f = paramString2;
    this.j = paramInt;
    this.g = paramString1;
    this.h = paramString3;
    this.i = Y.a(paramY).getCanSelectSourceFields();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.c = b(localComposite, "fieldName.SelectSheetWheresDialog", 2056, 280, 12, 2);
    String[] arrayOfString = new String[this.i.size()];
    for (int m = 0; m < this.i.size(); m++)
      arrayOfString[m] = ((IElement)this.i.get(m)).getDisplayName();
    this.c.setItems(arrayOfString);
    if (this.c.getItemCount() < 20)
      this.c.setVisibleItemCount(this.c.getItemCount());
    else
      this.c.setVisibleItemCount(20);
    if (this.j >= 0)
      this.c.select(this.j);
    this.c.addSelectionListener(new ar(this));
    this.d = b(localComposite, "operateName.SelectSheetWheresDialog", 2056, 280, 12, 2);
    if (this.j >= 0)
    {
      this.k = ((IBusinessObject)this.i.get(this.j)).getJavaType();
      this.d.setItems(Y.a(this.a).getTypeFunctions(this.k));
    }
    else
    {
      this.d.setItems(new String[] { "=", "!=" });
    }
    if (this.d.getItemCount() < 20)
      this.d.setVisibleItemCount(this.d.getItemCount());
    else
      this.d.setVisibleItemCount(20);
    if (this.g != null)
      this.d.setText(this.g);
    this.b = a(localComposite, "valueName.SelectSheetWheresDialog", 2048, 300, 12, 2);
    this.b.setText(this.f);
    this.b.selectAll();
    this.e = b(localComposite, "naryType.SelectSheetWheresDialog", 2056, 280, 12, 2);
    this.e.setItems(new String[] { "and", "or" });
    if (this.h != null)
      this.e.setText(this.h);
    return localComposite;
  }

  protected void okPressed()
  {
    this.f = this.b.getText();
    this.j = this.c.getSelectionIndex();
    this.g = this.d.getText();
    this.h = this.e.getText();
    close();
  }

  public String b()
  {
    return this.f;
  }

  public int c()
  {
    return this.j;
  }

  public IBusinessObject d()
  {
    if (this.j >= 0)
      return (IBusinessObject)this.i.get(this.j);
    return null;
  }

  public String e()
  {
    return this.g;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aq
 * JD-Core Version:    0.6.0
 */